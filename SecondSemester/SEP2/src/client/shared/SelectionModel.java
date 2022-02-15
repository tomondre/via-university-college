package client.shared;

import client.view.sharted.View;
import shared.Sample;

public class SelectionModel
{
  private Object selectedObject;
  private View lastOpenedView;
  private static SelectionModel instance = new SelectionModel();

  private SelectionModel()
  {
  }

  public void set(Object selectedObject)
  {
    this.selectedObject = selectedObject;
  }

  public Object get()
  {
    Object selectedObject = this.selectedObject;
    this.selectedObject = null;
    return selectedObject;
  }

  public static SelectionModel getInstance()
  {
    return instance;
  }

  public boolean isEmpty()
  {
    return selectedObject == null;
  }

  public View getLastOpenedView()
  {
    return lastOpenedView;
  }

  public void setLastOpenedView(View lastOpenedView)
  {
    this.lastOpenedView = lastOpenedView;
  }

  public boolean isSample()
  {
    return selectedObject instanceof Sample;
  }
}
