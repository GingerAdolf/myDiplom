package com.example.smarthomev2.registration;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.smarthomev2.MainActivity;
import com.example.smarthomev2.NetworkTools.RegistrationOnServer;
import com.example.smarthomev2.R;
import com.example.smarthomev2.login.LoginActivity;

import java.io.IOException;
import java.net.MalformedURLException;

public class RegistrationActivity extends AppCompatActivity {
    private String email;
    private String password;
    private String confirmationPassword;

    private EditText editTextEmail;
    private EditText editTextPassword;
    private EditText editTextConfirmationPassword;
    private Button buttonRegistration;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        //получим данные из полей ввода
        buttonRegistration = findViewById(R.id.buttonRegistration);
        editTextEmail = findViewById(R.id.registrationEmail);
        editTextPassword = findViewById(R.id.registrationPassword1);
        editTextConfirmationPassword = findViewById(R.id.registrationPassword2);
        buttonRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isValidEmail(editTextEmail.getText().toString())){
                    showToast(R.string.register_error_email);
                } else if (!isValidPassword(editTextPassword.getText().toString(), editTextConfirmationPassword.getText().toString())){
                    showToast( R.string.register_error_password);
                } else {
                   //отправляем данные на сервер
                   // new Runnable()
                    Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });

    }

    public static boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }
    public static boolean isValidPassword(CharSequence target1, CharSequence target2) {
        return !TextUtils.isEmpty(target1) && !TextUtils.isEmpty(target2) && TextUtils.equals(target1, target2);
    }
    public void showToast(int string){
        Toast toast = Toast.makeText(getApplicationContext(), string,Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
    public void showToast(String string){
        Toast toast = Toast.makeText(getApplicationContext(), string,Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

}
