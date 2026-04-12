package com.dnikitin.spring.scope;

import com.dnikitin.spring.scope.bean.Chef;
import com.dnikitin.spring.scope.bean.HeadChef;
import com.dnikitin.spring.scope.bean.ObjectProviderExample;
import com.dnikitin.spring.scope.config.RestaurantConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RestaurantApplication {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(RestaurantConfig.class);
        HeadChef headChef = context.getBean(HeadChef.class);
        headChef.setName("Head Chef");

        HeadChef headChef2 = context.getBean(HeadChef.class);
        headChef2.setName("Head Chef2");

        System.out.println(headChef.getName() + " " + headChef2.getName());

        System.out.println(context.getBean(HeadChef.class) == context.getBean(HeadChef.class));
        System.out.println(context.getBean(Chef.class) == context.getBean(Chef.class));

        Chef chef = context.getBean(Chef.class);
        chef.setName("Chef");

        Chef chef2 = context.getBean(Chef.class);
        chef2.setName("Chef2");

        System.out.println(chef.getName() + " " + chef2.getName());

        ObjectProviderExample provider = context.getBean(ObjectProviderExample.class);
        provider.compareChefs();
        provider.compareHeadChefs();
    }
}
