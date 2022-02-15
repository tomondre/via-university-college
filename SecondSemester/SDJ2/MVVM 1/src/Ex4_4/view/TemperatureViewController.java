//package Ex4_4.view;
//
//import javafx.fxml.FXML;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
//
//public class TemperatureViewController
//{
//  @FXML private Label outputLabel;
//  @FXML private TextField filterField;
//  @FXML private Label filterLabel;
//  private ViewHandler viewHandler;
//  private TemperatureViewModel viewModel;
//
//  public TemperatureViewController()
//  {
//  }
//
//  public void init(ViewHandler viewHandler,
//      TemperatureViewModel viewModel)
//  {
//    this.viewHandler = viewHandler;
//    this.viewModel = viewModel;
//
//    // TODO: Statements to bind to viewModel properties
//  }
//
//  public void reset()
//  {
//    // empty
//  }
//
//  @FXML private void updateButtonPressed()
//  {
//    viewModel.getValue();
//  }
//
//  @FXML private void onFilter()
//  {
//    viewModel.updateThermometerId();
//  }
//}
