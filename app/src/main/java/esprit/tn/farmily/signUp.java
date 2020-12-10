package esprit.tn.farmily;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import esprit.tn.farmily.entity.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class signUp extends AppCompatActivity {

    private ApiInterface apiInterface;
    Button postUSER ;
    EditText full_name, username, email,password,role;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        postUSER = findViewById(R.id.gotoProfile);
        full_name=findViewById(R.id.full_name);
        username=findViewById(R.id.username);
        email= findViewById(R.id.email);
        password=findViewById(R.id.password);
        role=findViewById(R.id.role);

        postUSER.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl("http://192.168.1.3:3000/api/user/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                    apiInterface = retrofit.create(ApiInterface.class);
                    User user = new User(full_name.getText().toString(),username.getText().toString(),email.getText().toString(),password.getText().toString(),role.getText().toString());
                    Call<User> call = apiInterface.sendUser(user);
                    call.enqueue(new Callback<User>() {
                        @Override
                        public void onResponse(Call<User> call, Response<User> response) {
                            handleSignUpDialog();
                            Intent gotoProfileIntent = new Intent(getApplicationContext(), profile.class);
                            startActivity(gotoProfileIntent);
                            overridePendingTransition(0,0);
                            gotoProfileIntent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                            finish();
                        }

                        @Override
                        public void onFailure(Call<User> call, Throwable t) {

                            Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();
                        }
                    });

                } catch (Exception e) {

                }

            }
        });
    }

    private void handleSignUpDialog() {
        View view=getLayoutInflater().inflate(R.layout.login, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this );
        builder.setView(view).show();
        EditText username= view.findViewById(R.id.username);
        EditText password= view.findViewById(R.id.password);
    }
}