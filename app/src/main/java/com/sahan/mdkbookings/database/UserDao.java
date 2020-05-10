package com.sahan.mdkbookings.database;

import com.sahan.mdkbookings.User;

public class UserDao {


    public boolean LoginChecker(String email, String password){

        String u_email = "sahan@bcas.lk";
        String u_password = "123";

        if(email.equals(u_email) && password.equals(u_password)){
            return true;
        } else {
            return false;
        }
    }

}
