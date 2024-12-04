package com.example.EMS.repository;

import com.example.EMS.entity.Employee;
import com.example.EMS.enums.Enums.Designation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
    List<Employee> findByDesignation(Designation designation);

    List<Employee> findByDepartment(String department);

    List<Employee> findByJoiningDateBefore(LocalDate date);

    List<Employee> findByJoiningDateAfter(LocalDate date);

    List<Employee> findBySalaryBetween(Double minSalary, Double maxSalary);

    @Query("SELECT e FROM Employee e WHERE e.age BETWEEN :minAge AND :maxAge")
    List<Employee> findEmployeesByAgeRange(Integer minAge, Integer maxAge);
}