package com.example.EmployeeManagement.Repositories;

import com.example.EmployeeManagement.MOdel.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<Report,Long> {
}
