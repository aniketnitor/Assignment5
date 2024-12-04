package com.example.EMS.controller;

import com.example.EMS.entity.Employee;
import com.example.EMS.enums.Enums.Designation;
import com.example.EMS.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.saveEmployee(employee));
    }

    @GetMapping()
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable UUID id) {
        return employeeService.findEmployeeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/designation")
    public ResponseEntity<List<Employee>> getEmployeesByDesignation(
            @RequestParam Designation designation) {
        return ResponseEntity.ok(employeeService.findEmployeesByDesignation(designation));
    }

    @GetMapping("/department")
    public ResponseEntity<List<Employee>> getEmployeesByDepartment(
            @RequestParam String department) {
        return ResponseEntity.ok(employeeService.findEmployeesByDepartment(department));
    }

    @GetMapping("/joined-before")
    public ResponseEntity<List<Employee>> getEmployeesJoinedBefore(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return ResponseEntity.ok(employeeService.findEmployeesJoinedBefore(date));
    }

    @GetMapping("/joined-after")
    public ResponseEntity<List<Employee>> getEmployeesJoinedAfter(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return ResponseEntity.ok(employeeService.findEmployeesJoinedAfter(date));
    }

    @GetMapping("/salary-range")
    public ResponseEntity<List<Employee>> getEmployeesBySalaryRange(
            @RequestParam Double minSalary,
            @RequestParam Double maxSalary) {
        return ResponseEntity.ok(employeeService.findEmployeesBySalaryRange(minSalary, maxSalary));
    }

    @GetMapping("/age-range")
    public ResponseEntity<List<Employee>> getEmployeesByAgeRange(
            @RequestParam Integer minAge,
            @RequestParam Integer maxAge) {
        return ResponseEntity.ok(employeeService.findEmployeesByAgeRange(minAge, maxAge));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable UUID id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}