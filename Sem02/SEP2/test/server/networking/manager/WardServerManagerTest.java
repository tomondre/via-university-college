package server.networking.manager;

import client.model.manager.WardModelManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

class WardServerManagerTest
{
    private ArrayList<Method> methods;

    @BeforeEach
    public void setup() throws NoSuchMethodException
    {
        Method[] methodsInterface = WardModelManager.class.getMethods();
        methods = new ArrayList<>();
        for (Method method : methodsInterface)
        {
            methods.add(WardServerManagerRMI.class.getMethod(method.getName(), method.getParameterCount() != 0 ? method
                    .getParameterTypes() : null));

        }
    }

    @Test
    public void testClassMethodsHaveSynchronizedModifier()
    {
        for (Method method : methods)
        {
            assertTrue(Modifier.isSynchronized(method.getModifiers()));
        }
    }
}