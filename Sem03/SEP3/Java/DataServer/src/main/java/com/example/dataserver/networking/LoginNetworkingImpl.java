package com.example.dataserver.networking;

import com.example.dataserver.models.User;
import com.example.dataserver.persistence.login.LoginDAO;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import networking.login.LoginServiceGrpc;
import networking.user.UserMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@GrpcService
@EnableAsync
public class LoginNetworkingImpl extends LoginServiceGrpc.LoginServiceImplBase
{
  private LoginDAO loginDAO;

  @Autowired
  public LoginNetworkingImpl(LoginDAO loginDAO)
  {
    this.loginDAO = loginDAO;
  }

  @Async
  @Override
  public void getUserLogin(UserMessage request,
      StreamObserver<UserMessage> responseObserver)
  {
    try
    {
      var userLoginFuture = loginDAO.getUserLogin(new User(request));
      var userLogin = getObjectAfterDone(userLoginFuture);
      var userMessage = userLogin.toMessage();
      responseObserver.onNext(userMessage);
      responseObserver.onCompleted();
    }
    catch (Exception e)
    {
      responseObserver.onError(
              Status.INTERNAL.withDescription("Could not fetch the user credentials from the database.").asException());

    }
  }

  private synchronized <T> T getObjectAfterDone(Future<T> future) throws Exception
  {
    T object;
    while (true)
    {
      if (future.isDone())
      {
        try
        {
          object = future.get();
          break;
        }
        catch (ExecutionException | InterruptedException e)
        {
          throw new Exception(e);
        }
      }
    }
    return object;
  }
}
