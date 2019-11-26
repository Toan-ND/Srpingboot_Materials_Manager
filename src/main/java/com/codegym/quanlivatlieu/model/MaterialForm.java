package com.codegym.quanlivatlieu.model;

import org.springframework.web.multipart.MultipartFile;

public class MaterialForm {
    private Long id;
    private String name, importDate, description;
    private MultipartFile image;
    private double price, quantity;
    private Supplier supplier;

    public MaterialForm(){}

    public MaterialForm(Long id, String name, String importDate, String description, MultipartFile image, double price, double quantity, Supplier supplier) {
        this.id = id;
        this.name = name;
        this.importDate = importDate;
        this.description = description;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
        this.supplier = supplier;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImportDate() {
        return importDate;
    }

    public void setImportDate(String importDate) {
        this.importDate = importDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}
