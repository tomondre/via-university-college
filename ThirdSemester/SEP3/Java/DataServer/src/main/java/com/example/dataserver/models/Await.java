package com.example.dataserver.models;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Await
{
    public static synchronized <T> T await(Future<T> future) throws ExecutionException, InterruptedException
    {
        T object;
        while (true)
        {
            if (future.isDone())
            {
                object = future.get();
                break;
            }
        }
        return object;
    }

}
