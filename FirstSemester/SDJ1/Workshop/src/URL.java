public class URL
{
  private String topdomain, subdomain, path;

  public URL(String topdomain, String subdomain, String path) {
    this.topdomain = topdomain;
    this.subdomain = subdomain;
    this.path = path;
  }
  public URL(String topdomain, String subdomain) {
    this.topdomain = topdomain;
    this.subdomain = subdomain;
    this.path="";
  }
  public URL copy()
  {
    return new URL(topdomain,subdomain,path);
  }
  public URL(URL url){
    this.topdomain = url.topdomain;
    this.subdomain = url.subdomain;
    this.path = url.path;
  }

  public String getPath()
  {
    return path;
  }
  public String getSubdomain()
  {
    return subdomain;
  }
  public String getTopdomain()
  {
    return topdomain;
  }
  public String getDomain()
  {
      return subdomain + "." + topdomain;
  }
  public boolean equals(URL url2) {
    if ("".equals(path))
    {
      if (topdomain.equals(url2.topdomain) && subdomain.equals(url2.subdomain))
      {
        return true;
      }
      else
        return false;
    }
    else {
      if (topdomain.equals(url2.topdomain) && subdomain.equals(url2.subdomain)
          && path.equals(url2.path))
      {
      return true;
    }
      else return false;
    }
  }
  @Override public String toString(){
    if (path == null)
  {
    return "http://" + subdomain + "." + topdomain;
  }
  else
    {
      return "http://" + subdomain + "." + topdomain + "/" + path;
    }
  }

}

