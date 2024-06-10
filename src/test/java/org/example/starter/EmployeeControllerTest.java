package org.example.starter;

import org.example.starter.Employee;
import org.example.starter.EmployeeController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class EmployeeControllerTest {

    private MockMvc mockMvc;
    private EmployeeController employeeController;

    @BeforeEach
    void setUp() {
        employeeController = new EmployeeController();
        mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
    }

    @Test
    void testSayHelloWorld() throws Exception {
        mockMvc.perform(get("/search/{name}", "John"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hey there: John Welcome to the App")));
    }

    @Test
    void testSayHelloWorldWithEmptyName() throws Exception {
        mockMvc.perform(get("/search/{name}", " "))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hey there:   Welcome to the App")));
    }

    @Test
    void testCreateEmployee() throws Exception {
        Employee employee = new Employee(1, "John Doe", 30);
        mockMvc.perform(post("/createEmployee")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"name\":\"John Doe\",\"age\":30}"))
                .andExpect(status().isOk());
    }

    @Test
    void testCreateEmployeeWithExistingId() throws Exception {
        Employee employee = new Employee(1, "John Doe", 30);
        employeeController.createEmp(employee);
        mockMvc.perform(post("/createEmployee")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"name\":\"Jane Doe\",\"age\":35}"))
                .andExpect(status().isOk());
    }

    @Test
    void testGetEmployee() throws Exception {
        Employee employee = new Employee(1, "John Doe", 30);
        employeeController.createEmp(employee);
        mockMvc.perform(get("/getEmployee"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"1\":{\"id\":1,\"name\":\"John Doe\",\"age\":30}}"));
    }

    @Test
    void testUpdateEmployee() throws Exception {
        Employee employee = new Employee(1, "John Doe", 30);
        employeeController.createEmp(employee);
        Employee updatedEmployee = new Employee(1, "Jane Doe", 35);
        mockMvc.perform(put("/employee/id/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"name\":\"Jane Doe\",\"age\":35}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Jane Doe")))
                .andExpect(jsonPath("$.age", is(35)));
    }

    @Test
    void testUpdateEmployeeWithNonExistingId() throws Exception {
        Employee updatedEmployee = new Employee(2, "Jane Doe", 35);
        mockMvc.perform(put("/employee/id/{id}", 2)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":2,\"name\":\"Jane Doe\",\"age\":35}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Jane Doe")))
                .andExpect(jsonPath("$.age", is(35)));
    }

    @Test
    void testGetEmployeeWithEmptyMap() throws Exception {
        mockMvc.perform(get("/getEmployee"))
                .andExpect(status().isOk())
                .andExpect(content().json("{}"));
    }
}