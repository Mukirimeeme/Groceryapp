package com.farm.mbaabu.grocery;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

public class pref_config

{
    private SharedPreferences sharedPreferences;
    private Context context;

    public pref_config(Context context)
    {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(context.getString(R.string.pref_file), context.MODE_PRIVATE);


    }

    public void writelogin_status(boolean status)
    {

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(context.getString(R.string.pref_login_status),status);
        editor.commit();
    }
    public boolean readlogin_status()

    {
        return sharedPreferences.getBoolean(context.getString(R.string.pref_login_status), false);

    }


    public void write_name(String name)
    {
        SharedPreferences.Editor editor =sharedPreferences.edit();
        editor.putString(context.getString(R.string.pref_user_name),name);
        editor.commit();

    }

    public  String read_name()

    {
        return  sharedPreferences.getString(context.getString(R.string.pref_user_name),"user");

    }

    public  void display_toast(String message)

    {
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
    }
}


