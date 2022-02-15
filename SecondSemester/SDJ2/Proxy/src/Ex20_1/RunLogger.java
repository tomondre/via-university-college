package Ex20_1;

public class RunLogger
{
  public static void main(String[] args)
  {
    LogLevelController logger = new LogLevelController(
        LogLevelController.LOG_LEVEL.SPARSE, new ConsoleLogger());

    logger.log("Warning: twilight is close");
    logger.log("Warning: mother in law approaching");
    logger.log("Error: Ran out of cola");
  }
}
