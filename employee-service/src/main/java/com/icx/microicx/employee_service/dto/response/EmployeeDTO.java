package com.icx.microicx.employee_service.dto.response;

import com.icx.microicx.employee_service.entity.enums.DepartmentType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String contactNumber;
    private DepartmentType department;
    private String position;
    private BigDecimal salary;
    private boolean status = true;
    private LocalDate hiredDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
