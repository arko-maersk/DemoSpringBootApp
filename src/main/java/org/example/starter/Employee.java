package org.example.starter;

public class Employee {
    public Employee() {
        this.name = "Arko";
        this.age = 22;
        this.id = 1;
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
    private Integer age;
    private Integer id;
}
