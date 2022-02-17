package FootballClub;

import java.util.ArrayList;

public class FootbalClub
{
  private String name;
  private ArrayList<FootballPlayer> players;

  public FootbalClub(String name)
  {
    this.name = name;
  }

  public void signPlayer(FootballPlayer player, String fieldPosition,
      int number)
  {
    player.setFieldPosition(fieldPosition);
    player.assignNumber(number);
    players.add(player);

  }

  public void trainGoalKeepers()
  {
    for (int i = 0; i < players.size(); i++)
    {
      if (players.get(i).getFieldPosition().equals("Goalkeeper"))
      {
        players.get(i).train();
      }
    }
  }

  public void trainOutfieldPlayers()
  {
    for (int i = 0; i < players.size(); i++)
    {
      if (players.get(i).getFieldPosition().equals("Defender") || players.get(i)
          .getFieldPosition().equals("Midfielder") || players.get(i)
          .getFieldPosition().equals("Forward"))
      {
        players.get(i).train();
      }
    }
  }

  public FootballPlayer getCaptain()
  {
    for (int i = 0; i < players.size(); i++)
    {
      if (players.get(i).isCaptain())
      {
        return players.get(i);
      }
    }
    return null;
  }

  public void setNewCaptain(int number)
  {
    getCaptain().captain(false);

    for (int i = 0; i < players.size(); i++)
    {
      if (players.get(i).getNumber() == number)
      {
        players.get(i).captain(true);
      }
    }

  }

  public ArrayList<FootballPlayer> getPlayersInPositions(String position)
  {
    ArrayList<FootballPlayer> temp = new ArrayList<FootballPlayer>();
    for (int i = 0; i < players.size(); i++)
    {
      if (players.get(i).getFieldPosition().equals(position))
      {
        temp.add(players.get(i));

      }

    }
    return null;
  }

  @Override public String toString()
  {
    return "FootbalClub{" + "name='" + name + '\'' + ", players=" + players
        + '}';
  }
}
