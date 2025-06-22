package com.icx.microicx.finance_service.dto.request;

import com.icx.microicx.finance_service.entity.enums.DepartmentType;
import com.icx.microicx.finance_service.entity.enums.Frequency;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SaveRenewalDTO {
    @NotBlank(message = "Renewal name is required")
    private String renewalName;

    @NotNull(message = "Department is required and it can only be HR, FINANCE, IT, PRODUCTION, OTHER")
    private DepartmentType department;

    @NotNull(message = "Amount is required")
    @DecimalMin(value = "0.01", message = "Amount must be greater than 0")
    private BigDecimal amount;

    @NotNull(message = "Renewal date is required")
    private LocalDate renewalDate;

    private Frequency frequency;
}
