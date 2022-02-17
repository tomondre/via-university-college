using System.ComponentModel.DataAnnotations;

namespace WebShop.Models
{
    public class Address
    {
        [Required, MaxLength(50)]
        public string Street { get; set; }
        [Required, MaxLength(5)]
        public string StreetNumber { get; set; }
        [Required, Range(1000,9999)]
        public int PostCode { get; set; }
        [Required, MaxLength(50)]
        public string City { get; set; }
        
        public Address()
        {
        }
    }
}