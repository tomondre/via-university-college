package shared;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest
{

  @Test void isValidPassword()
  {
    String passWordWithCorrectFormat = "1234Abcdef";
    assertTrue(Validator.isValidPassword(passWordWithCorrectFormat));
  }

  @Test void passwordWithoutUppercase()
  {
    String passwordWithoutUppercase = "1234abcdef";
    assertFalse(Validator.isValidPassword(passwordWithoutUppercase));
  }

  @Test void passwordWithoutNumber()
  {
    String passwordWithoutNumber = "Abcdefghijkl";
    assertFalse(Validator.isValidPassword(passwordWithoutNumber));
  }

  @Test void passwordWithoutNumberAndUppercase()
  {
    String passwordWithoutNumberAndUppercase = "abcdefghijkl";
    assertFalse(Validator.isValidPassword(passwordWithoutNumberAndUppercase));
  }

  @Test void passwordLengthMin()
  {
    String passwordLengthMin = "Abcd1234";
    assertTrue(Validator.isValidPassword(passwordLengthMin));
  }

  @Test void passwordLengthMinMinusOne()
  {
    String passwordLengthMinMinusOne = "Abcd123";
    assertFalse(Validator.isValidPassword(passwordLengthMinMinusOne));
  }

  @Test void passwordLengthMinPlusOne()
  {
    String passwordLengthPlusOne = "Abcd12345";
    assertTrue(Validator.isValidPassword(passwordLengthPlusOne));
  }

  @Test void passwordLengthMax()
  {
    String passwordLengthTooLong = "Aabcdefg123456";
    assertTrue(Validator.isValidPassword(passwordLengthTooLong));
  }

  @Test void passwordLengthMaxPlusOne()
  {
    String passwordLengthMaxPlusOne = "Aabcdefgh123456";
    assertFalse(Validator.isValidPassword(passwordLengthMaxPlusOne));
  }

  @Test void passwordLengthMaxMinusOne()
  {
    String passwordLengthMaxMinusOne = "Aabcdefgh1234";
    assertTrue(Validator.isValidPassword(passwordLengthMaxMinusOne));
  }


  @Test void isValidTelTimeFormat()
  {
    String validTime = "20:30:00";
    assertTrue(Validator.isValidTelTimeFormat(validTime));
  }

  @Test void hoursMax()
  {
    String validTime = "23:30:30";
    assertTrue(Validator.isValidTelTimeFormat(validTime));
  }

  @Test void hoursMaxMinusOne()
  {
    String validTime = "22:30:30";
    assertTrue(Validator.isValidTelTimeFormat(validTime));
  }

  @Test void hoursMaxPlusOne()
  {
    String notValidTime = "25:30:30";
    assertFalse(Validator.isValidTelTimeFormat(notValidTime));
  }

  @Test void hoursMin()
  {
    String validTime = "00:30:30";
    assertTrue(Validator.isValidTelTimeFormat(validTime));
  }

  @Test void hoursMinMinusOne()
  {
    String notValidTime = "-1:30:30";
    assertFalse(Validator.isValidTelTimeFormat(notValidTime));
  }

  @Test void hoursMinPlusOne()
  {
    String validTime = "01:30:30";
    assertTrue(Validator.isValidTelTimeFormat(validTime));
  }

  @Test void minutesMax()
  {
    String validTime = "12:59:30";
    assertTrue(Validator.isValidTelTimeFormat(validTime));
  }

  @Test void minutesMaxMinusOne()
  {
    String validTime = "12:58:30";
    assertTrue(Validator.isValidTelTimeFormat(validTime));
  }

  @Test void minutesMaxPlusOne()
  {
    String notValidTime = "12:60:30";
    assertFalse(Validator.isValidTelTimeFormat(notValidTime));
  }

  @Test void minutesMin()
  {
    String validTime = "12:00:30";
    assertTrue(Validator.isValidTelTimeFormat(validTime));
  }

  @Test void minutesMinMinusOne()
  {
    String notValidTime = "12:-1:30";
    assertFalse(Validator.isValidTelTimeFormat(notValidTime));
  }

  @Test void minutesMinPlusOne()
  {
    String validTime = "12:01:30";
    assertTrue(Validator.isValidTelTimeFormat(validTime));
  }

  @Test void secondsMax()
  {
    String validTime = "12:30:59";
    assertTrue(Validator.isValidTelTimeFormat(validTime));
  }

  @Test void secondsMaxMinusOne()
  {
    String validTime = "12:30:58";
    assertTrue(Validator.isValidTelTimeFormat(validTime));
  }

  @Test void secondsMaxPlusOne()
  {
    String notValidTime = "12:30:60";
    assertFalse(Validator.isValidTelTimeFormat(notValidTime));
  }

  @Test void secondsMin()
  {
    String validTime = "12:30:00";
    assertTrue(Validator.isValidTelTimeFormat(validTime));
  }

  @Test void secondsMinMinusOne()
  {
    String notValidTime = "12:30:0-1";
    assertFalse(Validator.isValidTelTimeFormat(notValidTime));
  }

  @Test void secondsMinPlusOne()
  {
    String validTime = "12:30:01";
    assertTrue(Validator.isValidTelTimeFormat(validTime));
  }

  
  @Test void isValidEmail()
  {
    String validMail = "valid@email.com";
    assertTrue(Validator.isValidEmail(validMail));
  }

  @Test void mailWithoutAt()
  {
    String mailWithoutAt = "notValid.Mail";
    assertFalse(Validator.isValidEmail(mailWithoutAt));
  }

  @Test void ssnMax()
  {
    long notValidSsn = 9999999999L;
    assertTrue(Validator.isValidSSN(notValidSsn));
  }

  @Test void ssnMaxMinusOne()
  {
    long notValidSsn = 9999999998L;
    assertTrue(Validator.isValidSSN(notValidSsn));
  }

  @Test void ssnMaxPlusOne()
  {
    long notValidSsn = 10000000000L;
    assertFalse(Validator.isValidSSN(notValidSsn));
  }

  @Test void ssnMin()
  {
    long notValidSsn = 1000000000L;
    assertTrue(Validator.isValidSSN(notValidSsn));
  }

  @Test void ssnMinMinusOne()
  {
    long notValidSsn = 999999999L;
    assertFalse(Validator.isValidSSN(notValidSsn));
  }

  @Test void ssnMinPlusOne()
  {
    long notValidSsn = 1000000001L;
    assertTrue(Validator.isValidSSN(notValidSsn));
  }

  @Test void isAppointmentDateValid()
  {
    LocalDate date = LocalDate.now().plusWeeks(3);
    assertTrue(Validator.isAppointmentDateValid(date));
  }

  @Test void appointmentDateNull()
  {
    LocalDate date = null;
    assertFalse(Validator.isAppointmentDateValid(date));
  }

  @Test void appointedDateBeforeCurrentDate()
  {
    LocalDate notValidAppointmentDate = LocalDate.now().minusDays(1);
    assertFalse(Validator.isAppointmentDateValid(notValidAppointmentDate));
  }

  @Test void appointmentDateTooLate()
  {
    LocalDate date = LocalDate.now().plusYears(3);
    assertFalse(Validator.isAppointmentDateValid(date));
  }

  @Test void isDobValid()
  {
    LocalDate validDate = LocalDate.now().minusYears(60);
    assertTrue(Validator.isDobValid(validDate));
  }

  @Test void dobTooOld()
  {
    LocalDate notValidDate = LocalDate.now().minusYears(200);
    assertFalse(Validator.isDobValid(notValidDate));
  }

  @Test void dobAfterCurrentDate()
  {
    LocalDate notValidDate = LocalDate.now().plusDays(1);
    assertFalse(Validator.isDobValid(notValidDate));
  }
}