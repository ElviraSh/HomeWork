package ru.kpfu.itis.ShalafaevaElvira.objects;

/**
 * Created by Elvira on 13.11.2016.
 */
public class Comments {
    private String comment;/*
    private byte[] content;*/
    private int product;
    private String email;
    private int comm_id;

    public Comments() {
    }

    public Comments(String comment, int comm_id, int product, String email) {
        this.product = product;
        this.email = email;
        this.comment = comment;
        this.comm_id = comm_id;
    }

    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }


    public int getProduct() {
        return product;
    }

    public void setProduct(int product) {
        this.product = product;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public int getComm_id() {
        return comm_id;
    }

    public void setComm_id(int comm_id) {
        this.comm_id = comm_id;
    }


}
