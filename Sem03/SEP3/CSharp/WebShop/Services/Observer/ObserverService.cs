using System;

namespace WebShop.Services.Observer
{
    public class ObserverService : IObserverService
    {
        public delegate void Change();
        public event Action OnChange;

        public void ChangeHappens()
        {
            OnChange?.Invoke();
        }
    }
}