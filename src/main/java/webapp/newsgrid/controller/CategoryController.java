package webapp.newsgrid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import webapp.newsgrid.entity.Category;
import webapp.newsgrid.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping(path = "api/category")
public class CategoryController {
    public final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getCategories(){
        return categoryService.getCategories();
    }
    @PostMapping
    public void addNewCategory(@RequestBody Category category){
        categoryService.addNewCategory(category);
    }
    @DeleteMapping(path = "{id}")
    public void deleteCategory(@PathVariable("id") Long id){
        categoryService.deleteCategory(id);
    }
}
