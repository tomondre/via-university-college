package Ex12_1.server.model;

import Ex12_1.shared.PropertyChangeSubject;

import java.util.Date;

public interface DataModel extends PropertyChangeSubject
{

    String getLastUpdateTimeStamp();
    int getNumberOfUpdates();
    void setTimeStamp(Date timeStamp);
}
