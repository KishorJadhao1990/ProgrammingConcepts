package com.eao.algorithm;

import java.util.*;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
//        List<Integer> nums = Arrays.asList(5, 5, 5, 5, 4);
//        System.out.println(nums.stream().allMatch(e-> nums.equals(nums.get(0))));
//
//        String str = "AnuragSharma";
//        Map<Boolean, Long> map = str.chars().mapToObj(c -> (char) c)
//                .collect(Collectors.partitioningBy(m -> "AEIOUaeiou".contains(m.toString()), Collectors.counting()));
//
//        System.out.println(map);

//        List<Integer> nums = Arrays.asList(1, 2, 3, 5, 4);
//        System.out.println(Arrays.toString(nums.stream().map(e -> Math.pow(e, 3)).toArray()));

        List<Employee> employees = List.of(
                new Employee(101, "Rahul", "IT", 85000L, 28),
                new Employee(102, "Amit", "HR", 60000L, 32),
                new Employee(103, "Neha", "IT", 95000L, 30),
                new Employee(104, "Priya", "Finance", 75000L, 27),
                new Employee(105, "Vikas", "HR", 65000L, 35),
                new Employee(106, "Anjali", "Finance", 80000L, 29),
                new Employee(107, "Karan", "IT", 90000L, 31),
                new Employee(108, "Sneha", "Admin", 55000L, 26),
                new Employee(109, "Rohit", "Admin", 58000L, 33),
                new Employee(110, "Pooja", "IT", 92000L, 24),
                new Employee(111, "Pooja", "IT", 82000L, 24)
        );

//        List employee names department-wise.

//        System.out.println(employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.toList()))));

        //
//        employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
//                Collectors.collectingAndThen(
//                        Collectors.toList(),
//                        list-> list.stream().sorted(Comparator.comparing(Employee::getName))
//                )));

        employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.collectingAndThen(
                        Collectors.toList(),
                        list-> list.stream().filter(e-> e.getName().startsWith("R")).toList()
                ))).entrySet().stream().forEach(System.out::println);


//        Find average salary per department.
//        employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingLong(Employee::getSalary)))
//                .entrySet().forEach(System.out::println);
//
//        Find sum of salaries per department.
//        employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingLong(Employee::getSalary)))
//                .entrySet().forEach(System.out::println);

//        Find highest-paid employee in each department.
//        employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparing(Employee::getSalary))))
//                .entrySet().forEach(System.out::println);

//        System.out.println(employees.stream().map(Employee::getSalary).reduce(Long::max));

//        Get salary statistics (IntSummaryStatistics).
//        LongSummaryStatistics stats = employees.stream().collect(Collectors.summarizingLong(Employee::getSalary));
//        System.out.println(stats);
//        Calculate total salary.
//        System.out.println(employees.stream().mapToInt(Employee::getAge).average());;

//        Check if no employee belongs to Sales.
//        System.out.println(employees.stream().noneMatch(e-> "sales".equalsIgnoreCase(e.getDepartment())));

//        Check if all employees are above 18.
//        System.out.println(employees.stream().allMatch(e-> e.getAge()> 18));

//       find first emp in IT
//        employees.stream().filter(e-> "IT".equals(e.getDepartment())).findFirst().ifPresent(System.out::println);

//        Check if any employee earns above ₹100000.
//        System.out.println(employees.stream().anyMatch(e-> e.getSalary() > 100000));

//        find max sal
//        employees.stream().max(Comparator.comparing(Employee::getSalary)).ifPresent(System.out::println);

//        employees.stream().min(Comparator.comparing(e-> e.getName().length())).ifPresent(System.out::println);

//        Set<String> set = new HashSet<>();
//        employees.stream().filter(e-> set.add(e.getName())).forEach(System.out::println);
//        System.out.println("-".repeat(80));
//
//
//        employees.stream().collect(Collectors.toMap(Employee::getName, Function.identity(), (o,n)-> o))
//                        .entrySet().stream().map(Map.Entry::getValue).forEach(System.out::println);
//        System.out.println("-".repeat(80));

//        employees.stream().sorted(Comparator.comparing(Employee::getAge).thenComparing(Employee::getSalary, Comparator.reverseOrder())).forEach(System.out::println);
//
//        System.out.println("-".repeat(80));

        // Employee name to upper case
//        employees.stream().map(e-> {
//            e.setName(e.getName().toUpperCase());
//            return e;
//        }).forEach(System.out::println);

    }
}


class Employee {

    private int id;
    private String name;
    private String department;
    private Long salary;
    private int age;

    public Employee() {
    }

    public Employee(int id, String name, String department, Long salary, int age) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }
}
