package org.cnam.sample.domain.entity;

public class VideoToCreate {
    public String title;
    public String link;
    public Long category_id;
    public VideoToCreate(String title, String link,Long category_id) {
        this.title = title;
        this.link = link;
        this.category_id=category_id;
    }
}
