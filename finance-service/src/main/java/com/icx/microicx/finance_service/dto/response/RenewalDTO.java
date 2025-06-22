package com.icx.microicx.finance_service.dto.response;

import com.icx.microicx.finance_service.entity.enums.DepartmentType;
import com.icx.microicx.finance_service.entity.enums.Frequency;
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
public class RenewalDTO {
    private Long id;
    private String renewalName;
    private DepartmentType department;
    private BigDecimal amount;
    private LocalDate renewalDate;
    private Frequency frequency;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
