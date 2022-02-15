package Itms;

public class Book extends Item
{
  private String title;
  private int year;

  public Book(String title, int year, double price)
  {
    super(price);
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

  public String toString()
  {
    return super.toString() + ", Title: " + title + ", year: " + year;
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Book))
    {
      return false;
    }
    Book other = (Book) obj;

    return super.equals(other) && title.equals(other.title)
        && year == other.year;
  }
  public String getType()
  {
    return "Book";
  }
}
