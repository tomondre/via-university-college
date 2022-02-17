using System.Collections.Generic;
using System.Threading.Tasks;
using GrpcFileGeneration.Models;

namespace BusinessLogic.Networking.ProductCategory
{
    public interface IProductCategoryNet
    {
        Task<Category> AddProductCategoryAsync(Category category);
        Task<Page<CategoryList>> GetAllCategoriesAsync(int page);
        Task<Category> EditProductCategoryAsync(Category category);
    }
}