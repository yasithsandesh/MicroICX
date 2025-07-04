package com.icx.microicx.finance_service.dto.response;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CostDTO {
    private Long id;
    private String title;
    private String description;
    private BigDecimal amount;
    private LocalDate date;
    private String category;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
