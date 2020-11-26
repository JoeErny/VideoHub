package org.cnam.sample.repository.model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "category")
public class ENTITY_Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToMany(mappedBy="category")
    private Set<ENTITY_Video> videos;

    @Column(name = "label")
    private String label;

    public ENTITY_Category(Long id, String label) {
        this.id = id;
        this.label = label;
    }

    public ENTITY_Category() {
    }

    public ENTITY_Category(String label) {
        this.label = label;
    }

    public ENTITY_Category(Long id) {
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

    public Set<ENTITY_Video> getVideos() {
        return videos;
    }
    public void setVideos(Set<ENTITY_Video> videos) {
        this.videos = videos;
    }
}
