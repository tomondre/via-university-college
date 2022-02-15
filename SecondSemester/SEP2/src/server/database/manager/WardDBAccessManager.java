package server.database.manager;

import shared.Ward;

import java.util.ArrayList;

public interface WardDBAccessManager
{
    void addWard(Ward ward);
    void removeWard(Ward ward);
    ArrayList<Ward> getAllWards();
    void editWard(Ward oldWard, Ward newWard);
}
