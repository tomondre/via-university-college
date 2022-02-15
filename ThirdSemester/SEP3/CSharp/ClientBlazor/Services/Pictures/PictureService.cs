using System.Threading.Tasks;
using CloudinaryDotNet;
using CloudinaryDotNet.Actions;
using Microsoft.AspNetCore.Components.Forms;
using Account = CloudinaryDotNet.Account;

namespace ClientBlazor.Services.Pictures
{
    public class PictureService : IPicturesService
    {
        private Cloudinary _cloudinary;
        
        public PictureService()
        {
            Account account = new Account()
            {
                Cloud = "dvla3rxfp",
                ApiKey = "765788777579643",
                ApiSecret = "zZwlEhnjCKgfWYHkQd6xrwOMyxw"
            };
            _cloudinary = new Cloudinary(account);
        }
        
        public async Task<string> UploadImage(IBrowserFile file)
        {
            var uploadParams = new ImageUploadParams()
            {
                File = new FileDescription(file.Name, file.OpenReadStream())
            };
            var uploadAsync = await _cloudinary.UploadAsync(uploadParams);
            return uploadAsync.Url.AbsoluteUri;
        }
        
    }
}