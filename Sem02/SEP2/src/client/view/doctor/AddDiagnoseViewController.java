package client.view.doctor;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.sharted.Alerts;
import client.view.sharted.View;
import client.view.sharted.ViewController;
import client.view_models.doctor.AddDiagnoseViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.security.InvalidParameterException;

public class AddDiagnoseViewController implements ViewController
{
    @FXML
    private TextField diagnoseName;
    @FXML
    private TextArea diagnoseDescription;
    @FXML
    private ComboBox<String> diagnoseSeverityLevel;
    @FXML
    private DatePicker diagnoseStartDate;
    @FXML
    private DatePicker endDate;

    private ViewHandler viewHandler;

    private AddDiagnoseViewModel addDiagnoseViewModel;

    @FXML
    public void onSaveButton()
    {
        try
        {
            addDiagnoseViewModel.save();
            Alerts.throwAlert(Alert.AlertType.INFORMATION, "Diagnosis successfully added.");
        }
        catch (InvalidParameterException e)
        {
            Alerts.throwAlert(Alert.AlertType.ERROR, e.getMessage());
        }
    }

    @FXML
    public void onBackButton()
    {
        viewHandler.openView(View.PATIENTS);
    }

    @FXML
    public void onClearButton()
    {
        addDiagnoseViewModel.clear();
    }

    @Override
    public void init(ViewModelFactory viewModelFactory, ViewHandler viewHandler)
    {
        this.viewHandler = viewHandler;
        addDiagnoseViewModel = (AddDiagnoseViewModel) viewModelFactory.getViewModel(View.ADD_DIAGNOSE);
        diagnoseName.textProperty().bindBidirectional(addDiagnoseViewModel.nameProperty());
        diagnoseDescription.textProperty().bindBidirectional(addDiagnoseViewModel.descriptionProperty());
        diagnoseSeverityLevel.valueProperty().bindBidirectional(addDiagnoseViewModel.severityLevelProperty());
        diagnoseStartDate.valueProperty().bindBidirectional(addDiagnoseViewModel.startDateProperty());
        endDate.valueProperty().bindBidirectional(addDiagnoseViewModel.endDateProperty());

        addDiagnoseViewModel.loadSelectedPatient();
        diagnoseSeverityLevel.getItems().setAll(addDiagnoseViewModel.getSeverityLevels());
    }
}
