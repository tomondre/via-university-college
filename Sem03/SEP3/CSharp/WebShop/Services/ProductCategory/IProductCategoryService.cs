using System.Threading.Tasks;
using WebShop.Models;

namespace WebShop.Services.ProductCategory
{
    public interface IProductCategoryService
    {
        Task<CategoryList> GetAllCategoriesAsync();
    }
}