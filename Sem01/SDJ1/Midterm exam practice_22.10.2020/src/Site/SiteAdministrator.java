package Site;

public class SiteAdministrator
{
  private String name;
  private SiteCollection collection;

  public SiteAdministrator(String name)
  {
    this.name = name;
    collection = null;
  }

  public void addCollection(SiteCollection collection)
  {
    this.collection = collection;
  }

  public String getName()
  {
    return name;
  }

  public SiteCollection getSiteCollection()
  {
    return collection;
  }

  public Website getNextSiteToUpdate()
  {
    return collection.getAllNotUpdatedSites().length == 0 ?
        null:collection.getAllNotUpdatedSites()[0];
  }

  public Website[] getAllSiteToUpdate()
  {
    return collection.getAllNotUpdatedSites();
  }

}
