package server.model.manager;

import shared.Ward;

import java.util.ArrayList;

public interface WardServerModelManager
{
    void addWard(Ward ward);
    void removeWard(Ward ward);
    ArrayList<Ward> getAllWards();
    void editWard(Ward oldWard, Ward newWard);
}
