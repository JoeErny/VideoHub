package org.cnam.sample.domain.service;


import org.cnam.sample.domain.entity.Video;
import org.cnam.sample.repository.OrderRepository;
import org.cnam.sample.repository.VideoRepository;
import org.cnam.sample.repository.model.CategoryModel;
import org.cnam.sample.repository.model.OrderModel;
import org.cnam.sample.repository.model.UserModel;
import org.cnam.sample.repository.model.VideoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UsersVideoLibraryService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    VideoService videoService;

    public List<Video> findAllVideosOwnedByUser(Long userId) {
        List<Video> videosFound = new ArrayList<Video>();
        List<OrderModel> ordersModelsFound = orderRepository.findAllOrdersByUserAndStatus(new UserModel(userId), PaymentStatusEnum.PAID.name());
        for (OrderModel orderModel : ordersModelsFound
        ) {
            videosFound.add(videoService.getById(orderModel.getVideo().getId()));
        }
        return videosFound;
    }


}
