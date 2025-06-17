package com.icx.microicx.stock_service.controller;

import com.icx.microicx.stock_service.dto.request.StockSaveDTO;
import com.icx.microicx.stock_service.dto.response.ResponseDTO;
import com.icx.microicx.stock_service.entitiy.Stock;
import com.icx.microicx.stock_service.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/stock")
public class StockController {

    @Autowired
    private StockService stockService;

    @PostMapping()
    public ResponseEntity<ResponseDTO<Stock>> addStock(@RequestBody StockSaveDTO stockSaveDTO) {
        return new ResponseEntity<>(this.stockService.addStock(stockSaveDTO), HttpStatus.OK);
    }

    @GetMapping()
    public  ResponseEntity<List<Stock>> getAllStock() {
        return new ResponseEntity<>(this.stockService.getStockList(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stock> getStockById(@PathVariable("id") String id) {
        return new ResponseEntity<>(this.stockService.getStockById(id),HttpStatus.OK);
    }
}
