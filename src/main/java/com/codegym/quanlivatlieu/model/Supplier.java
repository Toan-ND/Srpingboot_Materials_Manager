package com.codegym.quanlivatlieu.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "sippliers")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name, discreption, address;

    @OneToMany(targetEntity = Material.class)
    private Set<Material> materials;

    public Supplier(){}

    public Supplier(String name, String discreption, String address) {
        this.name = name;
        this.discreption = discreption;
        this.address = address;
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

    public String getDiscreption() {
        return discreption;
    }

    public void setDiscreption(String discreption) {
        this.discreption = discreption;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(Set<Material> materials) {
        this.materials = materials;
    }
}
