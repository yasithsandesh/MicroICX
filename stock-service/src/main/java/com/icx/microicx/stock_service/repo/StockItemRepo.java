package com.icx.microicx.stock_service.repo;

import com.icx.microicx.stock_service.entitiy.StockItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface StockItemRepo  extends JpaRepository<StockItem,Long> {

}
