using System.Collections.Generic;
using System.Threading.Tasks;
using GrpcFileGeneration.Models;

namespace BusinessLogic.Model.Experiences
{
    public interface IExperienceModel
    {
        Task<Experience> AddExperienceAsync(Experience experience);
        Task<Page<ExperienceList>> GetAllProviderExperiencesAsync(int provider, int page);
        Task<Page<ExperienceList>> GetAllWebShopExperiencesAsync(int page);
        Task<Experience> GetExperienceByIdAsync(int id);
        Task<bool> IsInStockAsync(int experienceId ,int quantity);
        Task RemoveStockAsync(int experienceId, int itemQuantity);
        Task DeleteExperienceAsync(int experienceId);
        Task<Page<ExperienceList>> GetAllProviderExperiencesByNameAsync(int id, string name, int page);
        Task<Page<ExperienceList>> GetExperiencesByCategoryAsync(int id, int page);
        Task<Page<ExperienceList>> GetTopExperiences();
        Task<Page<ExperienceList>> GetSortedExperiencesAsync(string name, double price, int page);
        Task<Experience> EditExperienceAsync(Experience experience);
    }
}