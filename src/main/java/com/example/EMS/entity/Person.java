package com.example.EMS.entity;

import com.example.EMS.enums.Enums;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class Person {
    @NotBlank(message = "Name is required")
    private String name;

    @Pattern(regexp = "^[0-9]+$",
            message = "Aadhar number must be in proper format")
    private String aadharNumber;

    @NotNull(message = "Gender is required")
    @Enumerated(EnumType.STRING)
    private Enums.Gender gender;

    @NotNull(message = "Age is required")
    @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 65, message = "Age must be at most 65")
    private Integer age;
}
