package client.view_models.login;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import shared.CurrentUser;

public class DoctorMainViewModel
{
    private StringProperty currentUser;
    private StringProperty nrOfAppointmentsProperty;

    public DoctorMainViewModel()
    {
        nrOfAppointmentsProperty = new SimpleStringProperty();
        currentUser = new SimpleStringProperty();
    }

    public StringProperty currentUserProperty()
    {
        return currentUser;
    }

    public void setCurrentUser()
    {
        currentUser.set(CurrentUser.getInstance().getFullName());
        nrOfAppointmentsProperty.set(String.valueOf(CurrentUser.getInstance().getNrOfAppointments()));
    }

    public StringProperty nrOfAppointmentsProperty()
    {
        return nrOfAppointmentsProperty;
    }
}
