using Microsoft.EntityFrameworkCore;
using Person;

namespace FileData
{
    public class AdultContext : DbContext
    {
        public DbSet<Adult> Adults { get; set; }
        public DbSet<User> Users { get; set; }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            // name of database
            optionsBuilder.UseSqlite("Data Source = Adult.db");
        }
    }
}