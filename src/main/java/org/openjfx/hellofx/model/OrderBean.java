package org.openjfx.hellofx.model;

import java.util.Date;

public class OrderBean {

    private Date orderDate;
    private String region;
    private String rep1;
    private String rep2;
    private String item;
    private int units;
    private float unitCost;
    private float total;

    public Date getOrderDate() {
        return this.orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getRegion() {
        return this.region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRep1() {
        return this.rep1;
    }

    public void setRep1(String rep1) {
        this.rep1 = rep1;
    }

    public String getRep2() {
        return this.rep2;
    }

    public void setRep2(String rep2) {
        this.rep2 = rep2;
    }

    public String getItem() {
        return this.item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getUnits() {
        return this.units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public float getUnitCost() {
        return this.unitCost;
    }

    public void setUnitCost(float unitCost) {
        this.unitCost = unitCost;
    }

    public float getTotal() {
        return this.total;
    }

    public void setTotal(float total) {
        this.total = total;
    }    
}
