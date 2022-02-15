using System.ComponentModel.DataAnnotations;
using Networking.Address;

namespace GrpcFileGeneration.Models
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

        public Address(AddressMessage message)
        {
            Street = message.Street;
            StreetNumber = message.StreetNumber;
            PostCode = message.PostCode;
            City = message.City;
        }

        public AddressMessage ToMessage()
        {
            return new AddressMessage
            {
                City = City,
                Street = Street,
                StreetNumber = StreetNumber,
                PostCode = PostCode
            };
        }
    }
}