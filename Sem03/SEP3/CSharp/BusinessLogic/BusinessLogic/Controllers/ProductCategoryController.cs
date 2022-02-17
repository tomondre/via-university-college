using System;
using System.Threading.Tasks;
using BusinessLogic.Model.ProductCategory;
using GrpcFileGeneration.Models;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using RiskFirst.Hateoas;

namespace BusinessLogic.Controllers
{
    [Authorize]
    [ApiController]
    [Route("[controller]")]
    public class ProductCategoryController : ControllerBase
    {
        private IProductCategoryModel model;
        private ILinksService linksService;

        public ProductCategoryController(IProductCategoryModel model, ILinksService linksService)
        {
            this.model = model;
            this.linksService = linksService;
        }

        [AllowAnonymous]
        [HttpGet(Name = "GetCategoryRoute")]
        public async Task<ActionResult<Page<CategoryList>>> GetAllCategories([FromQuery] int page)
        {
            try
            {
                Page<CategoryList> categories = await model.GetAllCategoriesAsync(page);
                await AddLinks(categories.Content);
                return Ok(categories);
            }
            catch (Exception e)
            {
                return StatusCode(403, e.Message);
            }
        }

        [Authorize(Roles = "administrator")]
        [HttpPatch("{id:int}",Name = "EditCategoryRoute")]
        public async Task<ActionResult<Category>> EditCategory([FromBody] Category category, [FromRoute] int id)
        {
            try
            {
                category.Id = id;
                var editProductCategoryAsync = await model.EditProductCategoryAsync(category);
                await AddLink(editProductCategoryAsync);
                return Ok(editProductCategoryAsync);
            }
            catch (Exception e)
            {
                return StatusCode(403, e.Message);
            }
           
        }
        
        [Authorize(Roles = "administrator")]
        [HttpPost(Name = "CreateCategoryRoute")]
        public async Task<ActionResult<Category>> CreateCategory([FromBody] Category category)
        {
            try
            {
                var addProductCategoryAsync = await model.AddProductCategoryAsync(category);
                await AddLink(addProductCategoryAsync);
                return Ok(addProductCategoryAsync);
            }
            catch (Exception e)
            {
                return StatusCode(403, e.Message);
            }
        }

        private async Task AddLink(Category provider)
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

        private async Task AddLinks(CategoryList list)
        {
            try
            {
                foreach (var provider in list.Categories)
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