package com.dnikitin.spring.postprocessor.processor;

import com.dnikitin.spring.annotation.Discount;
import com.dnikitin.spring.postprocessor.bean.Food;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
public class DiscountableBeanPostProcessor implements BeanPostProcessor {
    @Override
    public @Nullable Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Food food) {
            Class<Food> foodClass = (Class<Food>) food.getClass();
            try {
                Field discountField = foodClass.getDeclaredField("discount");
                if(discountField.isAnnotationPresent(Discount.class) && food.getType().equals("Drink")){
                    Discount discount = discountField.getAnnotation(Discount.class);
                    food.setDiscount(discount.percent());

                    System.out.printf("BeanPostProcessor: discount for Drink set to %d\n",  discount.percent());
                }
            } catch (NoSuchFieldException e) {
                throw new RuntimeException(e);
            }

        }
        return bean;
    }
}
