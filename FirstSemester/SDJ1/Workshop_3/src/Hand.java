public class Hand
{
  private Finger pinkyFinger, ringFinger, middleFinger, pointerFinger, thumb;

  public Hand()
  {
    pinkyFinger = new Finger(52,30);
    ringFinger = new Finger(54,25);
    middleFinger = new Finger(53,28);
    pointerFinger = new Finger(51,29);
    thumb = new Finger(50,26);
  }
  public boolean equals(Object obj){
    if (!(obj instanceof Hand)){return false;}
    Hand other = (Hand)obj;
    return pinkyFinger.equals(other.pinkyFinger)&&
        ringFinger.equals(other.ringFinger)&&
        middleFinger.equals(other.middleFinger)&&
        pointerFinger.equals(other.pointerFinger)&&
        thumb.equals(other.thumb);
  }
  @Override public String toString() {
    return "Hand{" + "pinkyFinger=" + pinkyFinger + ", ringFinger=" + ringFinger
        + ", middleFinger=" + middleFinger + ", pointerFinger=" + pointerFinger
        + ", thumb=" + thumb + '}';
  }
  public Finger getPinkyFinger()
  {
    return pinkyFinger.copy();
  }
  public Finger getRingFinger()
  {
    return ringFinger.copy();
  }
  public Finger getMiddleFinger()
  {
    return middleFinger.copy();
  }
  public Finger getPointerFinger()
  {
    return pointerFinger.copy();
  }
  public Finger getThumb()
  {
    return thumb.copy();
  }
  public void setPinkyFinger(double width, double lenght) {
    pinkyFinger.setWidth(width);
    pinkyFinger.setLength(lenght);
  }
  public void setRingFinger(double width, double length) {
    ringFinger.setLength(length);
    ringFinger.setWidth(width);
  }
  public void setMiddleFinger(double width, double lenght) {
    middleFinger.setWidth(width);
    middleFinger.setLength(lenght);
  }
  public void setPointerFinger(double width, double lenght) {
    pointerFinger.setLength(lenght);
    pointerFinger.setWidth(width);
  }
  public void setThumb(double width, double lenght) {
    thumb.setWidth(width);
    thumb.setLength(lenght);
  }
}
