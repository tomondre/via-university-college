package client.core;

import client.view.chat.ChatViewModel;
import client.view.clientListView.ClientListViewModel;
import client.view.login.LoginViewModel;

public class ViewModelFactory
{
  private ChatViewModel chatVM;
  private LoginViewModel loginVM;
  private ClientListViewModel clientListVM;
  private static ViewModelFactory viewModelFactory = new ViewModelFactory();

  private ViewModelFactory()
  {
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
