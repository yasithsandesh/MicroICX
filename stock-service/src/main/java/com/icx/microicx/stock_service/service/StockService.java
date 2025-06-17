package com.icx.microicx.stock_service.service;


import com.icx.microicx.stock_service.dto.request.StockSaveDTO;
import com.icx.microicx.stock_service.dto.response.ResponseDTO;
import com.icx.microicx.stock_service.entitiy.Stock;

import java.util.List;

public interface StockService {
    ResponseDTO<Stock> addStock(StockSaveDTO stockSaveDTO);
    List<Stock> getStockList();
    Stock getStockById(String id);
}
