package client.view.chat;

import client.model.Model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import shared.Message;
import shared.Request;
import shared.RequestType;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ChatViewModel implements PropertyChangeListener
{
  private StringProperty nameProperty;
  private StringProperty messageProperty;
  private StringProperty chatProperty;

  private Model model;

  public ChatViewModel(Model model)
  {
    this.model = model;
    model.addPropertyChangeListener(this);
    nameProperty = new SimpleStringProperty();
    messageProperty = new SimpleStringProperty();
    chatProperty = new SimpleStringProperty("");
  }

  public void sendMessage()
  {
    model.sendMessage(messageProperty.get());
    messageProperty.set("");
  }

  public void setName()
  {
    model.setName(nameProperty.get());
    nameProperty.set("");
  }

  public StringProperty getMessageProperty()
  {
    return messageProperty;
  }

  public StringProperty getChatProperty()
  {
    return chatProperty;
  }

  public StringProperty getNameProperty()
  {
    return nameProperty;
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    Request request = (Request) evt.getNewValue();
    if (request.getRequest() == RequestType.Message)
    {
      String newString =
          chatProperty.get() + ((Message) request.getArg()).get() + "\n";
      chatProperty.set(newString);
    }
  }

  public int getNumberOfConnectedClients()
  {
    return model.getNumberOfConnectedClients();
  }
}
