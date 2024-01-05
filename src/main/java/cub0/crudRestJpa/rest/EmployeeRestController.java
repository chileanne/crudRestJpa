package cub0.crudRestJpa.rest;

import cub0.crudRestJpa.entity.Employee;
import cub0.crudRestJpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;


    @Autowired
    public  EmployeeRestController(EmployeeService empService){
        employeeService=empService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return  employeeService.findAll();
    }


    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable  int id){
         Employee emp = employeeService.findById(id);

         if(emp ==null){
             throw new RuntimeException("Employee id not found -" + id);
         }
         return  emp;
    }


    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theemp){

        //just in case an id is passed in json...set the id to 0
        // this is to force a save of new item(bcos in the employee dao we are using merge method to save)...instead of update
        theemp.setId(0);

        Employee dbEmployee = employeeService.save(theemp);

        return dbEmployee;


    }

    @PutMapping("/employees")
    public  Employee updateEmployee(@RequestBody Employee theEmp){
        Employee dbEmployee =employeeService.save(theEmp);

        return  dbEmployee;
    }



    @DeleteMapping("/employees/{id}")
    public  String deleteEmployee (@PathVariable int id){
        Employee dbEmployee =employeeService.findById(id);

        if(dbEmployee==null){
            throw  new RuntimeException("Employee id not found"+ id);
        }

        employeeService.deleteById(id);

        return "Employee deleted"+ id;
    }

}
