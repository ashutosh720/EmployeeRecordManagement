package com.example.EmployeeManagement.Service;
import com.example.EmployeeManagement.MOdel.Report;
import com.example.EmployeeManagement.Repositories.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ReportService {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ReportRepository recordRepository;


    public ResponseEntity<String> addReport(Report record) {

        Long employeeId = record.getEmployee().getId();
        record.setEmployee(employeeService.getEmployeeById(employeeId));
        recordRepository.save(record);
        return ResponseEntity.ok("Report added for employee with ID: " + employeeId + " on date: " + record.getDate());
    }
}