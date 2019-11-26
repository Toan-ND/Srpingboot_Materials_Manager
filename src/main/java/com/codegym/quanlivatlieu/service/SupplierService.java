package com.codegym.quanlivatlieu.service;

import com.codegym.quanlivatlieu.model.Supplier;

import java.awt.print.Pageable;

public interface SupplierService {
    Iterable<Supplier> findAll();

    Supplier findById(Long id);

    void save(Supplier supplier);

    void delete(Long id);
}
