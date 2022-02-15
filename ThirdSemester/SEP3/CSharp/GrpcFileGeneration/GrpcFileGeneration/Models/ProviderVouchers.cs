using Networking.Order;

namespace GrpcFileGeneration.Models
{
    public class ProviderVouchers
    {
       

        public string CustomerName { set; get; }
        public string Date { get; set; }
        public string Voucher { set; get; }
        public int Quantity { set; get; }
        public string ExperienceName { set; get; }
        
        public ProviderVouchers()
        {
        }
        public ProviderVouchers(VoucherMessages voucherMessages)
        {
            CustomerName = voucherMessages.CustomerName;
            Date = voucherMessages.Date;
            Voucher = voucherMessages.Voucher;
            Quantity = voucherMessages.Quantity;
            ExperienceName = voucherMessages.ExperienceName;
        }

        public VoucherMessages ToMessage()
        {
            return new VoucherMessages()
            {
                CustomerName = CustomerName,
                Date = Date,
                Voucher = Voucher,
                Quantity = Quantity,
                ExperienceName = ExperienceName
            };
            
        }
    }
}