package com.example.proyekmc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Register_Activity extends AppCompatActivity {
    Button regist;
    TextView keLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        regist = findViewById(R.id.button_Register);
        keLogin = findViewById(R.id.textView_keLogin);
        keLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(Register_Activity.this,Login_Activity.class);
                startActivity(mainIntent);
                finish();
            }
        });

    }
}