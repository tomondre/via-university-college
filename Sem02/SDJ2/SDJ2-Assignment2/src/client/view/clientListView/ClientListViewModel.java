package client.view.clientListView;

import client.model.Model;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;
import shared.Message;
import shared.Request;
import shared.RequestType;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Collections;

public class ClientListViewModel implements PropertyChangeListener
{
  private ObservableList<String> clientNames;

  private Model model;

  public ClientListViewModel(Model model)
    {
      this.model = model;
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
