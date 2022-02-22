public class Book
{
  String author, title;
  double price;
  int pages;

  public Book(String author, String title, double price, int pages)
  {
    this.author = author;
   this.title = title;
   this.price = price;
   this.pages = pages;
  }

  public double getPrice()
  {
    return price;
  }

  public int getPages()
  {
    return pages;
  }

  public String getAuthor()
  {
    return author;
  }

  public String getTitle()
  {
    return title;
  }

  public String toString()
  {
    return "Book{" + "author='" + author + '\'' + ", title='" + title + '\''
        + ", price=" + price + ", pages=" + pages + '}';
  }
}
