package com.dnikitin.springbootproperties.config.props;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "app.restaurant")
public class RestaurantProperties {
    private String name;

    private List<String> menu;

    private Map<String, EmployeeInfo> employees;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getMenu() {
        return menu;
    }

    public void setMenu(List<String> menu) {
        this.menu = menu;
    }

    public Map<String, EmployeeInfo> getEmployees() {
        return employees;
    }

    public void setEmployees(Map<String, EmployeeInfo> employees) {
        this.employees = employees;
    }
}
