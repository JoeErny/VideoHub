package org.cnam.sample.repository.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "video")
public class VideoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "link")
    private String link;

    @OneToMany(mappedBy="video")
    private Set<OrderModel> orders;

    public VideoModel(String title, String link, CategoryModel category) {
        this.title = title;
        this.link = link;
        this.category = category;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", nullable = true)
    private CategoryModel category;

    public VideoModel(Long id, String title, String link, CategoryModel category) {
        this.id = id;
        this.title = title;
        this.link = link;
        this.category = category;
    }

    public VideoModel(Long id) {
        this.id = id;
    }

    public VideoModel(Long id, String title, String link) {
        this.id = id;
        this.title = title;
        this.link = link;
    }

    public VideoModel(String title, String link) {
        this.title = title;
        this.link = link;
    }

    public VideoModel() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Set<OrderModel> getOrders() {
        return orders;
    }
    public void setOrders(Set<OrderModel> orders) {
        this.orders = orders;
    }
    public CategoryModel getCategory() {
        return category;
    }

    public void setCategory(CategoryModel category) {
        this.category = category;
    }



}
