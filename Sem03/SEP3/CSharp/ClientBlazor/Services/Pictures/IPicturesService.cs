using System.Threading.Tasks;
using Microsoft.AspNetCore.Components.Forms;

namespace ClientBlazor.Services.Pictures
{
    public interface IPicturesService
    {
        Task<string> UploadImage(IBrowserFile file);
    }
}