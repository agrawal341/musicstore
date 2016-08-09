package com.emusicstore.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
public class Product {

    @Id
    @SequenceGenerator(name = "productSeq", sequenceName = "CUSTOMER_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "productSeq")
    @Column(name = "PROD_ID")
    private Long productId;
    @NotEmpty(message = "The product name must not be null.")
    @Column(name = "NAME")
    private String productName;
    @Column(name = "CATEGORY")
    private String productCategory;
    @Column(name = "DESCRIPTION")
    private String productDescription;
    @Min(value = 0, message = "The product price must not be less than 0")
    @Column(name = "PRICE")
    private Long productPrice;
    @Column(name = "CONDITION")
    private String productCondition;
    @Column(name = "STATUS")
    private String productStatus;
    @Min(value = 0, message = "The product stock must not be less than 0")
    @Column(name = "STOCK")
    private Long productStock;
    @Column(name = "MANUFACTURER")
    private String productManufacture;

    @Transient
    private MultipartFile productImage;

    public MultipartFile getProductImage() {
        return productImage;
    }

    public void setProductImage(MultipartFile productImage) {
        this.productImage = productImage;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductManufacture() {
        return productManufacture;
    }

    public void setProductManufacture(String productManufacture) {
        this.productManufacture = productManufacture;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductCondition() {
        return productCondition;
    }

    public void setProductCondition(String productCondition) {
        this.productCondition = productCondition;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public Long getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Long productPrice) {
        this.productPrice = productPrice;
    }

    public Long getProductStock() {
        return productStock;
    }

    public void setProductStock(Long productStock) {
        this.productStock = productStock;
    }
}
