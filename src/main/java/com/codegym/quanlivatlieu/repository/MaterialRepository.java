package com.codegym.quanlivatlieu.repository;

import com.codegym.quanlivatlieu.model.Material;
import com.codegym.quanlivatlieu.model.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MaterialRepository extends PagingAndSortingRepository<Material, Long> {
    Iterable<Material> findAllBySupplier(Supplier supplier);

    Page<Material> findAllBySupplier(Supplier supplier, Pageable pageable);

    Page<Material> findAllByOrderByPriceDesc( Pageable pageable);

    Page<Material> findAllByOrderByPriceAsc( Pageable pageable);
}
