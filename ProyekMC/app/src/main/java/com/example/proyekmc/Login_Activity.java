package com.example.proyekmc;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Login_Activity extends AppCompatActivity {


    Button login;
    TextView pindahRegister;
    EditText edtUsername,edtPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = findViewById(R.id.button_login);
        pindahRegister = findViewById(R.id.textView_disiniLogin);

        edtUsername = findViewById(R.id.editText_user);
        edtPassword = findViewById(R.id.editText_pass);

        pindahRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(Login_Activity.this,Register_Activity.class);
                startActivity(mainIntent);
                finish();
            }
        });











    }

    public void buttonClick(View view) {
        StringRequest stringRequest = new StringRequest(
                //url yang di akses
                //method yang menghandle kembalian / response dari server
                Request.Method.POST,//tipe method pada web service (post/get)
                getResources().getString(R.string.url), //url yang di akses
                //method yang menghandle kembalian / response dari server

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println(response);


                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            int code= jsonObject.getInt("code");
                            String message = jsonObject.getString("message");
                            if(code == 1){
                                Intent mainIntent = new Intent(Login_Activity.this,MainActivity.class);
                                startActivity(mainIntent);
                                finish();
                            }
                            Toast.makeText(Login_Activity.this,message,Toast.LENGTH_SHORT).show();
                        }catch (JSONException e){
                            e.printStackTrace();
                        }

                        //JSONObject jsonObject = new JSONObject(response);
                    }
                },
                //method untuk kalau ada error
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println(error.getMessage());
                    }
                }

        ){
            //mengatur parameter yang akan dikirimkan ke webservice

            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("function","login");
                params.put("username",edtUsername.getText().toString());
                params.put("password",edtPassword.getText().toString());
                return params;


            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);// login activity.this
        requestQueue.add(stringRequest);


    }



}