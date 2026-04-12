package com.dnikitin.spring.lifecycle.bean;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.FactoryBean;

public class IngredientFactoryBean implements FactoryBean<Ingredient> {

    private final String ingredient;

    public IngredientFactoryBean(String ingredient) {
        this.ingredient = ingredient;
    }

    @Override
    public @Nullable Ingredient getObject() throws Exception {
        return new Ingredient(ingredient);
    }

    @Override
    public @Nullable Class<?> getObjectType() {
        return Ingredient.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
