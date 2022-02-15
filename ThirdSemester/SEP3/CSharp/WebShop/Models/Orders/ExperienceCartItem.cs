
namespace WebShop.Models.Orders
{
    public class ExperienceCartItem
    {
        public Experience Experience { get; set; }
        public int Quantity { get; set; }
        
        public string Voucher { set; get; }

        public double TotalPrice => Quantity * Experience.Price;

        public ExperienceCartItem()
        {
            Experience = new Experience();
        }
    }
}