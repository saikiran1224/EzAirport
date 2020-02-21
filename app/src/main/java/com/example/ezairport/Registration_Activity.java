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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Registration_Activity extends AppCompatActivity {

    EditText name,email,pwd,cpwd,phone;
    Button submit;
    TextView login;
    String nam,em,pw,cpw,ph;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_);

        name=(EditText)findViewById(R.id.name);
        email=(EditText)findViewById(R.id.email);
        pwd=(EditText)findViewById(R.id.pwd);
        cpwd=(EditText)findViewById(R.id.cpwd);
        phone=(EditText)findViewById(R.id.phone);
        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog=new ProgressDialog(this);
        submit=(Button)findViewById(R.id.submit);

        login=(TextView)findViewById(R.id.login);

        this.setTitle("Registration Page");

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nam=name.getText().toString().trim();
                em=email.getText().toString().trim();
                pw=pwd.getText().toString().trim();
                cpw=cpwd.getText().toString().trim();
                ph=phone.getText().toString().trim();

                if(nam.isEmpty()) {
                    name.setError("Please enter Name ");
                }
                else if(em.isEmpty()) {
                    email.setError("Please enter Error");
                }
                else if(pw.isEmpty()) {
                    pwd.setError("Please enter Password");
                }
                else if(cpw.isEmpty()) {
                    cpwd.setError("Please enter Confirm Password");
                }
                else if(!pw.equals(cpw)) {
                    Toast.makeText(Registration_Activity.this, "Password and Confirm Password should be Same", Toast.LENGTH_SHORT).show();
                }
                else if(ph.isEmpty()) {
                    phone.setError("Please enter Phone Number");
                }
                else if(ph.length()<10) {
                    phone.setError("Phone Number is not Valid !");
                }
                else {
                    registerUser();
                    Intent intent = new Intent(Registration_Activity.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Registration_Activity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void registerUser() {
        em = email.getText().toString().trim();
        pw = pwd.getText().toString().trim();

        progressDialog.setMessage("Registering, Please Wait...");
        progressDialog.show();
        if (!em.isEmpty() && !pw.isEmpty()) {
            firebaseAuth.createUserWithEmailAndPassword(em,pw)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(Registration_Activity.this, "Successfully Signed Up !", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(Registration_Activity.this, "Registration Error!", Toast.LENGTH_LONG).show();
                            }
                            progressDialog.dismiss();
                        }
                    });
        }
    }
}
