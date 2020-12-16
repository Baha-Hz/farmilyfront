package esprit.tn.farmily.Profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.io.IOException;

import esprit.tn.farmily.LoginrRegister.User;
import esprit.tn.farmily.LoginrRegister.login;
import esprit.tn.farmily.LoginrRegister.signUp;
import esprit.tn.farmily.Networking.APIclient;
import esprit.tn.farmily.R;
import esprit.tn.farmily.utilities.CurrentSession;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditProfile extends AppCompatActivity {


    EditText full_name,password,email,phone;
    ImageView profileimage;
    TextView errorText;
    Button edit;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.edit_profile);
        edit = (Button) findViewById(R.id.button2);





        edit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent home = new Intent(getApplicationContext(), profile.class);
                startActivity(home);
                overridePendingTransition(0, 0);
                home.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                finish();
            }
        });

        Button update = (Button) findViewById(R.id.confirm);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateUser();
            }
        });



    }

    private void updateUser() {
        full_name = findViewById(R.id.fullnameiput);
        password = findViewById(R.id.passwordinput);
        email = findViewById(R.id.Emailinput);
        phone = findViewById(R.id.phoneinput);
        profileimage= findViewById(R.id.profileimage);





        User user = new User();
        user.setUsername(CurrentSession.CurrentUser.getUsername());
        user.setFullname(full_name.getText().toString());
        user.setEmail(email.getText().toString());
        user.setPassword(password.getText().toString());
        try{
            user.setPhone((Integer.parseInt(phone.getText().toString())));
        } catch(NumberFormatException ex){ // handle your exception
            ex.printStackTrace();
        }
        user.setProfileimage("/uploads/sponge_homer.jpg");

        // doing the call
        Call<User> edit = APIclient.apIinterface().editProfile(user);
        edit.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    Log.d("edit", String.valueOf(response.body().getUsername()));
                    Toast.makeText(EditProfile.this, "Successfully Changed!", Toast.LENGTH_LONG).show();
                    Intent goProfile = new Intent(EditProfile.this, profile.class);
                    startActivity(goProfile);
                    CurrentSession.CurrentUser = response.body();
                } else {
                    Log.d("edit", "unsucc response");
                    errorText.setVisibility(View.VISIBLE);
                    try {
                        errorText.setText(response.errorBody().string());
                    } catch (IOException e) {
                        Log.d("edit", "failed to string errorBody()");
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.d("editNet", t.toString());
            }
        });


    }
}