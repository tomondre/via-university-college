import java.util.ArrayList;
public class BookList
{

  private ArrayList<Book> books;
  public BookList()
  {
books = new ArrayList<Book>();
  }

  public int getNumberOfBooks()
  {
    return books.size();
  }



}
