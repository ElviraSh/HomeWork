package ru.kpfu.itis.ShalafaevaElvira.objects;

import java.io.Serializable;

/**
 * Created by Elvira on 20.10.2016.
 */

public class Coffee implements Serializable{
    private String name;
    private int price;
    private String description;
    private String image;
    private long id;

    public Coffee() {
    }

    public Coffee(String name, long id, int price, String description, String image) {
        this.price = price;
        this.description = description;
        this.name = name;
        this.id = id;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
