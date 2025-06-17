package com.icx.microicx.stock_service.entitiy;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import javax.xml.crypto.Data;
import java.util.Date;

@Entity
@Table(name = "stock_item")
public class StockItem {
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

    @ManyToOne()
    @JoinColumn(name = "stock_id",nullable = false)
    private Stock stock;

    @Column(name = "material_id")
    private long materialId;
    private double qty;
    private double price;
    private Date exp;

    public StockItem() {
    }

    public StockItem(long id, Stock stock, long materialId, double qty, double price, Date exp) {
        this.id = id;
        this.stock = stock;
        this.materialId = materialId;
        this.qty = qty;
        this.price = price;
        this.exp = exp;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public long getMaterialId() {
        return materialId;
    }

    public void setMaterialId(long materialId) {
        this.materialId = materialId;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getExp() {
        return exp;
    }

    public void setExp(Date exp) {
        this.exp = exp;
    }
}
