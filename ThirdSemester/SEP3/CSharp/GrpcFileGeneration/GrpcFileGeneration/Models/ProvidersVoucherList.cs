using System.Collections.Generic;

namespace GrpcFileGeneration.Models
{
    public class ProvidersVoucherList
    {
        public IList<ProviderVouchers> Vouchers { set; get; }

        public ProvidersVoucherList()
        {
            Vouchers = new List<ProviderVouchers>();
        }
    }
}