package com.example.EmployeeManagement.Repositories;

import com.example.EmployeeManagement.MOdel.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    @Query(value="Select * from users where user_id = :user_id", nativeQuery = true)
    public Employee getHr(Long hrid);

}
