package cub0.crudRestJpa.service;

import cub0.crudRestJpa.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save (Employee theEmployee);

    void deleteById(int theID);
}
