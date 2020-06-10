package com.example.smarthomev2.login;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.example.smarthomev2.MainActivity;
import com.example.smarthomev2.R;
import com.example.smarthomev2.registration.RegistrationActivity;

public class LoginActivity extends AppCompatActivity {

    public EditText usernameEditText;
    public EditText passwordEditText;
    public Button loginButton;
    public Button registrationButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //проверка соединения сети




        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        loginButton = findViewById(R.id.login);
        registrationButton = findViewById(R.id.registration);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //тут мы отправляем данные на сервер

                //new LoginPostVerification().execute(new UrlsDataBase().urlVerification );
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });
        registrationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });
    }


}
