package org.example.starter;

import org.example.starter.Employee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void testDefaultConstructor() {
        Employee employee = new Employee();
        assertEquals("Arko", employee.getName());
        assertEquals(10, employee.getAge());
        assertEquals(100, employee.getId());
    }

    @Test
    void testParameterizedConstructor() {
        Employee employee = new Employee(2, "John Doe", 30);
        assertEquals("John Doe", employee.getName());
        assertEquals(30, employee.getAge());
        assertEquals(2, employee.getId());
    }

    @Test
    void testSetName() {
        Employee employee = new Employee();
        employee.setName("John Doe");
        assertEquals("John Doe", employee.getName());
    }

    @Test
    void testSetNameWithNull() {
        Employee employee = new Employee();
        employee.setName(null);
        assertNull(employee.getName());
    }

    @Test
    void testSetAge() {
        Employee employee = new Employee();
        employee.setAge(30);
        assertEquals(30, employee.getAge());
    }

    @Test
    void testSetAgeWithNegativeValue() {
        Employee employee = new Employee();
        employee.setAge(-5);
        assertEquals(-5, employee.getAge());
    }

    @Test
    void testSetId() {
        Employee employee = new Employee();
        employee.setId(2);
        assertEquals(2, employee.getId());
    }

    @Test
    void testSetIdWithNegativeValue() {
        Employee employee = new Employee();
        employee.setId(-1);
        assertEquals(-1, employee.getId());
    }
}