package com.codegym.quanlivatlieu;

import com.codegym.quanlivatlieu.service.Impl.MaterialServiceImpl;
import com.codegym.quanlivatlieu.service.Impl.SupplierServiceImpl;
import com.codegym.quanlivatlieu.service.MaterialService;
import com.codegym.quanlivatlieu.service.SupplierService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableSpringDataWebSupport
@EnableWebMvc
public class QuanlivatlieuApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuanlivatlieuApplication.class, args);
    }

    @Bean
    public MaterialService materialService(){
        return new MaterialServiceImpl();
    }

    @Bean
    public SupplierService supplierService(){
        return new SupplierServiceImpl();
    }
}
