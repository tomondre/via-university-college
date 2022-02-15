package Ex22_2.client.view.clientListView;

import Ex22_2.client.core.ModelFactory;
import Ex22_2.client.model.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Ex22_2.shared.Request;
import Ex22_2.shared.RequestType;

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
