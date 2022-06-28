package webapp.newsgrid.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webapp.newsgrid.entity.Category;
import webapp.newsgrid.repository.CategoryRepository;

import java.util.List;
@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public void addNewCategory(Category category) {
        categoryRepository.save(category);
    }

    public void deleteCategory(Long id) {
        if(categoryRepository.existsById(id)){
            categoryRepository.deleteById(id);
        }else{
            throw new IllegalStateException("Category id:" + id + " is invalid.");
        }
    }
}
