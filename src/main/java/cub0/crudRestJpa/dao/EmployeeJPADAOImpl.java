package cub0.crudRestJpa.dao;

import cub0.crudRestJpa.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class EmployeeJPADAOImpl implements EmployeeDAO{

    private EntityManager entityManager;


    @Autowired
    public  EmployeeJPADAOImpl(EntityManager theEntityManger){
        entityManager = theEntityManger;
    }

    @Override
    public List<Employee> findAll() {

        TypedQuery<Employee> theQuery =entityManager.createQuery("from Employee", Employee.class);

        List<Employee> employeeList= theQuery.getResultList();

        return employeeList;
    }

    @Override
    public Employee findById(int theId) {
        Employee emp = entityManager.find(Employee.class, theId);
        return emp;
    }

    @Override
    public Employee save(Employee theEmployee) {
        Employee emp =entityManager.merge(theEmployee);
        return emp;
    }

    @Override
    public void deleteById(int theID) {
     Employee emp = entityManager.find(Employee.class, theID);
     entityManager.remove(emp );


    }
}
