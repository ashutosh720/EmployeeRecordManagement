package com.example.EmployeeManagement.Controller;
import com.example.EmployeeManagement.MOdel.Employee;
import com.example.EmployeeManagement.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping()
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateEmployee( @PathVariable Long hrid, @PathVariable Long id, @RequestBody Employee employee){
        return employeeService.updateEmployeeById(hrid,id,employee);
    }
}
