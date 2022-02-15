using System.Collections.Generic;
using System.Threading.Tasks;
using GrpcFileGeneration.Models;

namespace BusinessLogic.Model.ProductCategory
{
    public interface IProductCategoryModel
    {
        Task<Category> AddProductCategoryAsync(Category category);
        Task<Page<CategoryList>> GetAllCategoriesAsync(int page);
        Task<Category> EditProductCategoryAsync(Category category);
    }
}