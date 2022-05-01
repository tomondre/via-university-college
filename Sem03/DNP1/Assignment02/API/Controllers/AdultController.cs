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
        private IAdultService adultService;

        public AdultController(IAdultService adultService)
        {
            this.adultService = adultService;
        }

        [HttpGet]
        public async Task<ActionResult<IList<Adult>>> GetAdults()
        {
            try
            {
                IList<Adult> adults = await adultService.GetAllAdultsAsync();
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
                Adult ad = await adultService.AddAdultAsync(adult);
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
                var removeAdult = await adultService.RemoveAdultAsync(id);
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
                Adult editAdult = await adultService.EditAdultAsync(adult);
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
                Adult adultById = await adultService.GetAdultByIdAsync(id);
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