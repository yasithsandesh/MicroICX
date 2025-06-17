package com.icx.microicx.stock_service.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockSaveDTO {
    private long userId;
    private long warehouseId;
    private List<StockItemSaveDTO> stockItems;
}
