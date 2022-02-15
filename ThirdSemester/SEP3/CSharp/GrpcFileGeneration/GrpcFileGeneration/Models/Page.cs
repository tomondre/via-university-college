using System.Collections.Generic;
using Networking.Page;
using Networking.Request;

namespace GrpcFileGeneration.Models
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
        public Page(PageMessage pageMessage)
        {
            TotalElements = pageMessage.TotalElements;
            TotalPages = pageMessage.TotalPages;
            PageNumber = pageMessage.PageNumber;
        }
    }
}