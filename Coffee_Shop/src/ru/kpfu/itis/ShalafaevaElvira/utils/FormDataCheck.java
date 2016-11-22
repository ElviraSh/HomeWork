package ru.kpfu.itis.ShalafaevaElvira.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Elvira on 12.11.2016.
 */
public class FormDataCheck {
    private FormDataCheck(){
    }
    public static String checkAllFieldsAndGetErrorMessageIfFieldsAreInvalid(String username, String email, String password1, String password2){
        String errorMessage = "Error:";
        if (!checkEmail(email)){
            errorMessage += "\ninvalid email";
        }
        if (!checkPassword(password1)){
            errorMessage += "\ninvalid password";
        }
        else{
            if (!password1.equals(password2)){
                errorMessage += "\nYou incorrect repeat password";
            }
        }


        if (errorMessage.equals("Error:")){
            errorMessage = null;
        }
        return errorMessage;
    }
    public static boolean checkPassword(String password) {

        if (password != null) {

            if (password.length() > 3) {
                return true;
            }
            return false;
        } else {
            return false;
        }
    }
    public static boolean checkEmail(String email){
        if (email != null){
            Pattern p = Pattern.compile("^(?:[a-zA-Z0-9\\._])+@(?:[a-zA-Z0-9\\-]+\\.)+[a-zA-Z0-9\\-]+$");
            Matcher m = p.matcher(email);
            return m.matches();
        }
        else{
            return false;
        }
    }


}

