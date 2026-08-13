package com.eao.usecases.all;

import java.util.List;
import java.util.stream.Collectors;

public class AvgEmpSalary {
    public static void main(String[] args) {

        List<Employee> employees = List.of(
                new Employee(12, 100000l, "Pune"),
                new Employee(13, 200000l, "Mumbai"),
                new Employee(14, 300000l, "Noida"),
                new Employee(15, 400000l, "Pune"),
                new Employee(11, 500000l, "Mumbai"),
                new Employee(16, 600000l, "Pune")
        );

        var empAvg = employees.stream()
                .collect(Collectors.groupingBy(Employee::getCity,
                        Collectors.mapping(Employee::getSalary, Collectors.averagingLong(Long::intValue))));
        System.out.println(empAvg);

        var empAvgGreater = empAvg.entrySet().stream().filter(e-> e.getValue() > 300000).collect(Collectors.toList());

        System.out.println(empAvgGreater);
    }
}

class Employee {

    int id;
    long salary;
    String city;

    public Employee(int id, Long salary, String city) {
        this.id = id;
        this.salary = salary;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}