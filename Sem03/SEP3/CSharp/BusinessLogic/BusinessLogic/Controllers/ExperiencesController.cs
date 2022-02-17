using System;
using System.Threading.Tasks;
using BusinessLogic.Model.Experiences;
using GrpcFileGeneration.Models;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using RiskFirst.Hateoas;

namespace BusinessLogic.Controllers
{
    [Authorize]
    [ApiController]
    [Route("[controller]")]
    public class ExperiencesController : ControllerBase
    {
        private IExperienceModel model;
        private ILinksService linksService;

        public ExperiencesController(ILinksService linksService, IExperienceModel model)
        {
            this.linksService = linksService;
            this.model = model;
        }

        [HttpGet("/Providers/{id:int}/Experiences", Name = "GetProviderExperienceRoute")]
        [Authorize(Roles = "administrator, provider")]
        public async Task<ActionResult<Page<ExperienceList>>> GetProviderExperiences([FromRoute] int id,
            [FromQuery] string name, [FromQuery] int page)
        {
            try
            {
                var experiences = new Page<ExperienceList>();
                if (string.IsNullOrEmpty(name))
                {
                    experiences = await model.GetAllProviderExperiencesAsync(id, page);
                }
                else
                {
                    experiences = await model.GetAllProviderExperiencesByNameAsync(id, name, page);
                }

                await AddLinks(experiences.Content);
                return Ok(experiences);
            }
            catch (Exception e)
            {
                return StatusCode(403, e.Message);
            }
        }

        [HttpGet("/Categories/{id:int}/Experiences", Name = "GetExperienceByCategoryRoute")]
        [Authorize(Roles = "administrator, provider, customer")]
        public async Task<ActionResult<Page<ExperienceList>>> GetExperiencesByCategoryAsync([FromRoute] int id, [FromQuery] int page)
        {
            try
            {
                var experiences = await model.GetExperiencesByCategoryAsync(id, page);
                await AddLinks(experiences.Content);
                return Ok(experiences);
            }
            catch (Exception e)
            {
                return StatusCode(403, e.Message);
            }
        }

        [Authorize(Roles = "customer, provider, administrator")]
        [HttpGet("{id:int}", Name = "GetExperienceByIdRoute")]
        public async Task<ActionResult<Experience>> GetExperienceByIdAsync([FromRoute] int id)
        {
            try
            {
                Experience experience = await model.GetExperienceByIdAsync(id);
                await AddLink(experience);
                return Ok(experience);
            }
            catch (Exception e)
            {
                return StatusCode(403, e.Message);
            }
        }

        [Authorize(Roles = "customer")]
        [HttpGet(Name = "GetAllExperiencesRoute")]
        public async Task<ActionResult<Page<ExperienceList>>> GetAllExperiencesAsync([FromQuery] bool? top,
            [FromQuery(Name = "name")] string name, [FromQuery] double price, [FromQuery] int? page)
        {
            try
            {
                var experiences = new Page<ExperienceList>();
                if (top == null)
                {
                    if (string.IsNullOrEmpty(name) && price == 0)
                    {
                        experiences = await model.GetAllWebShopExperiencesAsync(page.Value);
                    }
                    else
                    {
                        experiences = await model.GetSortedExperiencesAsync(name, price, page.Value);
                    }
                }
                else
                {
                    experiences = await model.GetTopExperiences();
                }

                await AddLinks(experiences.Content);
                return Ok(experiences);
            }
            catch (Exception e)
            {
                return StatusCode(403, e.Message);
            }
        }

        [Authorize(Roles = "provider")]
        [HttpPost(Name = "CreateExperienceRoute")]
        public async Task<ActionResult<Experience>> AddExperienceAsync([FromBody] Experience experience)
        {
            try
            {
                var addExperienceAsync = await model.AddExperienceAsync(experience);
                await AddLink(addExperienceAsync);
                return Ok(addExperienceAsync);
            }
            catch (Exception e)
            {
                return StatusCode(403, e.Message);
            }
        }

        [Authorize(Roles = "provider")]
        [HttpDelete("{id:int}", Name = "DeleteExperienceRoute")]
        public async Task<ActionResult> DeleteExperienceAsync([FromRoute] int id)
        {
            try
            {
                await model.DeleteExperienceAsync(id);
                return Ok();
            }
            catch (Exception e)
            {
                return StatusCode(403, e.Message);
            }
        }

        private async Task AddLink(Experience experience)
        {
            try
            {
                await linksService.AddLinksAsync(experience);
            }
            catch (Exception e)
            {
                Console.WriteLine(e);
            }
        }

        private async Task AddLinks(ExperienceList list)
        {
            try
            {
                foreach (var e in list.Experiences)
                {
                    await linksService.AddLinksAsync(e);
                }

                await linksService.AddLinksAsync(list);
            }
            catch (Exception e)
            {
                Console.WriteLine(e);
            }
        }
        
        [HttpPatch]
        [Authorize(Roles = "provider")]
        [Route("{id:int}")]
        public async Task<ActionResult<Experience>> EditExperience([FromBody] Experience experience)
        {
            try
            {
                Experience editExperience = await model.EditExperienceAsync(experience);
                return Ok(editExperience);
            }
            catch (Exception e)
            {
                Console.WriteLine(e);
                return StatusCode(500, e.Message);
            }
        }
    }
}