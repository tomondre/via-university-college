using System.Security.Claims;
using ClientBlazor.Cache;
using ClientBlazor.Data.Authentication;
using ClientBlazor.Services.Customers;
using ClientBlazor.Services.Experiences;
using ClientBlazor.Services.Login;
using ClientBlazor.Services.Orders;
using ClientBlazor.Services.Pictures;
using ClientBlazor.Services.ProductCategory;
using ClientBlazor.Services.Providers;
using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Components.Authorization;
using Microsoft.AspNetCore.Hosting;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Hosting;

namespace ClientBlazor
{
    public class Startup
    {
        public Startup(IConfiguration configuration)
        {
            Configuration = configuration;
        }

        public IConfiguration Configuration { get; }

        // This method gets called by the runtime. Use this method to add services to the container.
        // For more information on how to configure your application, visit https://go.microsoft.com/fwlink/?LinkID=398940
        public void ConfigureServices(IServiceCollection services)
        {
            services.AddRazorPages();
            services.AddServerSideBlazor();
            services.AddHttpClient();
            services.AddScoped<IProviderService, ProviderService>();
            services.AddScoped<IProductCategoryService, ProductCategoryService>();
            services.AddScoped<IExperienceService, ExperienceService>();

            services.AddScoped<IPicturesService, PictureService>();
            services.AddScoped<ILoginService, LoginService>();
            services.AddScoped<AuthenticationStateProvider, CurrentAuthenticationStateProvider>();
            services.AddScoped<ICustomerService, CustomerService>();
            services.AddScoped<ICacheService, CacheService>();
            services.AddScoped<IOrderService, OrderService>();
            services.AddAuthorization(options =>
            {
                options.AddPolicy("Customer",  a => 
                    a.RequireAuthenticatedUser().RequireClaim(ClaimTypes.Role, "customer"));
                
                options.AddPolicy("Provider",  a => 
                    a.RequireAuthenticatedUser().RequireClaim(ClaimTypes.Role, "provider"));
                
                options.AddPolicy("Administrator",  a => 
                    a.RequireAuthenticatedUser().RequireClaim(ClaimTypes.Role, "administrator"));
            });
        }

        // This method gets called by the runtime. Use this method to configure the HTTP request pipeline.
        public void Configure(IApplicationBuilder app, IWebHostEnvironment env)
        {
            if (env.IsDevelopment())
            {
                app.UseDeveloperExceptionPage();
            }
            else
            {
                app.UseExceptionHandler("/Error");
                // The default HSTS value is 30 days. You may want to change this for production scenarios, see https://aka.ms/aspnetcore-hsts.
                app.UseHsts();
            }

            app.UseHttpsRedirection();
            app.UseStaticFiles();

            app.UseRouting();

            app.UseEndpoints(endpoints =>
            {
                endpoints.MapBlazorHub();
                endpoints.MapFallbackToPage("/_Host");
            });
        }
    }
}