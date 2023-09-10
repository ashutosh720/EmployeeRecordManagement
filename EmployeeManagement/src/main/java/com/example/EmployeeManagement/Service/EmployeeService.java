package com.example.EmployeeManagement.Service;

import com.example.EmployeeManagement.MOdel.Employee;
import com.example.EmployeeManagement.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {


    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }


    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).isPresent() ? employeeRepository.findById(id).get(): null;
    }


    public ResponseEntity<String> updateEmployeeById(Long hrid , Long id, Employee employee) {

        Employee auth = employeeRepository.getHr(hrid);
        if (auth.getHrd().equals("HR")) {

            Employee newemployee = this.getEmployeeById(id);
            if (newemployee == null)

                return ResponseEntity.noContent().build();

            if (employee.getFirstName() != null) {

                newemployee.setFirstName(employee.getFirstName());
            }
            if (employee.getLastName() != null) {

                newemployee.setLastName(employee.getLastName());
            }
            if (employee.getEmail() != null) {

                newemployee.setEmail(employee.getEmail());
            }
            if (employee.getPhoneNumber() != null) {

                newemployee.setPhoneNumber(employee.getPhoneNumber());
            }
            if (employee.getHrd() != null) {

                newemployee.setHrd(employee.getHrd());
            }

            employeeRepository.save(newemployee);
            return ResponseEntity.accepted().body("Updated successfully");

        } else {
            throw new RuntimeException("Unauthorised user");
        }

    }




}

