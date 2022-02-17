package client.core;

import model.HeatingSystem;
import model.Model;

public class ModelFactory
{
  private final Model model;

  public ModelFactory(){
    model = new HeatingSystem();
  }

  public Model getModel(){
    return model;
  }
}
