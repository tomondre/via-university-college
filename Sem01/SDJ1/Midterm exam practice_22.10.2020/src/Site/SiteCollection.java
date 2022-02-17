package Site;

import java.util.ArrayList;

public class SiteCollection
{
  private int size;
  private ArrayList<Website> websites;

  public SiteCollection(int maxSites)
  {
    websites = new ArrayList<Website>(maxSites);
  }

  public int getNumberOfSites()
  {
    return websites.size();
  }

  public int getNumberOfUpdatedSites()
  {
    int temp = 0;
    for (int i = 0; i < websites.size(); i++)
    {
      if (!websites.get(i).needsUpdate())
      {
        temp++;

      }
    }
    return temp;
  }
  public void addSite(Website site)
  {
    websites.add(site);
  }
  public void removeSite(String url)
  {
    for (int i = 0; i < websites.size(); i++)
    {
      if(websites.get(i).getUrl().equals(url))
      {
        websites.remove(i);
        break;
      }
    }
  }
  public Website[] getAllSites()
  {
    return websites.toArray(new Website[websites.size()]);
  }
  public Website getWebsite(int  index)
  {
    return websites.get(index);
  }
  public Website[] getAllNotUpdatedSites()
  {
    ArrayList<Website> temp = new ArrayList<Website>(websites.size());
    for (int i = 0; i < websites.size(); i++)
    {
      if(websites.get(i).needsUpdate())
      {
        temp.add(websites.get(i));
      }
    }
    return temp.toArray(new Website[temp.size()]);
  }

  @Override public String toString()
  {
    return "SiteCollection{" + "size=" + size + ", websites=" + websites + '}';
  }
}
