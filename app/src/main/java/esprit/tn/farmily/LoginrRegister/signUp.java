package esprit.tn.farmily.LoginrRegister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import esprit.tn.farmily.Networking.APIclient;
import esprit.tn.farmily.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class signUp extends AppCompatActivity {

    EditText full_name,username,password,email,role;
    Button signUpButton;
    TextView goLoginButton;
    TextView errorText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        signUpButton = findViewById(R.id.gotoProfile);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });
    }

    private void signIn(){

        // Initializing elements
        full_name = findViewById(R.id.full_name);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        email = findViewById(R.id.email);
        role = findViewById(R.id.role);
        signUpButton = findViewById(R.id.gotoProfile);
        goLoginButton = findViewById(R.id.loginText);
        errorText = findViewById(R.id.errorText);

        User user = new User();
        user.setFullname(full_name.getText().toString());
        user.setUsername(username.getText().toString());
        user.setEmail(email.getText().toString());
        user.setPassword(password.getText().toString());
        user.setRole(role.getText().toString());

        // doing the call
        Call<User> register = APIclient.apIinterface().registerUser(user);
        register.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    Log.d("RegisterNet", String.valueOf(response.code()));
                    Toast.makeText(signUp.this, "Successfully Registered!", Toast.LENGTH_LONG).show();
                    Intent goProfile = new Intent(signUp.this, login.class);
                    startActivity(goProfile);
                } else {
                    Log.d("RegisterNet", "unsucc response");
                    errorText.setVisibility(View.VISIBLE);
                    try {
                        errorText.setText(response.errorBody().string());
                    } catch (IOException e) {
                        Log.d("RegisterNet", "failed to string errorBody()");
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.d("RegisterNet", t.toString());
            }
        });




    }

}