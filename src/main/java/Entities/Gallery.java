package Entities;


import javax.persistence.Id;

import java.util.UUID;

public final class Gallery {

    @Id
    private String gallery_id;

    private String name;

    public Gallery(String name) {

        this.name = name;

        this.gallery_id = UUID.randomUUID().toString();
    }

    public Gallery() {
    }

    public String getGallery_id() {

        return gallery_id;
    }

    public String getName() {

        return name;
    }

    public void setGallery_id(String gallery_id) {
        this.gallery_id = gallery_id;
    }

    public void setName(String name) {
        this.name = name;
    }

}