using System.ComponentModel.DataAnnotations;

namespace S04_Ex02.Models
{
    public class Todo
    {
        [Range(1, int.MaxValue, ErrorMessage = "Please enter a value bigger than {1}")]
        public int UserId { get; set; }
        public int TodoId { get; set; }
        [Required, MaxLength(120)]
        public string Title { get; set; }
        public bool IsCompleted { get; set; }
    }
}