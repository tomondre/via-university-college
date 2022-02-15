public class Website
{
  private String content;
  private URL url;
  public Website(URL url, String content)
  {
    this.content = content;
    this.url = url;
  }

  public String getUrl()
  {
    return url.getDomain();
  }
  public String getContent()
  {
    return content;
  }
  public void setContent(String content)
  {
    this.content = content;
  }
  public Website copy()
  {
    return new Website(url,content);
  }

  @Override public String toString()
  {
    return "Website{" + "content='" + content + '\'' + ", url=" + url + '}';
  }
}