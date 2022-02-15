package Site;

public class Test
{

  public static void main(String[] args)
  {
    SiteCollection collection = new SiteCollection(4);
    collection.addSite(new Website("kdmskdms.com"));
    collection.addSite(new Website("kdmskdms.com"));
    collection.addSite(new Website("kdmskdms.com"));
    collection.addSite(new Website("kdmskdcxms.java"));
    System.out.println(collection.getNumberOfUpdatedSites());
    collection.getWebsite(0).markAsNotUpdated();
    Website[] temp = collection.getAllNotUpdatedSites();
  for (int i = 0; i < temp.length; i++)
    {
      System.out.println(temp[i]);
    }
  SiteAdministrator admin = new SiteAdministrator("Tomas");
  admin.addCollection(collection);
    System.out.println(admin.getNextSiteToUpdate());
    Website web = admin.getNextSiteToUpdate();
    web.markAsUpdated();
    System.out.println(collection.getNumberOfUpdatedSites());
    System.out.println(admin.getNextSiteToUpdate());

  }
}
