package shared;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class responsible for validating the inputs before they are send to the database
 */
public class Validator
{
  public static boolean isValidPassword(String password)
  {
    String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*[#]).{8,14}$";
    return matches(password, regex);
  }

  public static boolean isValidTelTimeFormat(String time)
  {
    try
    {
      LocalTime.parse(time);
      return true;
    }
    catch (DateTimeParseException | NullPointerException e)
    {
      return false;
    }
  }

  public static boolean isValidEmail(String email)
  {
    String regex = "^(.+)@(.+)$";
    return matches(email, regex);
  }

  private static boolean matches(String toValidate, String regex)
  {
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(toValidate);
    return matcher.matches();
  }


  public static boolean isValidSSN(long ssn)
  {
    return ssn >= 1000000000L && ssn <= 9999999999L;
  }

  public static boolean isDobValid(LocalDate localDate)
  {
    if (localDate == null)
      return false;

    return LocalDate.now().isAfter(localDate) && LocalDate.now().minusYears(130)
        .isBefore(localDate);
  }

  public static boolean isAppointmentDateValid(LocalDate appointmentDate)
  {
    if (appointmentDate == null)
    {
      return false;
    }
    return appointmentDate.isAfter(LocalDate.now()) && appointmentDate.isBefore(LocalDate.now().plusYears(2));
  }
}
