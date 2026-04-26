package com.dnikitin.aop.example.service;

import com.dnikitin.aop.example.annotation.Asynchronously;
import com.dnikitin.aop.example.annotation.PreInvoke;
import com.dnikitin.aop.example.annotation.SuccessLogging;
import com.dnikitin.aop.example.exception.ApplicationException;
import com.dnikitin.aop.example.model.Plant;
import com.dnikitin.aop.example.model.RoleType;
import com.dnikitin.aop.example.utils.ThreadUtils;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@SuccessLogging
public class PlantServiceImpl implements PlantService {

    private final Map<String, Plant> plants =  new HashMap<>();

    @Override
    @Asynchronously
    @PreInvoke(roles = RoleType.ADMIN)
    public void addPlant(Plant plant) throws ApplicationException {
        plants.put(plant.getName(), plant);

    }

    @Override
    @Asynchronously
    @PreInvoke(roles = RoleType.ADMIN)
    public void addPlants(List<Plant> newPlants) throws ApplicationException {
        if(newPlants.size() <= 1) {
            throw new ApplicationException("Plants must have at least two plants");
        }
        plants.putAll(newPlants.stream()
                .collect(Collectors.toMap(Plant::getName, plant -> plant)));

    }

    @Override
    @PreInvoke(roles = {RoleType.ADMIN,  RoleType.USER})
    public List<Plant> getPlantsByType(String type) throws ApplicationException {
        return plants.values().stream().
                filter(plant -> plant.getType().equals(type)).
                toList();
    }

    @Override
    @PreInvoke(roles = {RoleType.ADMIN,  RoleType.USER})
    public Plant getPlantByName(String name) throws ApplicationException {
        if(!plants.containsKey(name)) {
            throw new ApplicationException("Plants with name " + name + " doesn't exist");
        }

        return plants.get(name);
    }

    @Override
    public int getPlantsCount() {
        ThreadUtils.sleep(500);
        return plants.size();
    }
}
