package com.example.consultants.week7daily2;

import android.content.Context;
import android.content.SharedPreferences;

public class LoginManager {

    Context context;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public LoginManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void createAccount(String email, String password) {
        editor.putString(email, password);
        editor.commit();
    }

    public boolean checkUser(String email, String password) {

        String savedPassword = sharedPreferences.getString(email, "invalid");
        return savedPassword.equals(password);
    }
}
