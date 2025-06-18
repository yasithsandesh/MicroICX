package com.icx.microicx.stock_service.controller;

import com.icx.microicx.stock_service.entitiy.Warehouse;
import com.icx.microicx.stock_service.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/warehouse")
public class WarehouseController {
    @Autowired
    private WarehouseService warehouseService;

    @PostMapping
    public ResponseEntity<Boolean> addWarehouse(@RequestBody WarehouseSave warehouseSave) {
        return new ResponseEntity<>(this.warehouseService.addWarehouse(warehouseSave.getName()), HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<Warehouse>> getAllWarehouse() {
        return new ResponseEntity<>(this.warehouseService.findAllWarehouse(), HttpStatus.OK);
    }


    //inner class
    public static class WarehouseSave{
        private String name;
        public WarehouseSave() {}
        public WarehouseSave(String name) {
            this.name = name;
        }

        public String getName() {return name;}
        public void setName(String name) {this.name = name;}
    }
}
