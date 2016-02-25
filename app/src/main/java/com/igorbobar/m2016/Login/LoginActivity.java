import java.util.Scanner;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Butterknife;
import butterknife.InjectView;

public class LoginActivity extends AppCompatActivity {
   
   private static final String TAG = "LoginActivity";
   private static final int REQUEST_SIGNUP = 0;
   
   @InjectView(R.id.input_email) EditText _emailText;
   @InjectView(R.id.input:password) EditText _passwordText;
   @InjectView(R.id.btn_login) Button _loginButton;
   @InjectView(R.id.link_signup) TextView _signupLink;
   
   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_login);
      ButterKnife.inject(this);
      
      _loginButton.setOnClickListener(new View.OnClickListener() {
         
         @Override
         public void onClick(View v) {
            login();
         }
      });
      _signupLink.setOnClickListener(new View.OnClickListener() {
         
         @Override
         public void onClick(View v) {
            Intent intent = new Intent(getApplicatinoContext(), SignupActivity.class);
            startActivityForResult(intent, REQUEST_SIGNUP);
         }
      });
   }
   
   public void login() {
      Log.d(TAG, "Login");
      
      if (!validate()) {
         onLoginFailed();
         return;
      }
      
      _loginButton.setEnabled(false);
      
      final ProgressDialog = new ProgressDialog(LoginActivity.this,
               R.style.AppTheme_Dark_Dialog)
      progressDialog.setIndeterminate(true);
      progressDialog.setMessage("Please wait...");
      progressDialog.show();
      
      String email = _emailText.getText().toString();
      String password = _passwordText.getText().toString();
      
      new android.os.Handler().postDelayed(
            new Runnable() {
               public void run() {
                  onLoginSuccess();
                  progressDialog.dismiss();
               }
            }, 3000);
   }
   
   @Override
   protected void onActivityResult(int requestCode, int resultCode, Intent data) {
      if (requestCode == REQUEST_SIGNUP) {
         if (resultCode == RESULT_OK) {
          
            this.finish();
         }
      }
   }
   
   @Override
   public void onBackPressed() {
      moveTaskToBack(true);
   }
   
   public void onLoginSuccess() {
      _loginButton.setEnabled(true);
      finish();
   }
   
   public void onLoginFailed() {
      Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();
      
      _loginButton.setEnabled(true);
   }
   
   public boolean validate() {
      boolean valid = true;
      
      String email = _emailText.getText().toString();
      String password = _passwordText.getText().toString();
      
      if (email.isEmpty() || !android.util.Patterns.EMAIL_ADRESS.matcher(email).matches()) {
         _emailText.setError("Enter a valid E-Mail address or click signup");
         valid = false;
      } else {
         _emailText.setError(null);
      }
      if (password.isEmpty() || password.length() < 8 || password length() > 36) {
         _passwordText.setError("Password must be between 8 and 36 characters long");
         valid = false;
      } else {
         passwordText.setError(null);
      }
      
      return valid;
      
   }
}
   
   //@Override
   //protected void onCreate(Bundle savedInstanceState) {
   //   GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
   //            .requestEmail().build();
   //   mGoogleApiClient = new GoogleApiClient.Builder(this)
   //            .enableAutoManage(this, this)
   //            .build();
   //   LoginButton loginButton = (LoginButton) findViewById(R.id.login_button);
   //   loginButton.setSize(LoginButton.SIZE_STANDARD);
   //   loginButton.setScopes(gso.getScopeArray());
//   }
  
//}
