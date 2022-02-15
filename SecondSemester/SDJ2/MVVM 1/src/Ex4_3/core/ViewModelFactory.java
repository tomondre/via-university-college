package Ex4_3.core;

import Ex4_3.model.ModelFactory;

public class ViewModelFactory
{
  private UppercaseViewModel uppercaseVM;
  private LogViewModel logVM;
  private ModelFactory mf;

  public ViewModelFactory(ModelFactory mf)
  {
    this.mf = mf;
    this.uppercaseVM = new UppercaseViewModel(mf.getTextConverter());
    this.logVM = new LogViewModel(mf.getTextConverter());
  }

  public UppercaseViewModel getUppercaseVM()
  {
    if (uppercaseVM == null)
    {
      uppercaseVM = new UppercaseViewModel(mf.getTextConverter());
    }
    return uppercaseVM;
  }

  public LogViewModel getLogVM()
  {
    if (logVM == null)
    {
      logVM = new LogViewModel(mf.getTextConverter());
    }
    return logVM;
  }

}
