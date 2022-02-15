package Ex12_1.client.network;

import Ex12_1.shared.PropertyChangeSubject;

import java.util.Date;

public interface Client extends PropertyChangeSubject
{
  String getLastUpdateTimeStamp();
  int getNumberOfUpdates();
  void setTimeStamp(Date timeStamp);
  void startClient();
}
