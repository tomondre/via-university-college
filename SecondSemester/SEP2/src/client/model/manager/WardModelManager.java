package client.model.manager;

import shared.Ward;

import java.util.ArrayList;

public interface WardModelManager
{
  void addWard(Ward ward);
  void editWard(Ward oldWard, Ward newWard);
  void removeWard(Ward ward);
  ArrayList<Ward> getAllWards();
}
