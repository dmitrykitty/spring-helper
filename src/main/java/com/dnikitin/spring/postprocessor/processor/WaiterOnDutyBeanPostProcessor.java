package com.dnikitin.spring.postprocessor.processor;

import com.dnikitin.spring.postprocessor.bean.Waiter;
import com.dnikitin.spring.postprocessor.config.ApplicationConfig;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class WaiterOnDutyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public @Nullable Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof Waiter) {
            ((Waiter) bean).setOnDuty(false);
            System.out.printf("BeanPostProcessor: changed onDuty for %s on false\n", beanName);
        }
        return bean;
    }
}
