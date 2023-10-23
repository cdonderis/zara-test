package com.cdonderis.zaratest.entity;

import javax.persistence.*;

@Entity
@Table(name = "BRAND")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "BRAND_ID")
    private Long brandId;

    @Column(nullable = false, name = "BRAND_NAME")
    private String brandName;

    public Brand() {

    }

    public Brand(Long brandId, String brandName) {
        this.brandId = brandId;
        this.brandName = brandName;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }


    @Override
    public String toString() {
        return "Brand{" +
                "brandId=" + brandId +
                ", brandName='" + brandName + '\'' +
                '}';
    }
}
