package co.com.ps.C23A.service;

import co.com.ps.C23A.domain.Category;
import co.com.ps.C23A.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CategoriaService implements ICategoryService{

    private final CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    @Override
    public Category findById(Long idCategory) {
        Optional<Category> categoryTmp = categoryRepository.findById(idCategory);
        if (categoryTmp.isPresent()) {
            return categoryTmp.get();
        }else{
            throw new RuntimeException("Category not found" + idCategory);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public Category findByName(String name) {
        Optional<Category> categoryTmp = categoryRepository.findByCategoryName(name);
        if (categoryTmp.isPresent()) {
            return categoryTmp.get();
        }else{
            throw new RuntimeException("Category not found" + name);
        }
    }
    @Transactional(readOnly = true)
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Transactional (readOnly = false, propagation = Propagation.REQUIRED)
    @Override
    public Category update(@org.jetbrains.annotations.NotNull Category category) {
        if (categoryRepository.existsById(category.getCategoryId())){
            return categoryRepository.save(category);
        }else{
            throw new RuntimeException("Category not found with id: " + category.getCategoryId());
        }
    }

    @Transactional (readOnly = false, propagation = Propagation.REQUIRED)
    @Override
    public void delete(Long idCategory) {
        if (categoryRepository.existsById(idCategory)) {
            categoryRepository.deleteById(idCategory);
        }else {
            throw new RuntimeException("Category not found with id: " + idCategory);
        }
    }
}
