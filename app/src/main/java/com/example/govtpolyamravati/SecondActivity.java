package com.example.govtpolyamravati;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class SecondActivity extends AppCompatActivity{
    private EditText passwordEmail;
    private Button resetPassword;
    private FirebaseAuth firebaseAuth;
    private TextView login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        passwordEmail=(EditText)findViewById(R.id.etPasswordEmail);
        resetPassword=(Button)findViewById(R.id.btnResetPassword);
        firebaseAuth=FirebaseAuth.getInstance();
        login = (TextView) findViewById(R.id.tv2);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });


        resetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              String useremail = passwordEmail.getText().toString().trim();

                if (useremail.isEmpty()) {
                    passwordEmail.setError("Email is required");
                    passwordEmail.requestFocus();
                    return;
                }else {
                    firebaseAuth.sendPasswordResetEmail(useremail).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(SecondActivity.this, "Reset Password Email is send", Toast.LENGTH_SHORT).show();
                                finish();
                                startActivity(new Intent(SecondActivity.this,MainActivity.class));
                            }else {
                                Toast.makeText(SecondActivity.this, "Error in Sending Password Reset Email", Toast.LENGTH_SHORT).show();

                            }

                        }
                    });
                }
            }
        });
    }


}
