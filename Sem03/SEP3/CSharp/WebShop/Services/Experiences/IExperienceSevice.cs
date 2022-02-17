using System.Threading.Tasks;
using WebShop.Models;

namespace WebShop.Services.Experiences
{
    public interface IExperienceService
    {
        Task<Page<ExperienceList>> GetAllExperiencesAsync(int page);
        Task<Experience> GetExperienceById(int id);
        Task<Page<ExperienceList>> GetExperiencesByCategoryAsync(int id, int page);
        Task<ExperienceList> GetTopExperiences();
        Task<Page<ExperienceList>> GetSortedExperiences(string name, double price, int page);
    }
}