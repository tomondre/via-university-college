package FirstGUI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SimpleGUI extends Application
{
  private Scene scene;

  private HBox mainPane;
  private VBox leftBox;
  private VBox right;
  private GridPane middle;
  private RadioButton ok;
  private RadioButton cancel;
  private Label x;
  private Label y;
  private TextField xtxt;
  private TextField ytxt;

  private Button okButton;
  private Button cancelButton;
  private Button clearButton;
  private ToggleGroup toggleGroup;

  public void start(Stage window)
  {
    window.setTitle("Align");

    toggleGroup = new ToggleGroup();

    ok = new RadioButton("Exit on OK");
    cancel = new RadioButton("Exit On Cancel");
    ok.setSelected(true);

    ok.setToggleGroup(toggleGroup);
    cancel.setToggleGroup(toggleGroup);

    leftBox = new VBox(20);
    leftBox.getChildren().addAll(ok, cancel);
    leftBox.setAlignment(Pos.CENTER_LEFT);

    x = new Label("X: ");
    xtxt = new TextField();
    y = new Label("Y: ");
    ytxt = new TextField();

    middle = new GridPane();
    middle.addRow(0, x, xtxt);
    middle.addRow(1, y, ytxt);
    middle.setVgap(12);
    middle.setHgap(5);
    middle.setAlignment(Pos.CENTER);


    okButton = new Button("Ok");
    cancelButton = new Button("Cancel");
    clearButton = new Button("Clear");


    right = new VBox(5);
    right.setPrefWidth(70);
    okButton.setMinWidth(right.getPrefWidth());
    cancelButton.setMinWidth(right.getPrefWidth());
    clearButton.setMinWidth(right.getPrefWidth());
    right.getChildren().addAll(okButton, cancelButton, clearButton);
    right.setAlignment(Pos.CENTER);

    mainPane = new HBox(20);
    mainPane.getChildren().addAll(leftBox, middle, right);

    scene = new Scene(mainPane, 450, 120);
    window.setScene(scene);
    window.show();

  }

}
