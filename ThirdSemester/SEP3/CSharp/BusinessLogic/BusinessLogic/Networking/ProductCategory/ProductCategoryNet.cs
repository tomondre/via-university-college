using System.Collections.Generic;
using System.Linq;
using System.Text.Json;
using System.Threading.Tasks;
using GrpcFileGeneration.Models;
using Networking.Category;
using Networking.Request;

namespace BusinessLogic.Networking.ProductCategory
{
    public class ProductCategoryNet : IProductCategoryNet
    {
        private CategoryService.CategoryServiceClient client;

        public ProductCategoryNet(CategoryService.CategoryServiceClient client)
        {
            this.client = client;
        }

        public async Task<Category> AddProductCategoryAsync(Category category)
        {
            var categoryMessage = category.ToMessage();
            var addProductCategory =
                await client.addProductCategoryAsync(categoryMessage);
            var createdCategory = new Category(addProductCategory);
            return createdCategory;
        }

        public async Task<Page<CategoryList>> GetAllCategoriesAsync(int page)
        {
            var pageRequestMessage = new PageRequestMessage() {PageNumber = page, PageSize = 5};
            var allProductCategoriesAsync = await client.getAllProductCategoriesAsync(pageRequestMessage);
            
            var categoryList = new CategoryList()
            {
                Categories = allProductCategoriesAsync.Categories.Select(a => new Category(a)).ToList()
            };

            var pageContent = new Page<CategoryList>(allProductCategoriesAsync.PageInfo)
            {
                Content = categoryList
            };
            return pageContent;
        }

        public async Task<Category> EditProductCategoryAsync(Category category)
        {
            var categoryMessage = category.ToMessage();
            var editProductCategoryAsync =
                await client.editProductCategoryAsync(categoryMessage);
            var editedCategory = new Category(editProductCategoryAsync);
            return editedCategory;
        }
    }
}