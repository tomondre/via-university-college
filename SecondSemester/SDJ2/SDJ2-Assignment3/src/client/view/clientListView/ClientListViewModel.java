package client.view.clientListView;

import client.core.ModelFactory;
import client.model.Model;
import shared.Request;
import shared.RequestType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ClientListViewModel implements PropertyChangeListener
{
  private ObservableList<String> clientNames;

  private Model model;

  public ClientListViewModel()
    {
      this.model = ModelFactory.getInstance().getModel();
      model.addPropertyChangeListener(this);
      clientNames = FXCollections.observableArrayList();
      clientNames.setAll(model.getClientNames());
    }

  public ObservableList<String> getClientList()
  {
    return clientNames;
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    Request request = (Request) evt.getNewValue();
    if (request.getRequest() == RequestType.NameChange)
    {
      clientNames.setAll(model.getClientNames());
    }
  }
}
