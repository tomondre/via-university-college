public class Book
{
private String title;
private int year;
public Book(String title,int year){
this.title = title;
this.year = year;
}
  public int getYear()
  {
    return year;
  }
  public String getTitle()
  {
    return title;
  }

  @Override public String toString()
  {
    return "Book{" + "title='" + title + '\'' + ", year=" + year + '}';
  }
}




