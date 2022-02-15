package Ex4_3.model;

import java.util.ArrayList;
import java.util.List;

public class TextConvertModel implements TextConverter
{
  ArrayList<String> log = new ArrayList<String>();

  @Override public String toUpperCase(String text)
  {
    log.add(text);
    return text.toUpperCase();
  }

  @Override public void addLog(String log)
  {
    this.log.add(log);
  }

  @Override public ArrayList<String> getLog()
  {
    return log;
  }
}
