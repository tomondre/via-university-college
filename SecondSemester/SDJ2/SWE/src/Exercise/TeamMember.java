package Exercise;

public class TeamMember extends Employee
{
  private String role;
  public TeamMember(String email, String name, String role)
  {
    super(email, name);
    this.role = role;
  }
  public void setRole(String role)
  {
    this.role = role;
  }
  public String toString()
  {
    return super.toString() + ", role: " + role;
  }
  public boolean equals(Object obj)
  {
    if (!(obj instanceof TeamMember))
    {
      return false;
    }
    TeamMember other = (TeamMember) obj;
    return super.equals(other) && role.equals(other.role);
  }
  @Override public String getRole()
  {
    return role;
  }
}
