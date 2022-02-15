import java.util.ArrayList;
public class ServiceBook
{
  private ArrayList<Service> service;

  public ServiceBook()
  {
    service = new ArrayList<Service>();
  }

  public void addService(Service servicee)
  {
    service.add(servicee);
  }

  public int getNumberOfServices()
  {
    return service.size();
  }

  public Service getServices(int index)
  {
    return service.get(index);
  }

  public Service[] getAllService()
  {
return service.toArray(new Service[service.size()]);
  }

  public int[] getAllMilages()
  {
    int[] temp = new int[service.size()];
    for (int i = 0; i < temp.length; i++)
    {
      temp[i] = service.get(i).getMileage();
    }
    return temp;
  }

  public boolean hasServiceOnDate(Date date)
  {
    for (int i = 0; i < service.size(); i++)
    {
      if (date.equals(service.get(i).getDate()))
      {
        return true;
      }
    }
    return false;
  }
  public Date getDateOfLastService()
  {
    return service.get(service.size() - 1).getDate();
  }


}

