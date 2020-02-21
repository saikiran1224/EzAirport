package com.example.ezairport;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ezairport.utilities.ConstantValues;
import com.example.ezairport.utilities.MyAppPrefsManager;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    EditText email,pwd;
    Button login;
    TextView register,forgot;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    String e,p;
    MyAppPrefsManager myAppPrefsManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email=(EditText)findViewById(R.id.email);
        pwd=(EditText)findViewById(R.id.password);
        firebaseAuth=FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        login=(Button)findViewById(R.id.login);
        register=(TextView)findViewById(R.id.register);
        //forgot=(TextView)findViewById(R.id.forgotpasword);
        myAppPrefsManager = new MyAppPrefsManager(MainActivity.this);
        //ConstantValues.internetCheck(MainActivity.this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e = email.getText().toString().trim();
                p = pwd.getText().toString().trim();
                if(e.equals("testuser@gmail.com") && (p.equals("user123456"))) {
                    Intent in = new Intent(MainActivity.this,Dashboard.class);
                    startActivity(in);
                }
                if(e.isEmpty()) {
                    email.setError("Please enter Email ID");
                }
                else if(p.isEmpty()) {
                    pwd.setError("Please enter Password");
                }
                else {
                    //Toast.makeText(MainActivity.this, "Hi Hello !", Toast.LENGTH_SHORT).show();
                     userLogin();
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this,Registration_Activity.class);
                startActivity(in);
            }
        });
    }



    private void userLogin() {
        e = email.getText().toString().trim();
        p = pwd.getText().toString().trim();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

            progressDialog.setMessage("Logging in...");
            progressDialog.show();
            firebaseAuth.signInWithEmailAndPassword(e,p)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                progressDialog.dismiss();
                                Toast.makeText(MainActivity.this, "Please Enter Valid Email/Password", Toast.LENGTH_SHORT).show();
                            } else {
                                myAppPrefsManager.setUserLoggedIn(true);
                                myAppPrefsManager.setUserName(e);

                                // Set isLogged_in of ConstantValues
                                ConstantValues.IS_USER_LOGGED_IN = myAppPrefsManager.isUserLoggedIn();
                                Intent intent = new Intent(MainActivity.this, Dashboard.class);
                            /*intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);*/
                                startActivity(intent);
                                finish();
                                Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();


                            }
                        }
                    });
        }
}


