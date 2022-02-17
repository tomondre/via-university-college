using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using BusinessLogic.Networking.Experiences;
using GrpcFileGeneration.Models;
using Microsoft.Extensions.Caching.Memory;

namespace BusinessLogic.Model.Experiences
{
    public class ExperienceModel : IExperienceModel
    {
        private IExperienceNet network;

        public ExperienceModel(IExperienceNet network)
        {
            this.network = network;
        }
        
        public async Task<Experience> AddExperienceAsync(Experience experience)
        {
            return await network.AddExperienceAsync(experience);
        }

        public async Task<Page<ExperienceList>> GetAllProviderExperiencesAsync(int provider, int page)
        {
            return await network.GetAllProviderExperiencesAsync(provider, page);
        }

        public async Task<Page<ExperienceList>> GetAllWebShopExperiencesAsync(int page)
        {
            return await network.GetAllWebShopExperiencesAsync(page);
        }

        public async Task<Experience> GetExperienceByIdAsync(int id)
        {
            return await network.GetExperienceByIdAsync(id);
        }

        public Task<bool> IsInStockAsync(int experienceId, int quantity)
        {
            return network.IsInStockAsync(experienceId, quantity);
        }

        public async Task RemoveStockAsync(int experienceId, int itemQuantity)
        {
            await network.RemoveStockAsync(experienceId, itemQuantity);
        }

        public async Task DeleteExperienceAsync(int experienceId)
        {
            await network.DeleteExperienceAsync(experienceId);
        }

        public async Task<Page<ExperienceList>> GetAllProviderExperiencesByNameAsync(int id, string name, int page)
        {
            return await network.GetAllProviderExperiencesByNameAsync(id, name, page);
        }

        public async Task<Page<ExperienceList>> GetExperiencesByCategoryAsync(int id, int page)
        {
            return await network.GetExperiencesByCategoryAsync(id, page);
        }

        public async Task<Page<ExperienceList>> GetTopExperiences()
        {
            return await network.GetTopExperiences();
        }

        public async Task<Page<ExperienceList>> GetSortedExperiencesAsync(string name, double price, int page)
        {
            return await network.GetSortedExperiencesAsync(name, price, page);
        }

        public async Task<Experience> EditExperienceAsync(Experience experience)
        {
            return await network.EditExperienceAsync(experience);
        }
    }
}