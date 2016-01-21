import java.util.Scanner;

public class LoginActivity extends AsyncTask <Integer, String[]> {
   
   @Override
   protected void onCreate(Bundle savedInstanceState) {
      GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
               .requestEmail().build();
      mGoogleApiClient = new GoogleApiClient.Builder(this)
               .enableAutoManage(this, this)
               .build();
               
   
   }
  
}
