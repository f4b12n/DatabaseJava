package co.com.ps.C23A.service;

import co.com.ps.C23A.domain.Products;

import java.util.List;

public interface IProductService {

    Products findById (Long idProducts);
    Products findByName (String nombre);
    List<Products> findAll();
    Products update(Products products);
    void delete(Long idProducts);
    Products save(Products products);
}
