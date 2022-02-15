package client.model.manager;

import client.networking.manager.WardClientManager;
import client.networking.manager.WardClientRMI;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import shared.Ward;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class WardModelManagerTest
{
  private WardModelManager test;
  private Ward dummyWard;

  @BeforeEach public void setUp()
  {
    WardClientManager client = new WardClientRMI();
    test = new WardModelManagerImpl(client);

    addDummyData();
  }

  @AfterEach private void undo()
  {
    test.removeWard(dummyWard);
  }

  private void addDummyData()
  {
    dummyWard = new Ward("Examination", 999);
  }

  @Test public void getAllWards()
  {
    test.addWard(dummyWard);
    ArrayList<Ward> allWards = test.getAllWards();

    assertNotNull(allWards);
  }

  @Test public void addWard()
  {
    test.addWard(dummyWard);

    assertTrue(isInDatabase(dummyWard));
  }

  @Test public void editWard()
  {
    test.addWard(dummyWard);

    Ward wardToEdit = dummyWard.copy();
    wardToEdit.setWardName("Nursery");
    wardToEdit.setRoomNumber(10000);

    test.editWard(dummyWard, wardToEdit);

    assertTrue( isInDatabase(wardToEdit));
  }

  @Test public void removeWard()
  {
    test.addWard(dummyWard);

    test.removeWard(dummyWard);
    assertFalse(isInDatabase(dummyWard));
  }

  private boolean isInDatabase(Ward isInDBWard)
  {
    ArrayList<Ward> allWards = test.getAllWards();
    for (Ward ward : allWards)
    {
      if (ward.getRoomNumber() == isInDBWard.getRoomNumber() && ward
          .getWardName().equals(isInDBWard.getWardName()))
      {
        return true;
      }
    }
    return false;
  }
}