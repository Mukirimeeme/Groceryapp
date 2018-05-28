package com.farm.mbaabu.grocery;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;



public class login_fragment extends Fragment {

private TextView RegText;


OnLoginFormActivityListener loginFormActivityListener;


public interface OnLoginFormActivityListener


{
    public void performRegister();
    public  void performLogin(String name);
}
    public login_fragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view= inflater.inflate(R.layout.fragment_login_fragment, container, false);
        RegText = view.findViewById(R.id.reg_btn);

        RegText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginFormActivityListener.performRegister();

            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity =(Activity) context;

        loginFormActivityListener=(OnLoginFormActivityListener) activity;
    }




    }

