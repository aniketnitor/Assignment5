package com.example.EMS.entity;

import com.example.EMS.enums.Enums.Designation;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull(message = "Salary is required")
    @Positive(message = "Salary must be positive")
    private Double salary;

    @NotBlank(message = "EmployeeId is required")
    @Column(unique = true)
    private String employeeId;

    @NotNull(message = "Designation is required")
    @Enumerated(EnumType.STRING)
    private Designation designation;

    @NotBlank(message = "Department name is required")
    private String department;

    @NotNull(message = "Joining date is required")
    @PastOrPresent(message = "Joining date should be present or past date")
    private LocalDate joiningDate;
}