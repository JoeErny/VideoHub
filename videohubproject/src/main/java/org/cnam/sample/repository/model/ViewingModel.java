package org.cnam.sample.repository.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "viewing")
public class ViewingModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    private UserModel user;

    @OneToOne
    private VideoModel video;

    @Column
    private Date date;

    public ViewingModel(Long id, UserModel user, VideoModel video, Date date) {
        this.id = id;
        this.user = user;
        this.video = video;
        this.date = date;
    }

    public ViewingModel(Long id) {
        this.id = id;
    }

    public ViewingModel() {
    }

    public ViewingModel(UserModel user, VideoModel video,Date date) {
        this.user = user;
        this.video = video;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public VideoModel getVideo() {
        return video;
    }

    public void setVideo(VideoModel video) {
        this.video = video;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }





}
