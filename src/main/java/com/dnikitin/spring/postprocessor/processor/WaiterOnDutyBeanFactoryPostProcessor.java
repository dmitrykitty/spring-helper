package com.dnikitin.spring.postprocessor.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class WaiterOnDutyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("waiter");
        MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();
        propertyValues.add("onDuty", true);
        System.out.println("BeanFactoryPostProcessor: Value onDuty added as true");

    }
}
