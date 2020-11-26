package org.cnam.sample.repository.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "video")
public class ENTITY_Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "link")
    private String link;

    @OneToMany(mappedBy="video")
    private Set<ENTITY_Order> orders;

    public ENTITY_Video(String title, String link, ENTITY_Category category) {
        this.title = title;
        this.link = link;
        this.category = category;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", nullable = true)
    private ENTITY_Category category;

    public ENTITY_Video(Long id, String title, String link, ENTITY_Category category) {
        this.id = id;
        this.title = title;
        this.link = link;
        this.category = category;
    }

    public ENTITY_Video(Long id) {
        this.id = id;
    }

    public ENTITY_Video(Long id, String title, String link) {
        this.id = id;
        this.title = title;
        this.link = link;
    }

    public ENTITY_Video(String title, String link) {
        this.title = title;
        this.link = link;
    }

    public ENTITY_Video() {
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

    public Set<ENTITY_Order> getOrders() {
        return orders;
    }
    public void setOrders(Set<ENTITY_Order> orders) {
        this.orders = orders;
    }
    public ENTITY_Category getCategory() {
        return category;
    }

    public void setCategory(ENTITY_Category category) {
        this.category = category;
    }



}
