package com.dnikitin.spring.scope.bean;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;

@Component
public class ObjectProviderExample {

    ObjectProvider<Chef> chefProvider;
    ObjectProvider<HeadChef> headChefProvider;

    public ObjectProviderExample(ObjectProvider<HeadChef> headChefProvider,  ObjectProvider<Chef> chefProvider) {
        this.headChefProvider = headChefProvider;
        this.chefProvider = chefProvider;
    }

    public void compareChefs(){
        Chef chef1 = chefProvider.getObject();
        Chef chef2 = chefProvider.getObject();

        System.out.println(chef1 ==  chef2);
    }

    public void compareHeadChefs(){
        HeadChef headChef1 = headChefProvider.getObject();
        HeadChef headChef2 = headChefProvider.getObject();

        System.out.println(headChef1 == headChef2);
    }
}

