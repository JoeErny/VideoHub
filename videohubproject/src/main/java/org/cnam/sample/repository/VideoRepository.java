package org.cnam.sample.repository;


import org.cnam.sample.domain.entity.Category;
import org.cnam.sample.repository.model.CategoryModel;
import org.cnam.sample.repository.model.OrderModel;
import org.cnam.sample.repository.model.PaymentModel;
import org.cnam.sample.repository.model.VideoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VideoRepository extends JpaRepository<VideoModel, Long> {

    List<VideoModel> findAllByCategory(CategoryModel categoryModel);

}
