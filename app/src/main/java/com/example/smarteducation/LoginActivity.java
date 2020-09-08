package com.example.smarteducation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    ImageView imageLogo;
    TextInputLayout textInputEnrollmentNo,textInputPassword;
    Button btnLogIn,btnForgetPassword;
    public static String UserEnrollmentNo,UserPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // hide top bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        imageLogo = findViewById(R.id.imageViewLogo);
        textInputEnrollmentNo = findViewById(R.id.inputLayoutEmailId);
        textInputPassword = findViewById(R.id.inputLayoutPassword);
        btnLogIn = findViewById(R.id.buttonLogIn);

        // User Confirm Login
        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmInput(v);
                Toast.makeText(LoginActivity.this,UserEnrollmentNo + " " + UserPassword, Toast.LENGTH_SHORT).show();
            }
        });

    }

    //This Function is Used for Email Validation
    private boolean validateUserEnrollmentNo()
    {
        String EnrollmentInput = textInputEnrollmentNo.getEditText().getText().toString().trim();

        if (EnrollmentInput.isEmpty())
        {
            textInputEnrollmentNo.setError("Field can't be Empty");
            return false;
        }
        else
        {
            textInputEnrollmentNo.setError(null);
            textInputEnrollmentNo.setErrorEnabled(false);
            return true;
        }
    }

    //This Function is Used for Password Validation
    private boolean validateUserPassword()
    {
        String  passwordInput = textInputPassword.getEditText().getText().toString().trim();
        if (passwordInput.isEmpty())
        {
            textInputPassword.setError("Field can't be Empty");
            return false;
        }
        else
        {
            textInputPassword.setError(null);
            textInputPassword.setErrorEnabled(false);
            return true;
        }
    }

    //This Function is Used for Confirm Store Value into final Variable
    public void confirmInput(View view)
    {
        if (!validateUserEnrollmentNo() | !validateUserPassword())
        {
            return;
        }
        UserEnrollmentNo = textInputEnrollmentNo.getEditText().getText().toString().trim();
        UserPassword = textInputPassword.getEditText().getText().toString().trim();
    }

    }