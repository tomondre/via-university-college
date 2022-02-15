//package Ex6_1;
//
//import Ex6_1.PhoneWithState.Phone;
//import Ex6_1.PhoneWithState.PhoneState;
//
//public class SilentState implements PhoneState
//{
//  @Override public void onReceiveMessage(String txt, Phone phone)
//  {
//    phone.beepBeep();
//    phone.vibrate();
//
//    phone.receiveMessage(txt);
//  }
//
//  @Override public void onReceiveCall(Phone phone)
//  {
//    phone.playRingTone();
//  }
//
//  @Override public void onVolumeButtonUp(Phone phone)
//  {
//    phone.volumeUpButton();
//  }
//
//  @Override public void onVolumeButtonDown(Phone phone)
//  {
//    phone.turnVolumeDown();
//  }
//}
