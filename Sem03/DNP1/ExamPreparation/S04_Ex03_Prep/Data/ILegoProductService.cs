using System.Collections.Generic;
using System.Threading.Tasks;
using S04_Ex03_Prep.Models;

namespace S04_Ex03_Prep.Data
{
    public interface ILegoProductService
    {
        public Task<IList<LegoProduct>> GetAllProductsForTheme(string theme);
    }
}