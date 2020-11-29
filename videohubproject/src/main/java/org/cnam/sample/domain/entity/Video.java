package org.cnam.sample.domain.entity;

public class Video {
    public Long id;
    public String title;
    public String link;
    public Long category_id;

    public Video(Long id, String title, String link, Long category_id) {
        this.id = id;
        this.title = title;
        this.link = link;
        this.category_id=category_id;
    }
}
