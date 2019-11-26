package com.codegym.quanlivatlieu.controller;

import com.codegym.quanlivatlieu.model.Material;
import com.codegym.quanlivatlieu.model.Supplier;
import com.codegym.quanlivatlieu.repository.SupplierRepository;
import com.codegym.quanlivatlieu.service.MaterialService;
import com.codegym.quanlivatlieu.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.constraints.PastOrPresent;
import java.awt.print.Pageable;

@Controller
public class SupplierController {
    @Autowired
    SupplierService supplierService;

    @Autowired
    MaterialService materialService;



    @GetMapping("/suppliers")
    public ModelAndView home(){
        Iterable<Supplier> suppliers = supplierService.findAll();
        ModelAndView modelAndView = new ModelAndView("supplier/home");
        modelAndView.addObject("suppliers", suppliers);
        return modelAndView;
    }

    @GetMapping("/create-supplier")
    public ModelAndView showCreateform(){
    ModelAndView modelAndView = new ModelAndView("supplier/create");
    modelAndView.addObject("supplier", new Supplier());
    return modelAndView;
    }

    @PostMapping("/create-supplier")
    public ModelAndView saveSupplier(@ModelAttribute Supplier supplier){
        supplierService.save(supplier);
        ModelAndView modelAndView = new ModelAndView("supplier/create");
        modelAndView.addObject("supplier", supplier);
        modelAndView.addObject("message", "add new supplier successfully!");
        return modelAndView;
    }

    @GetMapping("/edit-supplier/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Supplier supplier= supplierService.findById(id);
        ModelAndView modelAndView = new ModelAndView("supplier/edit");
        modelAndView.addObject("supplier", supplier);
        return modelAndView;
    }

    @PostMapping("/edit-supplier")
    public ModelAndView updateSupplier(@ModelAttribute Supplier supplier){
        supplierService.save(supplier);
        ModelAndView modelAndView = new ModelAndView("supplier/edit");
        modelAndView.addObject("supplier", supplier);
        modelAndView.addObject("message", "update supplier successfully!");
        return modelAndView;
    }

    @GetMapping("/delete-supplier/{id}")
    public ModelAndView deleteForm (@PathVariable Long id){
        Supplier supplier = supplierService.findById(id);
        ModelAndView modelAndView =  new ModelAndView("supplier/delete");
        modelAndView.addObject("supplier", supplier);
        return modelAndView;
    }

    @PostMapping("/delete-supplier")
    public String deleteSupplier(@ModelAttribute Supplier supplier){
        supplierService.delete(supplier.getId());
        return "redirect:suppliers";
    }

}
