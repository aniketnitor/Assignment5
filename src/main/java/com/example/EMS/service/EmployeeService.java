package com.example.EMS.service;

import com.example.EMS.entity.Employee;
import com.example.EMS.enums.Enums.Designation;
import com.example.EMS.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Optional<Employee> findEmployeeById(UUID id) {
        return employeeRepository.findById(id);
    }

    public List<Employee> findEmployeesByDesignation(Designation designation) {
        return employeeRepository.findByDesignation(designation);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public List<Employee> findEmployeesByDepartment(String department) {
        return employeeRepository.findByDepartment(department);
    }

    public List<Employee> findEmployeesJoinedBefore(LocalDate date) {
        return employeeRepository.findByJoiningDateBefore(date);
    }

    public List<Employee> findEmployeesJoinedAfter(LocalDate date) {
        return employeeRepository.findByJoiningDateAfter(date);
    }

    public List<Employee> findEmployeesBySalaryRange(Double minSalary, Double maxSalary) {
        return employeeRepository.findBySalaryBetween(minSalary, maxSalary);
    }

    public List<Employee> findEmployeesByAgeRange(Integer minAge, Integer maxAge) {
        return employeeRepository.findEmployeesByAgeRange(minAge, maxAge);
    }

    public void deleteEmployee(UUID id) {
        employeeRepository.deleteById(id);
    }
}