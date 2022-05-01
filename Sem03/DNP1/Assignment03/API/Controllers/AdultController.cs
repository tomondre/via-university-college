using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using FileData;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Logging;
using Person;

namespace API.Controllers
{
    [ApiController]
    [Route("Adults")]
    public class AdultController : ControllerBase
    {
        private IAdultRepo adultRepo;

        public AdultController(IAdultRepo adultRepo)
        {
            this.adultRepo = adultRepo;
        }

        [HttpGet]
        public async Task<ActionResult<IList<Adult>>> GetAdults()
        {
            try
            {
                IList<Adult> adults = await adultRepo.GetAllAdultsAsync();
                return Ok(adults);
            }
            catch (Exception e)
            {
                Console.WriteLine(e);
                return StatusCode(500, e);
            }
        }

        [HttpPost]
        public async Task<ActionResult<Adult>> AddAdult([FromBody] Adult adult)
        {
            try
            {
                Adult ad = await adultRepo.AddAdultAsync(adult);
                return Created($"/{ad.Id}", ad);
            }
            catch (Exception e)
            {
                Console.WriteLine(e);
                return StatusCode(500, e.Message);
            }
        }

        [HttpDelete]
        [Route("{id:int}")]
        public async Task<ActionResult<Adult>> DeleteAdult([FromRoute] int id)
        {
            try
            {
                var removeAdult = await adultRepo.RemoveAdultAsync(id);
                return Ok(removeAdult);
            }
            catch (Exception e)
            {
                Console.WriteLine(e);
                return StatusCode(500, e.Message);
            }
        }
        
        [HttpPut]
        public async Task<ActionResult<Adult>> EditAdult([FromBody] Adult adult)
        {
            try
            {
                Adult editAdult = await adultRepo.EditAdultAsync(adult);
                return Ok(editAdult);
            }
            catch (Exception e)
            {
                Console.WriteLine(e);
                return StatusCode(500, e.Message);
            }
        }
        
        [HttpGet]
        [Route("{id:int}")]
        public async Task<ActionResult<Adult>> GetAdultByID([FromRoute] int id)
        {
            try
            {
                Adult adultById = await adultRepo.GetAdultByIdAsync(id);
                return Ok(adultById);
            }
            catch (Exception e)
            {
                Console.WriteLine(e);
                return StatusCode(500, e.Message);
            }
        }
    }
}