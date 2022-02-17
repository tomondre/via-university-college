using System.Collections.Generic;
using S04_Ex02.Models;

namespace S04_Ex02.Data
{
    public interface ITodosData
    {
        IList<Todo> GetTodos();
        void AddTodo(Todo todo);
        void RemoveTodo(int todoId);
        void Update(Todo todo);
    }
}