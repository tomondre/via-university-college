package Student;

public class InvalidGradeException extends NullPointerException
{
  public InvalidGradeException()
  {
    super("Invalid grade");
  }
}
