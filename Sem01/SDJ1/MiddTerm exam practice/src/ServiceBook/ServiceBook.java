package ServiceBook;

import java.util.ArrayList;

public class ServiceBook
{
  private ArrayList<Service> services;

  public ServiceBook()
  {
    services = new ArrayList<Service>();
  }

  public void addService(Service service)
  {
    services.add(service);
  }

  public int getNumberOfServices()
  {
    return services.size();
  }

  public Service getService(int index)
  {
    return services.get(index);
  }

  public Service[] getAllServices()
  {
    return services.toArray(new Service[services.size()]);
  }

  public int[] getAllServicesMileages()
  {
    int[] temp = new int[services.size()];
    for (int i = 0; i < services.size(); i++)
    {
      temp[i] = services.get(i).getMileage();
    }
    return temp;


//    List<Integer> temp = new LinkedList<>();
//
//
//    for (Service service : services)
//    {
//      temp.add(service.getMileage());
//    }
//    return services.toArray(new Integer[services.size()]);
//
//
//
  }



  public static void main(String[] args)
  {



  }
}
