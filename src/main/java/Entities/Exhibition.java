package Entities;

import javax.persistence.Id;

import java.util.UUID;


public class Exhibition {
    @Id
    private String exhibition_id;
    private String name;\
    private int open;

    public Exhibition(String name,
                      int open) {
        this.name = name;
        this.open = open;
        this.exhibition_id = UUID.randomUUID().toString();
    }

    public Exhibition() {

    }

    public String getExhibition_id() {
        return exhibition_id;
    }

    public String getName() {
        return name;
    }

    public double getOpen() {
        return open;
    }

    public void setExhibition_id(String exhibition_id) {
        this.exhibition_id = exhibition_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOpen(double open) {
        this.open = open;
    }
}
