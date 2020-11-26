package org.cnam.sample.repository.model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "category")
public class CategoryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToMany(mappedBy="category")
    private Set<VideoModel> videos;

    @Column(name = "label")
    private String label;

    public CategoryModel(Long id, String label) {
        this.id = id;
        this.label = label;
    }

    public CategoryModel() {
    }

    public CategoryModel(String label) {
        this.label = label;
    }

    public CategoryModel(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Set<VideoModel> getVideos() {
        return videos;
    }
    public void setVideos(Set<VideoModel> videos) {
        this.videos = videos;
    }
}
