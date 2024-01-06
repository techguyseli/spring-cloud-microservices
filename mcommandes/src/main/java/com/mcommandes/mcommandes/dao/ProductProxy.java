package com.mcommandes.mcommandes.dao;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mcommandes.mcommandes.models.beans.ProductBean;

@FeignClient(name = "microservice-produits", url = "localhost:9001")
public interface ProductProxy {
    
    @GetMapping(value = "/products")
    List<ProductBean> listeDesProduits();

    @GetMapping( value = "/products/{id}")
    ProductBean recupererUnProduit(@PathVariable("id") Long id);
}
