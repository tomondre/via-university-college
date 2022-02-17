package client.view.sharted;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;


public interface ViewController
{
    void init(ViewModelFactory viewModelFactory, ViewHandler viewHandler);
}

