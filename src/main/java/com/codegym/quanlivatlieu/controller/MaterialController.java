package com.codegym.quanlivatlieu.controller;

import com.codegym.quanlivatlieu.model.Material;
import com.codegym.quanlivatlieu.model.MaterialForm;
import com.codegym.quanlivatlieu.model.Supplier;
import com.codegym.quanlivatlieu.service.MaterialService;
import com.codegym.quanlivatlieu.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Controller
public class MaterialController {
    @Autowired
    Environment env;

    @Autowired
    MaterialService materialService;

    @Autowired
    SupplierService supplierService;

    @ModelAttribute("supplier")
    public Iterable<Supplier> suppliers() {
        return supplierService.findAll();
    }

    @GetMapping("/materials")
    public ModelAndView home(@RequestParam(name = "s") Optional<Supplier> s, @PageableDefault(size = 3) Pageable pageable) {
        Page<Material> materials;
        if (s.isPresent()) {
            materials = materialService.findAllBySupplier(s.get(), pageable);
        } else {
            materials = materialService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("material/home");
        modelAndView.addObject("materials", materials);
        return modelAndView;
    }
    @GetMapping("/create-material")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("material/create");
        modelAndView.addObject("materialForm", new MaterialForm());
        return modelAndView;
    }

    @PostMapping("/create-material")
    public ModelAndView showCreateForm(@ModelAttribute("materialForm") MaterialForm materialForm) {
        MultipartFile multipartFile = materialForm.getImage();
        String fileName = multipartFile.getOriginalFilename();
        String fileUpload = env.getProperty("file_upload").toString();
        try {
            FileCopyUtils.copy(materialForm.getImage().getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Material materialObject = new Material(materialForm.getName(),materialForm.getImportDate(), materialForm.getDescription(),fileName,materialForm.getPrice(),materialForm.getQuantity(), materialForm.getSupplier());
        materialService.save(materialObject);
        ModelAndView modelAndView = new ModelAndView("material/create");
        modelAndView.addObject("message", "Add new materrial successfully!");
        return modelAndView;
    }

    @GetMapping("/edit-material/{id}")
    public ModelAndView showEditform(@PathVariable Long id){
        Material material = materialService.findById(id);
        MaterialForm materialForm = new MaterialForm(material.getId(), material.getName(),material.getImportDate(),material.getDescription(),null, material.getPrice(), material.getQuantity(),material.getSupplier());
        materialForm.setSupplier(material.getSupplier());
        ModelAndView modelAndView = new ModelAndView("material/edit");
        modelAndView.addObject("material", material);
        modelAndView.addObject("materialForm", materialForm);
        return modelAndView;
    }
    @PostMapping("/edit-material")
    public ModelAndView update(@ModelAttribute("materialForm") MaterialForm materialForm){
        MultipartFile multipartFile = materialForm.getImage();
        String fileName = multipartFile.getOriginalFilename();
        String fileUpload = env.getProperty("file_upload").toString();
        try {
            FileCopyUtils.copy(materialForm.getImage().getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Material material = new Material(materialForm.getName(), materialForm.getImportDate(), materialForm.getDescription(),fileName, materialForm.getPrice(), materialForm.getQuantity());
        material.setSupplier(materialForm.getSupplier());
        material.setId(materialForm.getId());
        materialService.save(material);
        ModelAndView modelAndView = new ModelAndView("material/edit");
        modelAndView.addObject("material",material);
        modelAndView.addObject("message", "Update student successfully!");
        return modelAndView;
    }
    @GetMapping("/delete-material/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Material material = materialService.findById(id);
        ModelAndView modelAndView = new ModelAndView("material/delete");
        modelAndView.addObject("material", material);
        return modelAndView;
    }


    @PostMapping("/delete-material")
    public String deleteStudent(@ModelAttribute Material material){
        materialService.delete(material.getId());
        return "redirect:materials";
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
