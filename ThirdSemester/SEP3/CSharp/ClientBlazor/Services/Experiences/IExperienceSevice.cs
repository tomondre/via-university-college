using System.Threading.Tasks;
using GrpcFileGeneration.Models;

namespace ClientBlazor.Services.Experiences
{
    public interface IExperienceService
    {
        Task<Experience> AddExperienceAsync(Experience experience);
        Task<Page<ExperienceList>> GetAllProviderExperiencesAsync(int? providerId, int page);
        Task<Page<ExperienceList>> GetAllProviderExperiencesByNameAsync(int? providerId, string name, int page);

        Task DeleteExperienceAsync(Experience experience);
        Task<Experience> GetExperienceByIdAsync(int id);
        Task<Experience>  EditExperienceAsync(Experience experience);
    }
}