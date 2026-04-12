package com.dnikitin.spring.proxy.process;

import com.dnikitin.spring.proxy.bean.IWaiter;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.Semaphore;

@Component
public class ConcurrentCallsLimiterBeanPostProcessor implements BeanPostProcessor {

    @Override
    public @Nullable Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();

        if (bean instanceof IWaiter) {
            return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(), new InvocationHandler() {
                private final Semaphore semaphore = new Semaphore(2);

                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    try{
                        System.out.println("Acquire... " + semaphore.availablePermits());
                        semaphore.acquire();
                        return method.invoke(bean, args);
                    } finally {
                        semaphore.release();
                        System.out.println("Release semaphore...");
                    }
                }
            });
        }
        return bean;
    }
}
