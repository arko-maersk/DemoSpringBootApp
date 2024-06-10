package org.example.starter;

public class Employee {
    public Employee(int i, String johnDoe, int i1) {
        this.name = johnDoe;
        this.age = i1;
        this.id = i;
    }

    public Employee() {
        this.name="Arko";
        this.age=10;
        this.id=100;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private String name;
    private int age;
    private int id;
}
