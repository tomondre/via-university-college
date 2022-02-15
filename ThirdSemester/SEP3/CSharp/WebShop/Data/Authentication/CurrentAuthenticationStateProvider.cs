using System;
using System.Collections.Generic;
using System.Security.Claims;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Components.Authorization;
using Microsoft.AspNetCore.Components.Server.ProtectedBrowserStorage;
using WebShop.Cache;
using WebShop.Models;
using WebShop.Services.Login;

namespace WebShop.Data.Authentication
{
    public class CurrentAuthenticationStateProvider : AuthenticationStateProvider
    {
        private readonly ILoginService loginService;
        private readonly ICacheService cacheService;

        private User cachedUser;
        
        public CurrentAuthenticationStateProvider(ILoginService loginService, ICacheService cacheService)
        {
            this.loginService = loginService;
            this.cacheService = cacheService;
        }

        public override async Task<AuthenticationState> GetAuthenticationStateAsync()
        {
            var identity = new ClaimsIdentity();
            if (cachedUser == null)
            {
                var userFromStorage = await cacheService.GetCachedUserAsync();
                if (userFromStorage != null)
                {
                    await ValidateUser(userFromStorage);
                    identity = SetupClaimsForUser(userFromStorage);
                }
            }
            else
            {
                identity = SetupClaimsForUser(cachedUser);
            }
            
            ClaimsPrincipal cachedClaimsPrincipal = new ClaimsPrincipal(identity);
            return await Task.FromResult(new AuthenticationState(cachedClaimsPrincipal));
        }

        private ClaimsIdentity SetupClaimsForUser(User user)
        {
            List<Claim> claims = new List<Claim>();
            claims.Add(new Claim(ClaimTypes.Role, user.SecurityType));
            ClaimsIdentity identity = new ClaimsIdentity(claims, "apiauth_type");
            return identity;
        }

        public async Task ValidateUser(User userCred)
        {
            if (string.IsNullOrEmpty(userCred.Email)) throw new Exception("Enter username");
            if (string.IsNullOrEmpty(userCred.Password)) throw new Exception("Enter password");

            var identity = new ClaimsIdentity();
            try
            {
                var user = await loginService.ValidateUser(userCred);
                identity = SetupClaimsForUser(user);
                await cacheService.SetUserToCacheAsync(user);
                await cacheService.SetTokenToCacheAsync(user.Token);
                cachedUser = user;
            }
            catch (Exception e)
            {
                throw new Exception(e.Message);
            }
            
            NotifyAuthenticationStateChanged(Task.FromResult(new AuthenticationState(new ClaimsPrincipal(identity))));
        }

        public async Task Logout()
        {
            cachedUser = null;
            var user = new ClaimsPrincipal(new ClaimsIdentity());
            await cacheService.SetUserToCacheAsync(cachedUser);
            await cacheService.SetTokenToCacheAsync("");
            NotifyAuthenticationStateChanged(Task.FromResult(new AuthenticationState(user)));
        }
    }
}