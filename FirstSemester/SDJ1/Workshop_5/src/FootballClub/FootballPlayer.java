package FootballClub;

public class FootballPlayer
{
  private String name, fieldPosition;
  private int skill, number;
  private boolean isCaptain;

  public FootballPlayer(String name, int skill)
  {
    this.name = name;
    this.skill = skill;

  }

  public String getName()
  {
    return name;
  }

  public int getNumber()
  {
    return number;
  }
  public void assignNumber(int number)
  {
    this.number = number;
  }

  public int getSkill()
  {
    return skill;
  }

  public void train()
  {
    skill++;
  }

  public String getFieldPosition()
  {
    return fieldPosition;
  }

  public void setFieldPosition(String fieldPosition)
  {
    this.fieldPosition = fieldPosition;
  }
public boolean isCaptain()
{
  return isCaptain;

}
public void captain(boolean captain)
{
  isCaptain = captain;
}

  @Override public String toString()
  {
    return "FootballPlayer{" + "name='" + name + '\'' + ", fieldPosition='"
        + fieldPosition + '\'' + ", skill=" + skill + ", number=" + number
        + ", isCaptain=" + isCaptain + '}';
  }

  public static void main(String[] args)
  {
FootballPlayer player = new FootballPlayer("Tomas", 5);
    System.out.println(player.getNumber());
  }
}