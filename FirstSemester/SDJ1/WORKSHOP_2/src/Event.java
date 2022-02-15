import java.util.Objects;

public class Event
{
  private String title,description;
  private int id;
private Address address;
  public Event(String title, String description, int id)
  {
    this.title = title;
    this.description = description;
    this.id = id;
  }
  public String getTitle()
  {
    return title;
  }
  public String getDescription()
  {
    return description;
  }
  public int getId()
  {
    return id;
  }
  public Address getAddress()
  {
    return address;
  }
  public void setTitle(String title)
  {
    this.title = title;
  }
  public void setDescription(String description)
  {
    this.description = description;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public void setLocation(Address address)
  {
    this.address = address;
  }

  @Override public String toString()
  {
    return "Event{" + "title='" + title + '\'' + ", description='" + description
        + '\'' + ", id=" + id + ", address=" + address + '}';
  }

  @Override public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Event event = (Event) o;
    return id == event.id && title.equals(event.title) && description
        .equals(event.description) && Objects.equals(address, event.address);
  }

  @Override public int hashCode()
  {
    return 0;
  }
}
