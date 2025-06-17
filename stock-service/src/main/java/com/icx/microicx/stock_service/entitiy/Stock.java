package com.icx.microicx.stock_service.entitiy;


import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "stock")
public class Stock {
    @Id
    @Column(name = "id")
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    private long id;

    @Column(name = "user_id")
    private long userId;

    @ManyToOne
    @JoinColumn(name = "warehouse_id",nullable = false)
    private Warehouse warehouse;

    @Column(name = "added_date")
    private LocalDateTime addedDate;

    @OneToMany(mappedBy = "stock")
    private List<StockItem> stockItems;

    public  Stock(){}

    public Stock(Warehouse warehouse, long userId, long id) {
        this.warehouse = warehouse;
        this.userId = userId;
        this.id = id;
    }

    public Stock(long userId, Warehouse warehouse, LocalDateTime addedDate, List<StockItem> stockItems) {
        this.userId = userId;
        this.warehouse = warehouse;
        this.addedDate = addedDate;
        this.stockItems = stockItems;
    }

    @PrePersist
    protected void onCreate() {
        this.addedDate = LocalDateTime.now();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public LocalDateTime getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(LocalDateTime addedDate) {
        this.addedDate = addedDate;
    }

    public List<StockItem> getStockItems() {
        return stockItems;
    }

    public void setStockItems(List<StockItem> stockItems) {
        this.stockItems = stockItems;
    }
}
