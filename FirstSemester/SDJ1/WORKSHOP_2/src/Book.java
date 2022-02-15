import java.util.Objects;

public class  Book {
    private String title;
    private int year;
  public Book(String title, int year)
  {
    this.title = title;
    this.year = year;
  }
  public String getTitle()
  {
    return title;
  }
  public int getYear()
  {
    return year;
  }
  @Override public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Book book = (Book) o;
    return year == book.year && Objects.equals(title, book.title);
  }
  @Override public String toString()
  {
    return "Book{" + "title='" + title + '\'' + ", year=" + year + '}';
  }

}

