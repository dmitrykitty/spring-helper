package com.dnikitin.aop.example.service;

import com.dnikitin.aop.example.exception.ApplicationException;
import com.dnikitin.aop.example.model.Plant;
import com.dnikitin.aop.example.model.RoleType;

import java.util.List;

public interface PlantService {

    void addPlant(Plant plant) throws ApplicationException;

    void addPlants(List<Plant> plants) throws ApplicationException;

    List<Plant> getPlantsByType(String role) throws ApplicationException;

    Plant getPlantByName(String name) throws ApplicationException;

    int getPlantsCount();
}
