package Ex22_2.client.core;

import Ex22_2.client.view.chat.ChatViewModel;
import Ex22_2.client.view.clientListView.ClientListViewModel;
import Ex22_2.client.view.login.LoginViewModel;

public class ViewModelFactory
{
  private ChatViewModel chatVM;
  private LoginViewModel loginVM;
  private ClientListViewModel clientListVM;
  private ModelFactory mf;
  private static ViewModelFactory viewModelFactory = new ViewModelFactory();

  private ViewModelFactory()
  {
    mf = ModelFactory.getInstance();
    chatVM = new ChatViewModel();
    loginVM = new LoginViewModel();
    clientListVM = new ClientListViewModel();
  }

  public static ViewModelFactory getInstance()
  {
    return viewModelFactory;
  }

  public ChatViewModel getChatViewModel()
  {
    return chatVM;
  }

  public LoginViewModel getLoginViewModel()
  {
    return loginVM;
  }

  public ClientListViewModel getClientListViewModel()
  {
    return clientListVM;
  }
}
