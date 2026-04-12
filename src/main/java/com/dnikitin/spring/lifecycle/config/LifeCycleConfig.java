package com.dnikitin.spring.lifecycle.config;

import com.dnikitin.spring.lifecycle.bean.Coffee;
import com.dnikitin.spring.lifecycle.bean.IngredientFactoryBean;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("com.dnikitin.spring.lifecycle")
public class LifeCycleConfig {

//    @Bean(initMethod = "createCoffee", destroyMethod = "destroyCoffee")
//    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//    public Coffee coffee(String type) {
//        return new Coffee(type);
//    }

    @Bean
    public IngredientFactoryBean sugar(){
        return new IngredientFactoryBean("sugar");
    }

    @Bean
    public IngredientFactoryBean milk(){
        return new IngredientFactoryBean("milk");
    }
}
