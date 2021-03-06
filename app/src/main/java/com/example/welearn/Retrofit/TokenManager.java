package com.example.welearn.Retrofit;

import android.content.SharedPreferences;

public class TokenManager {
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;

    private static TokenManager INSTANCE = null;

    private TokenManager(SharedPreferences prefs){
        this.prefs = prefs;
        this.editor = prefs.edit();
    }

    public static synchronized TokenManager getInstance(SharedPreferences prefs){
        if(INSTANCE==null){
            INSTANCE = new TokenManager(prefs);
        }
        return INSTANCE;
    }

    public void saveToken(AccessToken token){
        editor.putString("ACCESS_TOKEN", token.getMessage().getToken()).commit();
    }

    public void deleteToken(){
        editor.remove("ACCESS_TOKEN").commit();

    }

    public String getToken(){
//        AccessToken token = new AccessToken();
//        token.getMessage().setToken(prefs.getString("ACCESS_TOKEN", null));
        return prefs.getString("ACCESS_TOKEN", null);
    }
}
