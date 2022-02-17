package Ex4_3.model;

import java.util.ArrayList;
import java.util.List;

public interface TextConverter
{
  String toUpperCase(String text);
  void addLog(String log);
  ArrayList<String> getLog();
}
