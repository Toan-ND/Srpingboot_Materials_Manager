package com.codegym.quanlivatlieu.service.Impl;

import com.codegym.quanlivatlieu.model.Material;
import com.codegym.quanlivatlieu.model.Supplier;
import com.codegym.quanlivatlieu.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


public class MaterialServiceImpl implements com.codegym.quanlivatlieu.service.MaterialService {
    @Autowired
    MaterialRepository materialService;

    @Override
    public Page<Material> findAll(Pageable pageable) {
        return materialService.findAll(pageable);
    }

    @Override
    public Material findById(Long id) {
        return materialService.findById(id).get();
    }

    @Override
    public void save(Material material) {
materialService.save(material);
    }

    @Override
    public void delete(Long id) {
materialService.deleteById(id);
    }

    @Override
    public Iterable<Material> findAllBySupplier(Supplier supplier) {
        return materialService.findAllBySupplier(supplier);
    }

    @Override
    public Page<Material> findAllBySupplier(Supplier supplier, Pageable pageable) {
        return materialService.findAllBySupplier(supplier, pageable);
    }


    @Override
    public Page<Material> findAllByOrderByPriceDesc(Pageable pageable) {
        return materialService.findAllByOrderByPriceDesc( pageable);
    }

    @Override
    public Page<Material> findAllByOrderByPriceAsc( Pageable pageable) {
        return materialService.findAllByOrderByPriceAsc(pageable);
    }

    @GetMapping("/sort-price-asc")
    public ModelAndView showSortPriceAsc(@PageableDefault(size = 3) Pageable pageable){
        Page<Material> materials = materialService.findAllByOrderByPriceAsc(pageable);
        ModelAndView modelAndView = new ModelAndView("material/home");
        modelAndView.addObject("materials", materials);
        return modelAndView;
    }

    @GetMapping("/sort-price-desc")
    public ModelAndView showSortPriceDesc(@PageableDefault(size = 10) Pageable pageable){
        Page<Material> materials = materialService.findAllByOrderByPriceDesc(pageable);
        ModelAndView modelAndView = new ModelAndView("material/home");
        modelAndView.addObject("materials", materials);
        return modelAndView;
    }
}
