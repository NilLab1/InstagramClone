package com.example.instagramclone;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUpActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";
    private EditText etnUsername;
    private EditText etnPassword;
    private EditText etEmail;
    private Button btnCreate;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_page);


        etnUsername = findViewById(R.id.etnUsername);
        etnPassword = findViewById(R.id.etnPassword);
        etEmail = findViewById(R.id.etnEmail);
        btnCreate = findViewById(R.id.btnCreate);

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Create the ParseUser
                ParseUser user = new ParseUser();
                // Set core properties
                user.setUsername(etnUsername.getText().toString());
                user.setPassword(etnPassword.getText().toString());
                user.setEmail(etEmail.getText().toString());
                // Invoke signUpInBackground
                user.signUpInBackground(new SignUpCallback() {
                    public void done(ParseException e) {
                        if (e == null) {
                            // Hooray! Let them use the app now.
                            loginUser(etnUsername.getText().toString(), etnPassword.getText().toString());
                        } else {
                            // Sign up didn't succeed. Look at the ParseException
                            // to figure out what went wrong
                            Toast.makeText(SignUpActivity.this, "Unable to create account with given information!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


            }
        });

    }

    private void loginUser(String username, String password) {
        Log.i(TAG, "Attempting to login user " + username);
        ParseUser.logInInBackground(username, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (e != null){
                    Log.e(TAG, "Issue with login", e);
                    return;
                }
                Toast.makeText(SignUpActivity.this, "Account Successfullly Created", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(SignUpActivity.this, MainActivity.class);
                startActivity(i);


            }

        });
    }

}
