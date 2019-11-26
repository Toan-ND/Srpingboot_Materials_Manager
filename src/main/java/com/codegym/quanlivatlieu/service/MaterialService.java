package com.codegym.quanlivatlieu.service;

import com.codegym.quanlivatlieu.model.Material;
import com.codegym.quanlivatlieu.model.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface MaterialService {
    Page<Material> findAll(Pageable pageable);

    Material findById(Long id);

    void save(Material material);

    void delete(Long id);

    Iterable<Material> findAllBySupplier(Supplier supplier);

    Page<Material> findAllBySupplier(Supplier supplier, Pageable pageable);

    Page<Material> findAllByOrderByPriceDesc(Pageable pageable);

    Page<Material> findAllByOrderByPriceAsc( Pageable pageable);
}
