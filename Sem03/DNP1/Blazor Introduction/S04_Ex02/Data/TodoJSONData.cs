using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text.Json;
using S04_Ex02.Models;

namespace S04_Ex02.Data
{
    public class TodoJSONData : ITodosData
    {
        private string todoFile = "todos.json";
        private List<Todo> todos;

        public TodoJSONData()
        {
            if (!File.Exists(todoFile))
            {
                Seed();
                SaveTodosToFile();
            }
            else
            {
                string content = File.ReadAllText(todoFile);
                todos = JsonSerializer.Deserialize<List<Todo>>(content);
            }
        }

        public IList<Todo> GetTodos()
        {
            List<Todo> tmp = new List<Todo>(todos);
            return tmp;
        }

        public void AddTodo(Todo todo)
        {
            var max = todos.Max(todo => todo.TodoId);
            todo.TodoId = ++max;
            todos.Add(todo);
            SaveTodosToFile();
        }

        private void SaveTodosToFile()
        {
            string todoAsJson = JsonSerializer.Serialize(todos);
            File.WriteAllText(todoFile, todoAsJson);
        }

        public void RemoveTodo(int todoId)
        {
            Todo toRemove = todos.First(t => t.TodoId == todoId);
            todos.Remove(toRemove);
            SaveTodosToFile();
        }

        public void Update(Todo todo)
        {
            Todo toUpdate = todos.First(t => t.TodoId == todo.TodoId);
            toUpdate.IsCompleted = todo.IsCompleted;
            SaveTodosToFile();
        }

        private void Seed()
        {
            Todo[] ts =
            {
                new Todo
                {
                    UserId = 1, TodoId = 1, Title = "Do dishes", IsCompleted = false
                },
                new Todo
                {
                    UserId = 1, TodoId = 2, Title = "Walk the dog", IsCompleted = false
                },
                new Todo
                {
                    UserId = 2, TodoId = 3, Title = "Do DNP homework", IsCompleted = false
                },
                new Todo
                {
                    UserId = 3, TodoId = 4, Title = "Eat breakfast", IsCompleted = false
                },
                new Todo
                {
                    UserId = 4, TodoId = 5, Title = "Mow lawn", IsCompleted = false
                }
            };
            todos = ts.ToList();
        }
    }
}