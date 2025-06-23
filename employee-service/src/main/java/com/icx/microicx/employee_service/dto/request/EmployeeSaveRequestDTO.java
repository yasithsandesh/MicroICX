package com.icx.microicx.employee_service.dto.request;

import com.icx.microicx.employee_service.entity.enums.DepartmentType;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public class EmployeeSaveRequestDTO {

    @NotBlank(message = "First name is required")
    private String firstName;

    private String lastName;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Contact number is required")
    @Pattern(
            regexp = "^07[0-9]{8}$",
            message = "Contact number must be a valid Sri Lankan mobile number (e.g., 0712345678)"
    )
    private String contactNumber;

    @NotNull(message = "Department is required")
    private DepartmentType department;

    private String position;

    @NotNull(message = "Salary is required")
    @DecimalMin(value = "0.01", message = "Salary must be greater than 0")
    private BigDecimal salary;

    @NotNull(message = "Hired date is required")
    private LocalDate hiredDate;
}
