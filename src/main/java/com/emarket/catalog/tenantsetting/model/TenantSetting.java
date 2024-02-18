package com.emarket.catalog.tenantsetting.model;

import com.emarket.catalog.product.model.Product;
import jakarta.persistence.*;

@Entity
@Table(name = "tenant_setting")
public class TenantSetting {
    @Id
    Long productId;

    @Column
    Boolean isSaleActive;


    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "productId", referencedColumnName = "id")
    private Product product;

    public TenantSetting(Long productId, Boolean isSaleActive, Product product) {
        this.productId = productId;
        this.isSaleActive = isSaleActive;
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


    public TenantSetting() {
    }


    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Boolean getSaleActive() {
        return isSaleActive;
    }

    public void setSaleActive(Boolean saleActive) {
        isSaleActive = saleActive;
    }
}
