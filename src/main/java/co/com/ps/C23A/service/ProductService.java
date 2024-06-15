package co.com.ps.C23A.service;

import co.com.ps.C23A.domain.Products;
import co.com.ps.C23A.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductService implements IProductService {

    private final ProductRepository productRepository;

    @Transactional(readOnly = true)
    @Override
    public Products findById(Long idProducts) {
        Optional<Products> productTmp = productRepository.findById(idProducts);
        if (productTmp.isPresent()) {
            return productTmp.get();
        } else {
            throw new RuntimeException("Products not found" + idProducts);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public Products findByName(String name) {
        Optional<Products> productTmp = productRepository.findByProductName(name);
        if (productTmp.isPresent()) {
            return productTmp.get();
        } else {
            throw new RuntimeException("Product not found" + name);
        }
    }

    @Transactional (readOnly = true)
    @Override
    public List<Products> findAll() {
        return productRepository.findAll();
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    @Override
    public Products save(Products Product) {
        return productRepository.save(Product);
    }

    @Transactional (readOnly = true, propagation = Propagation.REQUIRED)
    @Override
    public Products update(Products products) {
        if (productRepository.existsById(products.getProductId())) {
            return productRepository.save(products);
        }else {
            throw new RuntimeException ("Product not found by ID" + products.getProductId());
        }
    }

    @Transactional (readOnly = true, propagation = Propagation.REQUIRED)
    @Override
    public void delete(Long idProducts) {
        if (productRepository.existsById(idProducts)) {
            productRepository.deleteById(idProducts);
        }else {
            throw new RuntimeException("Product not found by ID" + idProducts);
        }

    }

}