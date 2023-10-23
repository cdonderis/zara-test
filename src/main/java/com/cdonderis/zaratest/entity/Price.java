package com.cdonderis.zaratest.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "PRICES")
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "PRICE_ID")
    private Long priceId;

    @ManyToOne
    @JoinColumn(nullable = false, name = "brandId")
    private Brand brand;

    @Column(nullable = false, name = "START_DATE")
    @JsonFormat(pattern = "YYYY-MM-DD hh:mm:ss")
    private LocalDateTime startDate;

    @Column(nullable = false, name = "END_DATE")
    @JsonFormat(pattern = "YYYY-MM-DD hh:mm:ss")
    private LocalDateTime endDate;

    @Column(nullable = false, name = "PRICE_LIST")
    private int priceList;

    @Column(nullable = false, name = "PRODUCT_ID")
    private int productId;

    @Column(nullable = false, name = "PRIORITY_ID")
    private int priority;

    @Column(nullable = false, name = "PRICE")
    private Double price;

    @Column(nullable = false, name = "CURR")
    private String curr;

    public Price() {

    }

    public Price(Long priceId, Brand brand, LocalDateTime startDate, LocalDateTime endDate, int priceList, int productId, int priority, Double price, String curr) {
        this.priceId = priceId;
        this.brand = brand;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priceList = priceList;
        this.productId = productId;
        this.priority = priority;
        this.price = price;
        this.curr = curr;
    }


    public Long getPriceId() {
        return priceId;
    }

    public void setPriceId(Long priceId) {
        this.priceId = priceId;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public int getPriceList() {
        return priceList;
    }

    public void setPriceList(int priceList) {
        this.priceList = priceList;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCurr() {
        return curr;
    }

    public void setCurr(String curr) {
        this.curr = curr;
    }


    @Override
    public String toString() {
        return "Price{" +
                "priceId=" + priceId +
                ", brand=" + brand +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", priceList=" + priceList +
                ", productId=" + productId +
                ", priority=" + priority +
                ", price=" + price +
                ", curr='" + curr + '\'' +
                '}';
    }
}
