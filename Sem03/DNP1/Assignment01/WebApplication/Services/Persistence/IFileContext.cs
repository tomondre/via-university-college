using System.Collections.Generic;
using Person;

namespace FileData
{
    public interface IFileContext
    {
        public IList<Adult> Adults { get; set; }
        public void SaveChanges();
    }
}