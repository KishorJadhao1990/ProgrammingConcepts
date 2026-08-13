package com.eao.usecases.all;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Alice", "Math", 85),
                new Student("Alice", "Science", 90),
                new Student("Bob", "Math", 75),
                new Student("Bob", "Science", 80),
                new Student("Charlie", "Math", 95),
                new Student("Charlie", "Science", 85)
        );
        Map<String, Integer> maxMarksBySubject = students.stream()
                .collect(Collectors.groupingBy(Student::getSubject, Collectors.mapping(Student::getMarks, Collectors.maxBy(Comparator.naturalOrder()))))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().orElse(0)));
        System.out.println(maxMarksBySubject);
    }
}
class Student {

    private String name;
    private String subject;
    private int marks;

    public Student(String name, String subject, int marks) {
        this.name = name;
        this.subject = subject;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public int getMarks() {
        return marks;
    }

}