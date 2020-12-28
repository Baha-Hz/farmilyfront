package esprit.tn.farmily.LoginrRegister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.lang.Override;

import esprit.tn.farmily.Networking.APIclient;
import esprit.tn.farmily.R;
import esprit.tn.farmily.feed.feed;
import esprit.tn.farmily.utilities.CurrentSession;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class login extends AppCompatActivity {


    EditText Username,Password;
    Button loginbutton;
    TextView signbutton;
    TextView loginError;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        //Initializing Views
        loginbutton = findViewById(R.id.toProfile);
        signbutton = findViewById(R.id.signUpText);

        //login Button onclick listener
        loginbutton.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginIn();
            }
        }));


        //Go to Register Activity
        signbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, signUp.class);
                startActivity(intent);
            }
        });
    }

    private void loginIn() {
        Username = findViewById(R.id.username);
        Password = findViewById(R.id.password);
        loginError = findViewById(R.id.loginError);


        String username = Username.getText().toString();
        String password = Password.getText().toString();
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        // doing the call
        Call<User> loginCall = APIclient.apIinterface().loginUser(user);
        loginCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()) {

                    Log.d("loginNet", "this is from loginresponse " + String.valueOf(response.body().getUsername()));
                    Toast.makeText(login.this, response.body().toString() ,Toast.LENGTH_SHORT).show();
                    assert response.body() != null;
                    loginError.setVisibility(View.INVISIBLE);

                    CurrentSession.CurrentUser = response.body();
                    Log.d("testCurrentUser","this is from currenuser: " +  CurrentSession.CurrentUser.getUsername());


                    Intent goMainNavAct = new Intent(login.this, feed.class);
                    startActivity(goMainNavAct);

                } else {
                    Log.d("loginNetF", "unsucc request");
                    loginError.setVisibility(View.VISIBLE);
                    try {
                        loginError.setText(response.errorBody().string());
                        Log.d("loginNetFF" ,"failed to string errorBody()");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.d("loginNet1" , t.toString());
            }
        });
    }
}





