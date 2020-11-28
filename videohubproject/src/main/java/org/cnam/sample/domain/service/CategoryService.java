package org.cnam.sample.domain.service;


import org.cnam.sample.domain.entity.Category;
import org.cnam.sample.domain.entity.CategoryToCreate;
import org.cnam.sample.repository.CategoryRepository;
import org.cnam.sample.repository.model.CategoryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category getById(Long id) {
        CategoryModel entityCategoryFound = categoryRepository.getOne(id);
        return new Category(entityCategoryFound.getId(), entityCategoryFound.getLabel());
    }

    public Category create(CategoryToCreate categoryToCreate) {
        CategoryModel entityCategoryToCreate = new CategoryModel(categoryToCreate.label);
        CategoryModel entityCategoryCreated = categoryRepository.save(entityCategoryToCreate);
        return new Category(entityCategoryCreated.getId(), entityCategoryCreated.getLabel());
    }

    public void deleteById(long id) {
        try {
            categoryRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Category update(Category categoryToUpdate) {
        CategoryModel entityCategoryToUpdate = new CategoryModel(categoryToUpdate.id, categoryToUpdate.label);
        CategoryModel entityCategoryUpdated = categoryRepository.save(entityCategoryToUpdate);
        return new Category(entityCategoryUpdated.getId(), entityCategoryUpdated.getLabel());
    }



}
