package com.sahan.mdkbookings.database;

import com.sahan.mdkbookings.model.User;

public class UserDao {


    public boolean LoginChecker(String email, String password){

        String u_email = "admin@bcas.lk";
        String u_password = "123";

        try {

            LoginAsyncTask loginAsyncTask = new LoginAsyncTask("rezaan@oulook.com", "123");
            User user = loginAsyncTask.execute().get();

        } catch (Exception ex){
            ex.printStackTrace();
        }

      return false;
    }



}
