package com.icx.microicx.finance_service.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CostSaveRequestDTO {
    private String title;
    private String description;
    private BigDecimal amount;
    private LocalDate date;
    private String category;
}
