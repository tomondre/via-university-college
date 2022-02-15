public class Brain
{
  private String activeMemoryItem, passiveMemoryItemOne, passiveMemoryItemTwo;

  public Brain() {
    activeMemoryItem = "";
    passiveMemoryItemOne = "";
    passiveMemoryItemTwo = "";
  }
  public int getIQ() {
    int c1 = activeMemoryItem.length();
    int c2 = passiveMemoryItemOne.length();
    int c3 = passiveMemoryItemTwo.length();
    if ((c1>20||c2>20||c3>20)&&c1>10&&c2>10&&c3>10)
    {
      return 130;
    }
    if (c1>10&&c2>10&&c3>10)
    {
      return 100;
    }
    else return 70;
  }
  public boolean isBrainDamaged(){
    if (activeMemoryItem.equals(null)||passiveMemoryItemOne.equals(null)||passiveMemoryItemTwo.equals(null))return true;
    else return false;
  }
  public void remember(String info){
    passiveMemoryItemTwo = passiveMemoryItemOne;
    passiveMemoryItemOne = activeMemoryItem;
    activeMemoryItem = info;
  }
  public void refreshMemory(String info) {
  String x;
    if (info.equals(passiveMemoryItemOne)){
  x = activeMemoryItem;
  activeMemoryItem = passiveMemoryItemOne;
  passiveMemoryItemOne = x;
}
  if (info.equals(passiveMemoryItemTwo)){
    x = activeMemoryItem;
    activeMemoryItem = passiveMemoryItemTwo;
    passiveMemoryItemTwo = x;
  }

}
  public boolean recall(String info){
    return info.equals(activeMemoryItem)||info.equals(passiveMemoryItemTwo)||info.equals(passiveMemoryItemOne);
  }
  public String recall(){
    return activeMemoryItem;
  }
  public boolean equals(Object obj){
    if(!(obj instanceof Brain)){
      return false;
    }
    Brain other = (Brain)obj;
    return activeMemoryItem.equals(other.activeMemoryItem)&&
        passiveMemoryItemOne.equals(other.passiveMemoryItemOne)&&
        passiveMemoryItemTwo.equals(other.passiveMemoryItemTwo);
}
  @Override public String toString() {
    return "Brain{" + "activeMemoryItem='" + activeMemoryItem + '\''
        + ", passiveMemoryItemOne='" + passiveMemoryItemOne + '\''
        + ", passiveMemoryItemTwo='" + passiveMemoryItemTwo + '\'' + '}';
  }
  public static void main(String[] args){
    Brain br = new Brain();
    System.out.println(br);
br.remember("jdsndnsdlnsld");
    System.out.println(br);
    br.remember("dmdljsndsjdnsjndskmdakdmak");
    System.out.println(br);
    br.remember("444444444444444444");
    System.out.println(br);
    br.remember("dksdkdskdks;dk;s;sd");
    System.out.println(br);
    br.refreshMemory("444444444444444444");
    System.out.println(br);
    System.out.println(br.isBrainDamaged());
    System.out.println(br.getIQ());
  }
}