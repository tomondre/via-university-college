using System.Text;
using BusinessLogic.Model.Customers;
using BusinessLogic.Model.Experiences;
using BusinessLogic.Model.Login;
using BusinessLogic.Model.Orders;
using BusinessLogic.Model.ProductCategory;
using BusinessLogic.Model.Providers;
using BusinessLogic.Models;
using BusinessLogic.Models.Orders;
using BusinessLogic.Networking.Customers;
using BusinessLogic.Networking.Experiences;
using BusinessLogic.Networking.Login;
using BusinessLogic.Networking.Orders;
using BusinessLogic.Networking.ProductCategory;
using BusinessLogic.Networking.Providers;
using Grpc.Net.Client;
using GrpcFileGeneration.Models;
using GrpcFileGeneration.Models.Orders;
using GrpcFileGeneration.Services;
using Microsoft.AspNetCore.Authentication.JwtBearer;
using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Hosting;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Hosting;
using Microsoft.IdentityModel.Tokens;
using Microsoft.OpenApi.Models;
using Networking.Category;
using Networking.Experience;
using Networking.Login;
using Networking.Provider;
using RiskFirst.Hateoas;
using Customer = BusinessLogic.Models.Customer;
using CustomerService = Networking.Customer.CustomerService;
using StripeOrder = Stripe.Order;
// using Order = GrpcFileGeneration.Models.Order.Order;
using OrderService = Networking.Order.OrderService;

namespace BusinessLogic
{
    public class Startup
    {
        public Startup(IConfiguration configuration)
        {
            Configuration = configuration;
        }

        public IConfiguration Configuration { get; }

