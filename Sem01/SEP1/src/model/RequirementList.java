package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class containing a list of Requirement objects
 */
public class RequirementList implements Serializable
{
  private ArrayList<Requirement> requirements;

  /**
   * No-argument constructor initializing RequirementList
   */
  public RequirementList()
  {
    requirements = new ArrayList<Requirement>();
  }

  /**
   * Adds a Requirement to the list if there is no other existing Requirement with the same ID inside the list
   *
   * @param r the Requirement to be added
   */
  public void addRequirement(Requirement r)
  {
    for (Requirement req : requirements)                  //checking if the requirement is already in the list
    {
      if (req.getID().equals(r.getID()))
      {
        return;
      }
    }
    requirements.add(r);
    sortRequirementsByPriorities();
  }

  /**
   * Gets an ArrayList representation of all not approved Requirements from the list.
   * @return the Requirement objects which  field is not approved
   */
  public ArrayList<Requirement> getAllNotApprovedRequirements()
  {
    ArrayList<Requirement> temp = new ArrayList<>();
    for (Requirement r : requirements)
    {
      if (!r.toBeApproved() && !r.getStatus().equals(Requirement.APPROVED))
      {
        temp.add(r);
      }
    }
    return temp;
  }

  /**
   * Gets an ArrayList of all to be approved Requirement from the list.
   * @return the Requirement objects which status fields
   */
  public ArrayList<Requirement> getAllToBeApprovedRequirements()
  {
    ArrayList<Requirement> temp = new ArrayList<>();
    for (Requirement r : requirements)
    {
      if (r.toBeApproved())
      {
        temp.add(r);
      }
    }
    return temp;
  }

  /**
   * Sorts the Requirement objects by their priority
   */
  public void sortRequirementsByPriorities()
  {
    requirements
        .sort((x, y) -> Integer.compare(x.getPriority(), y.getPriority()));
  }

  /**
   * Gets a Requirement object with the given ID.
   * @param requirementID the requirement ID of the Requirement to get.
   * @return the Requirement object with the given ID.
   */
  public Requirement getRequirementByID(String requirementID)
  {
    for (Requirement requirement : requirements)
    {
      if (requirement.getID().equals(requirementID))
      {
        return requirement;
      }
    }
    return null;
  }

  /**
   * Gets a Requirement object with the given index.
   * @param index the index of Requirement object in the list
   * @return the Requirement object with the given index from the list
   */
  public Requirement get(int index)
  {
    return requirements.get(index);
  }

  /**
   * Removes a Requirement object with thee given requirement ID.
   * @param requirementID the ID of Requirement object to remove
   */
  public void removeRequirement(String requirementID)
  {
    requirements.remove(getRequirementByID(requirementID));
  }

  /**
   * Gets a number of Requirements inside the list.
   * @return the number of Requirement objects inside a list
   */
  public int size()
  {
    return requirements.size();
  }

  /**
   * Check status of all Requirement objects.
   */
  public void checkStatus()
  {
    for (Requirement req : requirements)
    {
      req.checkStatus();
    }
  }

  /**
   * Gets a copy of an existing RequirementList
   * @return new RequirementList with copied Requirement objects
   */
  public RequirementList copy()
  {

    RequirementList temp = new RequirementList();
    for (Requirement r : requirements)
    {
      temp.addRequirement(r.copy());
    }
    return temp;
  }
}


