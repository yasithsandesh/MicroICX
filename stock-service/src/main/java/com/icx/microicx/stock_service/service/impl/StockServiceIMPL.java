package com.icx.microicx.stock_service.service.impl;

import com.icx.microicx.stock_service.dto.request.StockItemSaveDTO;
import com.icx.microicx.stock_service.dto.request.StockSaveDTO;
import com.icx.microicx.stock_service.dto.response.ResponseDTO;
import com.icx.microicx.stock_service.entitiy.Stock;
import com.icx.microicx.stock_service.entitiy.StockItem;
import com.icx.microicx.stock_service.entitiy.Warehouse;
import com.icx.microicx.stock_service.repo.StockItemRepo;
import com.icx.microicx.stock_service.repo.StockRepo;
import com.icx.microicx.stock_service.repo.WarehouseRepo;
import com.icx.microicx.stock_service.service.StockService;
import com.icx.microicx.stock_service.service.WarehouseService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockServiceIMPL implements StockService, WarehouseService {

    @Autowired
    WarehouseRepo warehouseRepo;

    @Autowired
    StockRepo stockRepo;

    @Autowired
    StockItemRepo stockItemRepo;


    @Transactional
    @Override
    public ResponseDTO<Stock> addStock(StockSaveDTO stockSaveDTO) {
        ResponseDTO<Stock> responseDTO = new ResponseDTO<>();

        Warehouse warehouse = this.warehouseRepo.getReferenceById(stockSaveDTO.getWarehouseId());
        Stock stock = new Stock();
        stock.setWarehouse(warehouse);
        stock.setUserId(stockSaveDTO.getUserId());

        this.stockRepo.save(stock);

        if(stockRepo.existsById(stock.getId())){

            List<StockItem> stockItemList =  new ArrayList<>();

            for(StockItemSaveDTO stockItemSaveDTO :stockSaveDTO.getStockItems()){
                StockItem stockItem =  new StockItem();
                stockItem.setStock(stock);
                stockItem.setMaterialId(stockItemSaveDTO.getMaterialId());
                stockItem.setQty(stockItemSaveDTO.getQty());
                stockItem.setPrice(stockItemSaveDTO.getPrice());
                stockItem.setExp(stockItemSaveDTO.getExp());
                stockItemList.add(stockItem);
            }

            this.stockItemRepo.saveAll(stockItemList);
            responseDTO.setData(stock);
            responseDTO.setStatus(true);
            responseDTO.setMessage("success");

        }else{
            responseDTO.setMessage("not success");
        }

        return responseDTO;
    }

    @Override
    public List<Stock> getStockList() {
        return this.stockRepo.findAll();
    }

    @Override
    public Stock getStockById(String id) {
        return this.stockRepo.getReferenceById(Long.parseLong(id));
    }

    @Override
    public boolean addWarehouse(String name) {
        this.warehouseRepo.save(new Warehouse(name));
        return true;
    }

    @Override
    public List<Warehouse> findAllWarehouse() {
        return this.warehouseRepo.findAll();
    }
}
