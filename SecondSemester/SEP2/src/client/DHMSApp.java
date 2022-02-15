package client;

import client.core.InterfaceEnum;
import client.core.ModelFactory;
import client.core.ViewHandler;
import client.model.shared.CallBackModel;
import javafx.application.Application;
import javafx.stage.Stage;

public class DHMSApp extends Application
{
    @Override
    public void start(Stage stage) throws Exception
    {
        ViewHandler.getViewHandler().start();
    }
}
