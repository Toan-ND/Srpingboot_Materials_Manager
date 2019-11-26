package com.codegym.quanlivatlieu.model;

import javax.persistence.*;

@Entity
@Table(name = "materials")
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name, importDate, description, image;
    private double price, quantity;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    public Material() {
    }

    public Material(String name, String importDate, String description, String image, double price, double quantity) {
        this.name = name;
        this.importDate = importDate;
        this.description = description;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
    }

    public Material(String name, String importDate, String description, String image, double price, double quantity, Supplier supplier) {
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
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
