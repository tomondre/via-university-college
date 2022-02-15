using System;

namespace WebShop.Services.Observer
{
    public interface IObserverService
    {
        public void ChangeHappens();
        public event Action OnChange;
    }
}