package cub0.crudRestJpa.dao;

import cub0.crudRestJpa.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save (Employee theEmployee);

    void deleteById(int theID);
}
