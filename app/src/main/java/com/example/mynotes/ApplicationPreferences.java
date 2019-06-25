package com.example.mynotes;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class ApplicationPreferences {

    private static SharedPreferences mSharedPref;
    static final String KEYVALUES = "VALUES";

    private ApplicationPreferences() {

    }

    // Asigna la base de datps que se llama MYPREFS
    public static void init(Context context) {

        if(mSharedPref == null){
            mSharedPref = context.getSharedPreferences("MYNOTES", Activity.MODE_PRIVATE);
        }
    }

    // guarda lo que hay dentro del edittext
    public static void  saveValues( NotesModel VALUES) {

        SharedPreferences.Editor edit = get().edit();
        String json = new Gson().toJson(VALUES);
        edit.putString(KEYVALUES,json);
        edit.commit();
    }



    public static List<NotesModel> readNotes() {
        Gson gson = new Gson();
        String json = mSharedPref.getString("MYVALUES", "");
        Type type = new TypeToken<List<NotesModel>>(){}.getType();
        List<NotesModel> obj = gson.fromJson(json, type);

        return obj;
    }

}
