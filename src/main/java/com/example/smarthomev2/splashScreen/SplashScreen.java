package com.example.smarthomev2.splashScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Toast;

import com.example.smarthomev2.MainActivity;
import com.example.smarthomev2.NetworkTools.CheckConnection;
import com.example.smarthomev2.R;
import com.example.smarthomev2.login.LoginActivity;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //тут проверки и переход на следующую страницу
        final Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.arg2 == 0) {
                    Toast toast = new Toast(getApplicationContext());
                    LayoutInflater inflater = getLayoutInflater();
                    View layout = inflater.inflate(R.layout.toast_network_disconnected, (ViewGroup)findViewById(R.id.toastNetworkDisconnected));
                    toast.setView(layout);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }

            }
        };
        //соединения нет
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    CheckConnection checkConnection = new CheckConnection(getApplicationContext());
                    while(true){
                        if(!checkConnection.isConnect()){
                            Message msg = new Message();
                            msg.arg2 = 0;
                            handler.sendMessage(msg);
                            Thread.sleep(2000);
                            Intent intent = new Intent(SplashScreen.this, ExitActivity.class);
                            startActivity(intent);
                            System.exit(0);
                        }
                    }
                }catch (Exception e){
                    Log.e("tag", e.getMessage());
                    System.exit(0);
                }


            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                CheckConnection checkConnection = new CheckConnection(getApplicationContext());

                if(checkConnection.isConnect()){
                    boolean isLogin = false;
                    //если логин есть

                    if(isLogin){
                        ///
                    }else{
                        //если его нет
                        Intent intent = new Intent(SplashScreen.this, LoginActivity.class);
                        startActivity(intent);
                    }

                }
            }
        }).start();


    }

}
