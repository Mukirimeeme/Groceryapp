package com.farm.mbaabu.grocery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements  login_fragment.OnLoginFormActivityListener{

    public static pref_config pref_config;
    public  static  Api_interface api_interface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pref_config= new pref_config(this);

        api_interface =Api_client.getApi_client().create(Api_interface.class);

        if (findViewById(R.id.fragment_container)!=null)

        {
            if(savedInstanceState!=null)
            {
                return;
            }
            if (pref_config.readlogin_status())

            {
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, new welcome_fragment()).commit();
            }
            else
            {
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, new login_fragment()).commit();
            }
        }


    }

    @Override
    public void performRegister()
    {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new register_fragment()).addToBackStack(null).commit();
    }

    @Override
    public void performLogin(String name) {


    }
}
