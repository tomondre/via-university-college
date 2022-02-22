public class URLTest
{
  public static void main(String[] args)
  {
    URL url1 = new URL("com", "example", "home/index.html");
    System.out.println(url1.getDomain());
    System.out.println(url1.toString());
    URL url2 = new URL("com", "example");
    System.out.println(url2.equals(url1));

    URL url3 = url1.copy();
  }
}
