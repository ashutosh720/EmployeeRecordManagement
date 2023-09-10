package com.example.EmployeeManagement.Controller;

import com.example.EmployeeManagement.MOdel.Employee;
import com.example.EmployeeManagement.MOdel.Report;
import com.example.EmployeeManagement.Repositories.ReportRepository;
import com.example.EmployeeManagement.Service.EmployeeService;
import com.example.EmployeeManagement.Service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
   private ReportService recordService;

    @Autowired
    private ReportRepository recordRepository;

    @PostMapping("/add")
    public ResponseEntity<String> addReport(@RequestBody Report record) {
        return recordService.addReport(record);
    }
}


//    @PostMapping("/add")
//    public ResponseEntity<String> addReport(@RequestBody Report record) {
//        try {
//            // Validate input
//            if (record == null || record.getEmployee() == null || record.getDate() == null) {
//                return ResponseEntity.badRequest().body("Invalid input data");
//            }
//
//            // Fetch employee by ID
//            Long employeeId = record.getEmployee().getId();
//            Employee employee = employeeService.getEmployeeById(employeeId);
//
//            if (employee == null) {
//                return ResponseEntity.badRequest().body("Employee with ID " + employeeId + " not found");
//            }
//
//            // Set the employee and save the record
//            record.setEmployee(employee);
//            recordRepository.save(record)
//
//            return ResponseEntity.ok("Report added for employee with ID: " + employeeId + " on date: " + record.getDate());
//        } catch (Exception e) {
//            // Handle exceptions here and return an appropriate error response
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
//        }
//    }
//}