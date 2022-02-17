using System;
using System.Threading.Tasks;
using BusinessLogic.Model.Providers;
using BusinessLogic.Models;
using BusinessLogic.Models.Orders;
using GrpcFileGeneration.Models;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using RiskFirst.Hateoas;
using User = BusinessLogic.Models.User;

namespace BusinessLogic.Controllers
{
    [Authorize]
    [ApiController]
    [Route("[controller]")]
    public class 
        ProviderController : ControllerBase
    {
        private IProviderModel model;
        private ILinksService linksService;
        public ProviderController(ILinksService linksService, IProviderModel model)
        {
            this.linksService = linksService;
            this.model = model;
        }

        [Authorize(Roles = "administrator")]
        [HttpGet(Name = "GetProvidersRoute")]
        public async Task<ActionResult<Page<ProviderList>>> GetProvidersAsync([FromQuery] bool? approved, [FromQuery] string name, [FromQuery] int page)
        {
            var list = new Page<ProviderList>();

            try
            {
                if (approved is true)
                {
                    if (string.IsNullOrEmpty(name))
                    {
                        list = await model.GetAllProvidersAsync(page);
                    }
                    else
                    {
                        list = await model.GetAllProvidersByNameAsync(name, page);
                    }
                }
                else
                {
                    if (string.IsNullOrEmpty(name))
                    {
                        list = await model.GetAllNotApprovedProvidersAsync(page);
                    }
                    else
                    {
                        list = await model.GetAllProvidersByNameAsync(name,page);
                    }
                }

                await AddLinks(list.Content);
                return Ok(list);
            }
            catch (Exception e)
            {
                return StatusCode(403, e.Message);
            }
        }

        
        [Authorize(Roles = "administrator, provider")]
        [HttpGet("{id:int}", Name = "GetProviderByIdRoute")]
        public async Task<ActionResult<User>> GetProviderById([FromRoute] int id)
        {
            try
            {
                var providerById = await model.GetProviderByIdAsync(id);
                await AddLink(providerById);
                return Ok(providerById);
            }
            catch (Exception e)
            {
                return StatusCode(403, e.Message);
            }
        }

        [Authorize(Roles = "provider, administrator")]
        [HttpPatch("{id:int}",Name = "EditProviderRoute")]
        public async Task<ActionResult<Provider>> EditProvider([FromBody] Provider provider)
        {
            try
            {
                Provider editedProvider = await model.EditProviderAsync(provider);
                await AddLink(editedProvider);
                return Ok(editedProvider);
            }
            catch (Exception e)
            {
                return StatusCode(403, e.Message);
            }
        }

        [AllowAnonymous]
        [HttpPost(Name = "CreateProviderRoute")]
        public async Task<ActionResult<User>> CreateProvider([FromBody] Provider provider)
        {
            try
            {
                var user = await model.CreateProviderAsync(provider);
                return Ok(user);

            }
            catch (Exception e)
            {
                return StatusCode(403, e.Message);
            }
        }
        
        [Authorize(Roles = "administrator")]
        [HttpDelete("{id:int}", Name = "DeleteProviderRoute")]
        public async Task<ActionResult> DeleteProviderAsync([FromRoute] int id)
        {
            try
            {
                await model.DeleteProviderAsync(id);
                return Ok();
            }
            catch (Exception e)
            {
                return StatusCode(403);
            }
        }
        
        private async Task AddLink(Provider provider)
        {
            try
            {
                await linksService.AddLinksAsync(provider);
            }
            catch (Exception e)
            {
                Console.WriteLine(e);
            }
        }

        private async Task AddLinks(ProviderList list)
        {
            try
            {
                foreach (var provider in list.Providers)
                {
                    await linksService.AddLinksAsync(provider);
                }
                await linksService.AddLinksAsync(list);
            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
            }
        }
    }
}