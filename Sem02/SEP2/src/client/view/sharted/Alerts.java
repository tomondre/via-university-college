package client.view.sharted;

import javafx.scene.control.ButtonType;

public class Alerts
{
    public static boolean throwAlert(javafx.scene.control.Alert.AlertType type, String message)
    {
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(type);
        alert.setContentText(message);
        alert.show();
        return alert.getResult() == ButtonType.YES;
    }
}
