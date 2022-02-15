package Cd;

import java.util.Arrays;

public class Cd
{
  private String title, artist;
  private Song[] songs;

  public Cd(String title, String artist, Song[] songs)
  {
    this.title = title;
    this.artist = artist;
    this.songs = songs;
  }

  public Cd(String title, Song[] songs)
  {
    this.title = title;
    this.songs = songs;
  }

  public String getTitle()
  {
    return title;
  }

  public String getArtist()
  {
    return artist;
  }

  public Song getSong(int index)
  {
    return songs[index];
  }

  public int getNumberOfSongs()
  {
    return songs.length;
  }

  public Time getTotalLength()
  {
    int sum = 0;
    for (int i = 0; i < songs.length; i++)
    {
      sum += songs[i].getLength().getTimeInSeconds();
    }
    int hour = sum / 3600;
    int minute = (sum % 3600) / 60;
    int second = sum % 60;
    return new Time(hour, minute, second);
  }

  public int getNumberOfSongsByArtist(String artist)
  {
    int number = 0;
    for (int i = 0; i < songs.length; i++)
    {
      if (songs[i].getArtist().equals(artist))
      {
        number++;
      }
    }
    return number;
  }

  public Song[] getSongsByArtist(String artistt)
  {
    Song[] temp = new Song[getNumberOfSongsByArtist(artistt)];

    for (int i = 0; i < songs.length; i++)
    {
      if (songs[i].getArtist().equals(artistt))
      {
        for (int x = 0; x < temp.length; x++)
        {
          if (temp[x] == null)
          {
            temp[x] = songs[i];
          }
        }
      }

    }
    return temp;
  }
public int getLengthInSecondsInLongestSong(){
    int temp = songs[0].getLength().getTimeInSeconds();
    for (int i = 0; i<songs.length;i++){
      if (temp<songs[i].getLength().getSecond()){
        temp=songs[i].getLength().getSecond();
      }
    }
    return temp;
}
  @Override public String toString()
  {
    return "Cd{" + "title='" + title + '\'' + ", artist='" + artist + '\''
        + ", songs=" + Arrays.toString(songs) + '}';
  }

  public static void main(String[] args){

    Time t3=new Time(60);
    Time t1=new Time(50);
    Time t2=new Time(36);
    Song s1=new Song("lol", "a",t1);
    Song s2=new Song("ksdmks","b",t2);
    Song s3=new Song("title3","a",t3);
    Song[] songs = new Song[3];
    songs[0]=s1;
    songs[1]=s2;
    songs[2]=s3;
    Cd cd = new Cd("Cd","cdartist",songs);
    System.out.println(cd.getLengthInSecondsInLongestSong());
    Song[] temp = cd.getSongsByArtist("a");
    for (int i = 0; i< temp.length;i++){
      System.out.println(songs[i]);
    }
    System.out.println(cd.getTotalLength());
    System.out.println(cd.getNumberOfSongs());
  }
}
