package com.model;

/**
 * Created by Nobody on 2017/7/1.
 */
public class Employee implements Comparable<Employee> {

    private int id;
    private String name;

    public Employee() {
    }

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public int compareTo(Employee o) {
        System.out.println("compareTo()....");
        return this.getId() - o.getId();

    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("equals()...");
        Employee other = (Employee) obj;
        return this.getId() == other.getId();
    }
}
