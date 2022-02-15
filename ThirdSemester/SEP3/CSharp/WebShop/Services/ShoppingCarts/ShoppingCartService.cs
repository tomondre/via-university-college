using System.Collections.Generic;
using System.Linq;
using WebShop.Models;
using WebShop.Models.Orders;

namespace WebShop.Services.ShoppingCarts
{
    public class ShoppingCartService : IShoppingCartService
    {
        public ShoppingCart ShoppingCart { get; set; }

        public ShoppingCartService()
        {
            ShoppingCart = new ShoppingCart();
        }
        public void AddExperience(Experience experience, int quantity)
        {
            try
            {
                var experienceCartItem = ShoppingCart.ShoppingCartItems.First(e => e.Experience.Id == experience.Id);
                experienceCartItem.Quantity += quantity;
            }
            catch
            {
                ShoppingCart.ShoppingCartItems.Add(new ExperienceCartItem {Experience = experience, Quantity = quantity});
            }
        }
        
        public void RemoveExperienceItem(ExperienceCartItem experience)
        {
            ShoppingCart.ShoppingCartItems.Remove(experience);
        }

        public void ClearShoppingCart()
        {
            ShoppingCart.ShoppingCartItems = new List<ExperienceCartItem>();
        }

        public bool IsInCart(Experience experience)
        {
            var experienceCartItem = ShoppingCart.ShoppingCartItems.FirstOrDefault(e => e.Experience.Id == experience.Id);
            return experienceCartItem != null;
        }
    }
}