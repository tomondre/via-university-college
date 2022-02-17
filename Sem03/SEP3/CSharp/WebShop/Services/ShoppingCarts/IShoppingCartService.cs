using WebShop.Models;
using WebShop.Models.Orders;

namespace WebShop.Services.ShoppingCarts
{
    public interface IShoppingCartService
    {
        ShoppingCart ShoppingCart { get;}
        void AddExperience(Experience experience, int quantity);
        void RemoveExperienceItem(ExperienceCartItem experience);
        void ClearShoppingCart();
        bool IsInCart(Experience experience);
    }
}