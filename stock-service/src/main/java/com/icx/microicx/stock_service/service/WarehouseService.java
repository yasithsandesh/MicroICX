package com.icx.microicx.stock_service.service;

import com.icx.microicx.stock_service.entitiy.Warehouse;

import java.util.List;

public interface WarehouseService {
    boolean addWarehouse(String name);
    List<Warehouse> findAllWarehouse();
}
