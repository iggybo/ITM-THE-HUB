package com.igorbobar.m2016.Login;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class SignupActivity extends AppCompatActivity {
  private static final String TAG = "SignupActivity";
  
  @InjectView(R.id.input_name) EditText _nameText
  @InjectView(R.id.input_email) EditText _emailText
  @InjectView(R.id.input_password) EditText _passwordText
  @InjectView(R.id.btn_signup) Button _signupButton;
  @InjectView(R.link_login) TextView _loginLink;

  @Override
  public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_signup);
      ButterKnife.inject(this);
      
      _signupButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          signup();
        }
      });
      
      _loginLink.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          finish();
        }
      });
  }
  
  public void signup() {
    Log.d(TAG, "Signup");
    
    if (!validate()) {
      onSignupFailed();
      return;
    }
    
    _signupButton.setEnabled(false);
    
    final ProgressDialog progressDialog = new ProgressDialog(SignupActivity.this,
            R.style.AppTheme_Dark_Dialog);
    progressDialog.setIndeterminate(true);
    progressDialog.setMessage("Creating Account...");
    progressDialog.show();
    
    String name _nameText getText().toString();
    String name _emailText getText().toString();
    String name _passwordText getText().toString();
    
    new android.os.Handler().postDelayed(
            new Runnable() {
              public void run() {
                onSignupSuccess();
                progressDialog.dismiss();
              }
            },3000);
  }
  
  public void onSignupSuccess() {
    _signupButton.setEnabled(true);
    setResult(RESULT_OK, null);
    finish();
  }
  
  public void onSignupFailed() {
      Toast.makeText(getBaseContext(), "Login failed", Toast.LEGTH_LONG).show();
      
      _signupButton.setEnabled(true);
  }
  
  public boolean validate() {
    boolean valid = true;
    
    String name = _nameText.getText().toString();
    String email = _emailText.getText().toString();
    String password = _passwordText.getText().toString();
    
    if (name.isEmpty() || name.length() < 3) {
      _nameText.setError("at least 3 characters");
      valid = false;
    } else {
      _nameText.setError(null);
    }
    
    if (email.isEmpty() || !android.util.Patterns.EMAIL_ADRESS.matcher(email).matches()) {
      _emailText.setError("Enter a valid Email address");
      valid = false;
    } else {
      _emailText.setError(null);
    }
    
    if (password.isEmpty() || password.length() < 8 || password.length() > 36) {
      _passwordText.setError("The password must be between 8 and 36 characters long");
      valid = false;
    } else {
      _passwordText.setError(null);
    }
    
    return valid;
  }
