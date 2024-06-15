package co.com.ps.C23A.controller;

import co.com.ps.C23A.domain.Products;
import co.com.ps.C23A.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final IProductService productService;

    @GetMapping("/name/{name}")
    private ResponseEntity<Products> getProductsByName(@PathVariable String name) {
        try {
            return ResponseEntity.ok(productService.findByName(name));
        }catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    private ResponseEntity<Products> saveProduct(@PathVariable Products Products) {
        try {
            return ResponseEntity.ok(productService.save(Products));
        }catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping()
    public ResponseEntity<List<Products>> getAllProduct(){
        try {
            return ResponseEntity.ok(productService.findAll());
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Products> getByIdProducts(@PathVariable Long id){
        try {
            return ResponseEntity.ok(productService.findById(id));
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> deleteByIdProducts(@PathVariable("id") Long id){
        try {
            productService.delete(id);
            return ResponseEntity.ok("ok");
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    public ResponseEntity<Products> updateProducts(@RequestBody Products products){
        try {
            return ResponseEntity.ok(productService.update(products));
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

}


