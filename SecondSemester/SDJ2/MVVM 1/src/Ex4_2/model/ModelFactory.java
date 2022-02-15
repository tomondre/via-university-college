package Ex4_2.model;

import Ex4_2.model.TextConvertModel;
import Ex4_2.model.TextConverter;

public class ModelFactory
{
  private TextConverter textConverter;

  public TextConverter getTextConverter()
  {
    if (textConverter == null)
    {
    textConverter = new TextConvertModel();
    }
    return textConverter;
  }
}
