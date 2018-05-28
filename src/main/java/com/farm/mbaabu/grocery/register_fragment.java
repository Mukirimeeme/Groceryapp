package com.farm.mbaabu.grocery;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.jar.Attributes;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class register_fragment extends Fragment {

    private EditText Name, UserName, Contact, Email, Password;

    private Button register_btn;

    public register_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register_fragment, container, false);

        Name = view.findViewById(R.id.name);
        UserName = view.findViewById(R.id.user_name);
        Contact = view.findViewById(R.id.contact);
        Email = view.findViewById(R.id.email);
        Password = view.findViewById(R.id.password);

        register_btn = view.findViewById(R.id.reg2_btn);


        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performRegistration();

            }
        });

        return view;
    }


    public void performRegistration()

    {
        String name = Name.getText().toString();

        String username = UserName.getText().toString();

        String contact = Contact.getText().toString();

        String email = Email.getText().toString();

        String password = Password.getText().toString();



        Call<User> call = MainActivity.api_interface.perform_registration(name, username, contact, email, password);


        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response)
            {
                if(response.body().getResponse().equals("ok"))
                {
                    MainActivity.pref_config.display_toast("Registration success...");
                }

                else if(response.body().getResponse().equals("Exist"))

                {
                    MainActivity.pref_config.display_toast("User already exist");
                }
                else if(response.body().getResponse().equals("Error"))

                {
                    MainActivity.pref_config.display_toast("Something went teribly wrong..");
                }

            }

            @Override
            public void onFailure(Call<User> call, Throwable t)
            {

            }
        });


        Name.setText("");
        UserName.setText("");
        Contact.setText("");
        Email.setText("");
        Password.setText("");
    }
}


