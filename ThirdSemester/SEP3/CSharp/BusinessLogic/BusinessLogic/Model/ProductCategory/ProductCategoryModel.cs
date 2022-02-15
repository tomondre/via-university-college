using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using BusinessLogic.Networking.ProductCategory;
using GrpcFileGeneration.Models;
using Microsoft.Extensions.Caching.Memory;

namespace BusinessLogic.Model.ProductCategory
{
    public class ProductCategoryModel : IProductCategoryModel
    {
        private IProductCategoryNet network;

        public ProductCategoryModel(IProductCategoryNet network)
        {
            this.network = network;
        }

        public async Task<Category> AddProductCategoryAsync(Category category)
        {
            return await network.AddProductCategoryAsync(category);
        }

        public async Task<Page<CategoryList>> GetAllCategoriesAsync(int page)
        {
            return await network.GetAllCategoriesAsync(page);
        }

        public async Task<Category> EditProductCategoryAsync(Category category)
        {
            return await network.EditProductCategoryAsync(category);
        }
    }
}