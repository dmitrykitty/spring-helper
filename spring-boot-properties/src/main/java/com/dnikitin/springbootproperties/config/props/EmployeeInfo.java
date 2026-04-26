package com.dnikitin.springbootproperties.config.props;


public class EmployeeInfo {
    private PositionType position;

    private Integer salary;

    public PositionType getPosition() {
        return position;
    }

    public void setPosition(PositionType position) {
        this.position = position;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public EmployeeInfo(PositionType position, Integer salary) {
        this.position = position;
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "EmployeeInfo{" +
                "position=" + position +
                ", salary=" + salary +
                '}';
    }
}
