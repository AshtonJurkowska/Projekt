package com.example.projektaplikacji;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    EditText email;
    EditText password;
    Button loginButton;
    Button signUp;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        editTextEmail = findViewById(R.id.email);
        editTextPassword = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);
        signUp = findViewById(R.id.signupText);

        singUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Regsister.class);
                startActivity(intent);
                finish();
            }
        }){

        loginButton.setOnClickListener(new View.OnClickListener(){
                @Override
                        public void onClick(View v) {
                    String email, password;
                    email = String.valueOf(editTextEmail.getText());
                    password = String.valueOf(editTextPassword.getText());

                    if(TextUtils.isEmpty(email)){
                        Toast.makeText(Login.this, "Enter Email", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if(TextUtils.isEmpty(password)) {
                        Toast.makeText(Login.this, "Enter Password ", Toast.LENGTH_SHORT).show();
                        return;
                    }

                firebaseAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new MediaPlayer.OnSeekCompleteListener<AuthResult> task){
                            @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccesfull()){
                                        Toast.makeText(Login.this, "Login Succesful", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(Login.this, Register.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                    else{
                                        Toast.makeText(Login.this, "Authorisation Failed", Toast.LENGTH_SHORT).show();
                                    }
                    }
                }
            }
        });
    }
}