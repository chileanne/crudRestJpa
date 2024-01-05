package cub0.crudRestJpa.service;

import cub0.crudRestJpa.dao.EmployeeDAO;
import cub0.crudRestJpa.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{


    private EmployeeDAO employeeDAO;


    @Autowired
    public EmployeeServiceImpl(EmployeeDAO empDao){
        employeeDAO =empDao;
    }


    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }


    @Override
    public Employee findById(int theId) {
        return employeeDAO.findById(theId);
    }


    @Transactional
    @Override
    public Employee save(Employee theEmployee) {
        return employeeDAO.save(theEmployee);
    }


    @Transactional
    @Override
    public void deleteById(int theID) {

        employeeDAO.deleteById(theID);

    }
}
