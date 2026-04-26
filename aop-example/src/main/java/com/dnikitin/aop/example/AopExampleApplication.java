package com.dnikitin.aop.example;

import com.dnikitin.aop.example.bean.example.IExampleBean;
import com.dnikitin.aop.example.model.Plant;
import com.dnikitin.aop.example.service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.List;

@SpringBootApplication
public class AopExampleApplication {

//    @Autowired
//    private IExampleBean bean;

    @Autowired
    private PlantService plantService;

    public static void main(String[] args) {
        SpringApplication.run(AopExampleApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady(ApplicationReadyEvent event) {
        System.out.println(plantService.getPlantsCount());

        plantService.addPlant(
                new Plant("rose", "flower")
        );

        System.out.println(plantService.getPlantsCount());
        System.out.println(plantService.getPlantsByType("flower"));
        System.out.println(plantService.getPlantByName("rose"));


        plantService.addPlants(List.of(
                new Plant("flower1", "flower"),
                new Plant("flower2", "flower"),
                new Plant("flower3", "flower")
        ));

        System.out.println(plantService.getPlantsCount());
        System.out.println(plantService.getPlantsByType("flower"));
        System.out.println(plantService.getPlantByName("rose"));

        plantService.addPlants(List.of(
                new Plant("flower4", "flower")
        ));
    }

}
