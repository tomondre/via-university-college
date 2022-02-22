public class PrintedBook extends Book
{
  private boolean isPaperback;

  public PrintedBook(String title, String isbn, boolean paperBack)
  {
    super(title, isbn);
    this.isPaperback = isPaperback;
  }

  public boolean isPaperback()
  {
    return isPaperback;
  }

  public String getBookType()
  {
    return "PrintedBook";
  }

  public String toString()
  {
    return super.toString();
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof PrintedBook))
    {
      return false;
    }
    PrintedBook other = (PrintedBook)obj;
    return super.equals(other)&&isPaperback == other.isPaperback;
  }


}
