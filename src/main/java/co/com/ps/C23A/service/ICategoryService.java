package co.com.ps.C23A.service;

import co.com.ps.C23A.domain.Category;

import java.util.List;

public interface ICategoryService {

    Category findById(Long idCategory);
    Category findByName(String nombre);
    List<Category> findAll();
    Category save(Category category);
    Category update(Category category);
    void delete(Long idCategory);
}
