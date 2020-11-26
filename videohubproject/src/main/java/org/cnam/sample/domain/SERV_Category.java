package org.cnam.sample.domain;


import org.cnam.sample.domain.entity.Category;
import org.cnam.sample.domain.entity.CategoryToCreate;
import org.cnam.sample.repository.REP_Category;
import org.cnam.sample.repository.model.ENTITY_Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class SERV_Category {

    @Autowired
    private REP_Category categoryRepository;

    public Category getById(Long id) {
        ENTITY_Category entityCategoryFound = categoryRepository.getOne(id);
        return new Category(entityCategoryFound.getId(), entityCategoryFound.getLabel());
    }

    public Category create(CategoryToCreate categoryToCreate) {
        ENTITY_Category entityCategoryToCreate = new ENTITY_Category(categoryToCreate.label);
        ENTITY_Category entityCategoryCreated = categoryRepository.save(entityCategoryToCreate);
        return new Category(entityCategoryCreated.getId(), entityCategoryCreated.getLabel());
    }

}
