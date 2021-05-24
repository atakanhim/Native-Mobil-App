package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.io.IOException;
import java.io.InputStream;

import static java.lang.System.exit;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText usernameText = findViewById(R.id.editTextPersonName);
        EditText passwordText = findViewById(R.id.editTextPassword);
        CardView card_view = findViewById(R.id.CardView); // creating a CardView and assigning a value.
        TextView registerText = findViewById(R.id.textView3);
        card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String txt = "";
                try {
                    InputStream is = getAssets().open("UserData.txt");
                    int size =  is.available();
                    byte[] buffer = new byte[size];
                    is.read(buffer);
                    is.close();
                    txt = new String(buffer);
                    String strArray[] = txt.split(" ");

                    for(int i=0; i < strArray.length; i++) {
                            if(usernameText.getText().toString().equals(strArray[i]) && passwordText.getText().toString().equals(strArray[i+1])) {
                                Toast toast = Toast.makeText(getApplicationContext(),"Giriş Başarılı", Toast.LENGTH_SHORT);
                                toast.show();
                                Intent ii = new Intent(LoginActivity.this,MainActivity.class);
                                startActivity(ii);
                                finish();
                                exit(1);
                            }
                    }
                    Toast toast = Toast.makeText(getApplicationContext(),"Giriş Bilgilerinizi Kontrol Ediniz", Toast.LENGTH_SHORT);
                    toast.show();
                }
                catch (IOException ex){
                    Toast toast=Toast. makeText(getApplicationContext(),"Hata", Toast. LENGTH_SHORT);
                    toast.show();
                    finish();
                }
            }
        });
        /*registerText.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  Intent i = new Intent(LoginActivity.this,RegisterActivity.class);
                  startActivity(i);
              }
        });*/
    }
}