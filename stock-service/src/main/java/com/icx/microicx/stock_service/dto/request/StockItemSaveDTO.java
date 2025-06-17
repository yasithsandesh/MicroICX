package com.icx.microicx.stock_service.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockItemSaveDTO {
    private long materialId;
    private double qty;
    private Date exp;
    private double price;
}
