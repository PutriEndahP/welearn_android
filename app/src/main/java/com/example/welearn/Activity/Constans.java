package com.example.welearn.Activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import java.io.File;

public class Constans {
    public static void deleteCache(ProfilActivity ProfilActivity) {
        try {
            File dir = ProfilActivity.getCacheDir();
            deleteDir(dir);
        } catch (Exception e) { e.printStackTrace();}
    }

    public static boolean deleteDir(File dir) {
        if (dir != null && dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
            return dir.delete();
        } else if(dir!= null && dir.isFile()) {
            return dir.delete();
        } else {
            return false;
        }
    }

    public static void quit(ProfilActivity ProfilActivity) {
        Intent start = new Intent(ProfilActivity, HalamanUtamaActivity.class);
        start.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        start.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        ProfilActivity.startActivity(start);
        ((Activity)ProfilActivity).finish();
    }
}
