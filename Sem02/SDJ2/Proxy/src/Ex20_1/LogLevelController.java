package Ex20_1;

public class LogLevelController implements Logger
{

  public enum LOG_LEVEL
  {
    SPARSE, VERBOSE;
  }

  private LOG_LEVEL currentLevel;
  private Logger logger;

  public LogLevelController(LOG_LEVEL currentLevel, Logger logger)
  {
    this.currentLevel = currentLevel;
    this.logger = logger;
  }

  @Override public void log(String txt)
  {
    if (currentLevel == LOG_LEVEL.VERBOSE)
    {
      logger.log(txt);
    }
    else if (txt.toLowerCase().contains("error"))
    {
      logger.log(txt);
    }

  }
}
