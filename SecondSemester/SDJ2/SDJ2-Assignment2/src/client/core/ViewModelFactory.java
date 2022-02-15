package client.core;

import client.view.chat.ChatViewModel;
import client.view.clientListView.ClientListViewModel;
import client.view.login.LoginViewModel;

public class ViewModelFactory
{
  private ChatViewModel chatVM;
  private LoginViewModel loginVM;
  private ClientListViewModel clientListVM;
private ModelFactory mf;

  public ViewModelFactory(ModelFactory model)
  {
    mf = model;
    chatVM = new ChatViewModel(model.getModel());
    loginVM = new LoginViewModel(model.getModel());
    clientListVM = new ClientListViewModel(model.getModel());
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
