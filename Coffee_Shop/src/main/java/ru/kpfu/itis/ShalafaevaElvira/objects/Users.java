package ru.kpfu.itis.ShalafaevaElvira.objects;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Elvira on 12.11.2016.
 */
public class Users {
    //-------------ATRIBUTES----------------
    public static final String ATRIBUTE_ID = "user_id";
    public static final String ATRIBUTE_NAME = "username";
    public static final String ATRIBUTE_PASSWORD = "password";
    public static final String ATRIBUTE_EMAIL = "email";
    //--------------------------------------

    private int id;
    private String name;
    private String email;
    private String password;


    public Users(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Users(String id, String name, String email, String password) {
        this.id = -1;
        try {
            this.id = Integer.parseInt(id);
        } catch (NumberFormatException ex){
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.name = name;
        this.email = email;
        this.password = password;
      /*  *//*if (gender.toLowerCase().equals("male")){
            this.gender = GENDER_MALE;
        }
        else{
            if (gender.toLowerCase().equals("female")){
                this.gender = GENDER_FEMALE;
            }
            else{
                this.gender = GENDER_MALE;
            }
        }*//*
        this.city = city;
       *//* if (newsletter != null){
            if (newsletter.toLowerCase().equals("") || newsletter.toLowerCase().equals("false")){
                this.newsletter = false;
            }
        }
        else{
            this.newsletter = false;
        }*//*
        this.isEditor = Boolean.parseBoolean(isEditor);*/
    }


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
    public String getPassword(){return password;}
/*
    public int getGender() {
        return gender;
    }*/
/*
    public String getCity() {
        return city;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }*/

   /* public boolean getNewsletter() {
        return newsletter;
    }*//*

    public boolean isEditor() {
        return isEditor;
    }
    public String isEditorString() {
        return Boolean.toString(isEditor);*/

    //}

/*
    public boolean isNewsletter() {
        return newsletter;
    }*/
/*
    public List<Coffee> getCoffeeList() {
        return coffeeList;
    }

    public void setCoffeeList(List<Coffee> coffeeList) {
        this.coffeeList = coffeeList;
    }*/

    public int getId() {
        return id;
    }
}