        // This method gets called by the runtime. Use this method to add services to the container.
        public void ConfigureServices(IServiceCollection services)
        {
            var key = @"MIICXgIBAAKBgQDy0/9fpTqf/U49RkU5/49TQi9WB3YzbsxCvKQe22mpWzVUiODW
            1Td3Uuoq7Jkla2qD2o4QIhXk+c7q9nG+8TYxCYBehjmGiHCALuWetYjrPpJ97chP
            uNZYhzBn27+16I/unSqgrFwEKQH79dAOaZtpPmKIq4y1UdIBM7swU5UqeQIDAQAB
            AoGBAM2DUrz2MDm7vn3pfSlq+zhx6XIb+pPpEALjeNuMw05MHUSgW/o2liztBbay
            a6LZ2FojnNxWnMUgD1mYnggGSd9srE7z9CGj+Wk1Ki5zI5IbIFa8G9Nvz1PzQFmo
            rYlomxdb8bb4v4dtaQAnyV5j3Z7mF6VgNzgD3HcVj2sqpu7pAkEA+gvOXImgObZL
            qV2ZN4tUWuANXfzEcRt2tENBnlcDxM0gIiT0q6RVWzcD/x+aoCClKFhNyfUMY6Ud
            81+AEfIRkwJBAPicMWp25D+hSRqTcRvgHmLlgWyo5xU+J9QIXfZC1JRWpgRO3liM
            CdWgvUUirwG0bYBzdukHnsMezAkeRahpy0MCQGJnww8oGqab16sP6vyxGMGq65fR
            on3hERZgYbKvDAynrb3CTYg/ZFhBjpEZHwFl15nJJtQUXIvar67YJs7pNYECQQDp
            lZe4eEysnFWbarzze/gQ46Je/bNg+i1hwxrFrrUdSuxhT9kJSUpUNdqfgp778xKP
            he1LtaUtn1oFlzPLsNsRAkEAh8/TFyrkKk+9RmOHVN/dXATMFtA64keRNwpb3jeX
            1ONCPd9S2/tWcbpJYIOXsJSuiYjBHyE8wKog1Idh7JZiOA==";

            services.AddAuthentication(policy =>
            {
                policy.DefaultAuthenticateScheme = JwtBearerDefaults.AuthenticationScheme;
                policy.DefaultChallengeScheme = JwtBearerDefaults.AuthenticationScheme;
            }).AddJwtBearer(policy =>
            {
                policy.RequireHttpsMetadata = false;
                policy.SaveToken = true;
                policy.TokenValidationParameters = new TokenValidationParameters
                {
                    ValidateIssuerSigningKey = true,
                    IssuerSigningKey = new SymmetricSecurityKey(Encoding.ASCII.GetBytes(key)),
                    ValidateIssuer = false,
                    ValidateAudience = false
                };
            });
            services.AddSingleton(
                new ProviderService.ProviderServiceClient(
                    GrpcChannel.ForAddress("http://localhost:9090")));
            services.AddSingleton<IProviderModel, ProviderModel>();
            services.AddSingleton<IProviderNet, ProviderNet>();

            services.AddSingleton(
                new CategoryService.CategoryServiceClient(
                    GrpcChannel.ForAddress("http://localhost:9090")));
            services.AddSingleton<IProductCategoryModel, ProductCategoryModel>();
            services.AddSingleton<IProductCategoryNet, ProductCategoryNet>();

            services.AddSingleton(
                new CustomerService.CustomerServiceClient(
                    GrpcChannel.ForAddress("http://localhost:9090")));
            services.AddSingleton<ICustomerModel, CustomerModel>();
            services.AddSingleton<ICustomerNet, CustomerNet>();

            services.AddSingleton(
                new ExperienceService.ExperienceServiceClient(GrpcChannel.ForAddress("http://localhost:9090")));
            services.AddSingleton<IExperienceModel, ExperienceModel>();
            services.AddSingleton<IExperienceNet, ExperienceNet>();

            services.AddSingleton(
                new LoginService.LoginServiceClient(GrpcChannel.ForAddress("http://localhost:9090")));
            services.AddSingleton<ILoginModel>(x => new LoginModel(x.GetRequiredService<ILoginNet>(), key));
            services.AddSingleton<ILoginNet, LoginNet>();

            services.AddSingleton(
                new OrderService.OrderServiceClient(GrpcChannel.ForAddress("http://localhost:9090")));
            services.AddSingleton<IOrderModel, OrderModel>();
            services.AddSingleton<IOrderNet, OrderNet>();


            services.AddSingleton<IValidator, Validator>();

            services.AddControllers();

            services.AddSingleton<ILinksService, DefaultLinksService>();

            services.AddMemoryCache();
            services.AddSwaggerGen(c =>
            {
                c.SwaggerDoc("v1", new OpenApiInfo {Title = "BusinessLogic", Version = "v1"});
            });
            services.AddLinks(config =>
            {
                config.AddPolicy<Provider>(policy =>
                {
                    policy
                        .RequireRoutedLink("self", "GetProviderByIdRoute", x => new {id = x.Id})
                        .RequireRoutedLink("edit", "EditProviderRoute", x => new {id = x.Id})
                        .RequireRoutedLink("delete", "DeleteProviderRoute", x => new {id = x.Id});
                });
                config.AddPolicy<ProviderList>(policy =>
                {
                    policy
                        .RequireRoutedLink("self", "GetProvidersRoute")
                        .RequireRoutedLink("create", "CreateProviderRoute");
                });
                config.AddPolicy<Category>(policy =>
                {
                    policy
                        .RequireRoutedLink("edit", "EditCategoryRoute", x => new {id = x.Id})
                        .RequireRoutedLink("delete", "DeleteCategoryRoute", x => new {id = x.Id});
                });
                config.AddPolicy<CategoryList>(policy =>
                {
                    policy
                        .RequireRoutedLink("self", "GetCategoryRoute", x => new {page = 1})
                        .RequireRoutedLink("create", "CreateCategoryRoute");
                });
                config.AddPolicy<Customer>(policy =>
                {
                    policy
                        .RequireRoutedLink("self", "GetCustomerByIdRoute", x => new {id = x.Id})
                        .RequireRoutedLink("delete", "DeleteCustomerRoute", x => new {id = x.Id})
                        .RequireRoutedLink("edit", "EditCustomerRoute", x => new {id = x.Id});
                });
                config.AddPolicy<CustomerList>(policy =>
                {
                    policy
                        .RequireRoutedLink("create", "CreateCustomerRoute")
                        .RequireSelfLink();
                });
                config.AddPolicy<Experience>(policy =>
                {
                    policy
                        .RequireRoutedLink("self", "GetExperienceByIdRoute", x => new {id = x.Id})
                        .RequireRoutedLink("delete", "DeleteExperienceRoute", x => new {id = x.Id})
                        .RequireRoutedLink("edit", "EditExperienceRoute", x => new {id =x.Id});
                });
                config.AddPolicy<ExperienceList>(policy =>
                {
                    policy
                        .RequireRoutedLink("self", "GetAllExperiencesRoute")
                        .RequireRoutedLink("create", "CreateExperienceRoute");
                });
                config.AddPolicy<Order>(policy =>
                {
                    policy.RequireRoutedLink("self", "GetOrderByIdRoute", x => new {id = x.Id});
                });
                config.AddPolicy<OrderList>(policy =>
                {
                    policy
                        .RequireRoutedLink("create", "CreateOrderRoute");
                });
            });
        }

        // This method gets called by the runtime. Use this method to configure the HTTP request pipeline.
        public void Configure(IApplicationBuilder app, IWebHostEnvironment env)
        {
            if (env.IsDevelopment())
            {
                app.UseDeveloperExceptionPage();
                app.UseSwagger();
                app.UseSwaggerUI(c => c.SwaggerEndpoint("/swagger/v1/swagger.json", "BusinessLogic v1"));
            }

            app.UseHttpsRedirection();
            app.UseAuthentication();
            app.UseRouting();

            app.UseAuthorization();

            app.UseEndpoints(endpoints => { endpoints.MapControllers(); });
        }
    }
}