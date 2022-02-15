package Hotel;

public class  Bed
{
  private String bed;
  public Bed(String bed)
  {
    this.bed = bed;
  }
  public boolean isSingle(){
    return bed.equals("Single");
  }
  public boolean isDouble(){
    return bed.equals("Double");
  }
  public boolean isKingSize(){
    return bed.equals("King size");
  }
  public Bed copy(){
    return new Bed(bed);
  }
}
