package Ex4_2.view;

import Ex4_2.model.TextConverter;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class UppercaseViewModel
{
  private StringProperty request;
  private StringProperty reply;
  private StringProperty error;
  private TextConverter tc;

  public UppercaseViewModel(TextConverter tc)
  {
    this.tc = tc;
    request = new SimpleStringProperty();
    reply = new SimpleStringProperty();
    error = new SimpleStringProperty();
  }

  public void convert()
  {
    if (request.isEmpty().get())
    {
      error.setValue("Invalid value");
      return;
    }
    reply.setValue(tc.toUpperCase(requestProperty().get()));
  }

  public StringProperty errorProperty()
  {
    return error;
  }

  public StringProperty requestProperty()
  {
    return request;
  }

  public StringProperty replyProperty()
  {
    return reply;
  }
}
