namespace WebShop.Models
{
    public class Page<T>
    {
        public T Content { set; get; }
        public long TotalElements { set; get; }
        public int TotalPages { set; get; }
        public int PageNumber { set; get; }

        public Page()
        {
        }
    }
}