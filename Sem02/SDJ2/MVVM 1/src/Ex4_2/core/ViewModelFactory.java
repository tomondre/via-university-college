package Ex4_2.core;

import Ex4_2.model.ModelFactory;
import Ex4_2.view.UppercaseViewModel;

public class ViewModelFactory
{
  private UppercaseViewModel uppercaseVM;
  private ModelFactory mf;

  public ViewModelFactory(ModelFactory mf)
  {
    this.mf = mf;
  }

  public UppercaseViewModel getUppercaseVM()
  {
    if (uppercaseVM == null)
    {
      uppercaseVM = new UppercaseViewModel(mf.getTextConverter());
    }
    return uppercaseVM;
  }

}
