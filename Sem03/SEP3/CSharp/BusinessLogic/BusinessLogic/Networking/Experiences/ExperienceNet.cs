using System.Linq;
using System.Threading.Tasks;
using GrpcFileGeneration.Models;
using Networking.Experience;
using Networking.Request;

namespace BusinessLogic.Networking.Experiences
{
    public class ExperienceNet : IExperienceNet
    {
        private ExperienceService.ExperienceServiceClient client;

        public ExperienceNet(ExperienceService.ExperienceServiceClient client)
        {
            this.client = client;
        }

        public async Task<Experience> AddExperienceAsync(Experience experience)
        {
            var protobufMessage = await client.addExperienceAsync(experience.ToMessage());
            return new Experience(protobufMessage);
        }

        public async Task<Page<ExperienceList>> GetAllProviderExperiencesAsync(int provider, int page)
        {
            var requestMessage = new RequestMessage
            {
                Id = provider,
                PageInfo = new PageRequestMessage
                {
                    PageNumber = page,
                    PageSize = 5
                }
            };
            var allProviderExperiencesAsync = await client.getAllProviderExperiencesAsync(requestMessage);
            return PageContent(allProviderExperiencesAsync);
        }

        public async Task<Page<ExperienceList>> GetAllWebShopExperiencesAsync(int page)
        {
            var pageRequestMessage = new PageRequestMessage
            {
                PageNumber = page,
                PageSize = 5
            };
            var allWebShopExperiencesAsync = await client.getAllWebShopExperiencesAsync(pageRequestMessage);
            return PageContent(allWebShopExperiencesAsync);
        }

        public async Task<Experience> GetExperienceByIdAsync(int id)
        {
            var experienceByIdAsync = await client.getExperienceByIdAsync(new RequestMessage {Id = id});
            return new Experience(experienceByIdAsync);
        }

        public async Task<bool> IsInStockAsync(int experienceId, int quantity)
        {
            var isInStockAsync = await client.isInStockAsync(new RequestMessage {Id = experienceId, Quantity = quantity});
            return isInStockAsync.Response;
        }

        public async Task RemoveStockAsync(int experienceId, int itemQuantity)
        {
            await client.removeStockAsync(new RequestMessage() {Id = experienceId, Quantity = itemQuantity});
        }

        public async Task DeleteExperienceAsync(int experienceId)
        {
            await client.deleteExperienceAsync(new RequestMessage {Id = experienceId});
        }

        public async Task<Page<ExperienceList>> GetExperiencesByCategoryAsync(int id, int page)
        {
            var requestMessage = new RequestMessage()
            {
                Id = id,
                PageInfo = new PageRequestMessage
                {
                    PageNumber = page,
                    PageSize = 5
                }
            };
            var experienceByCategoryAsync = await client.getExperienceByCategoryAsync(requestMessage);
            return PageContent(experienceByCategoryAsync);
        }

        public async Task<Page<ExperienceList>> GetTopExperiences()
        {
            var experienceListMessage = await client.getTopExperiencesAsync(new RequestMessage());
            var experiences = experienceListMessage.Experiences.Select(a => new Experience(a)).ToList();
            return new Page<ExperienceList> {Content = new ExperienceList{Experiences = experiences}};
        }

        public async Task<Page<ExperienceList>> GetSortedExperiencesAsync(string name, double price, int page)
        {
            var message = await client.getSortedExperiencesAsync(new RequestMessage
            {
                Name = string.IsNullOrEmpty(name) ? "" : name,
                Price = price == 0 ? double.MaxValue : price,
                PageInfo = new PageRequestMessage
                {
                    PageNumber = page,
                    PageSize = 5
                }
            });
            return PageContent(message);
        }

        public async Task<Experience> EditExperienceAsync(Experience experience)
        {
            var message = await client.editExperienceAsync(experience.ToMessage());
            return new Experience(message);
        }

        public async Task<Page<ExperienceList>> GetAllProviderExperiencesByNameAsync(int id, string name, int page)
        {
            var requestMessage = new RequestMessage
            {
                Id = id,
                Name = name,
                PageInfo = new PageRequestMessage
                {
                    PageNumber = page,
                    PageSize = 5
                }
            };
            var allProviderExperiencesByNameAsync = await client.getAllProviderExperiencesByNameAsync(requestMessage);
            return PageContent(allProviderExperiencesByNameAsync);
        }

        private static Page<ExperienceList> PageContent(ExperienceListMessage allProviderExperiencesAsync)
        {
            var experiences = new ExperienceList
            {
                Experiences = allProviderExperiencesAsync.Experiences.Select(a => new Experience(a)).ToList()
            };

            var pageContent = new Page<ExperienceList>(allProviderExperiencesAsync.PageInfo)
            {
                Content = experiences
            };
            return pageContent;
        }
    }
}