
package esprit.tn.farmily;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.Override;
import java.lang.Exception;

import com.google.android.material.textfield.TextInputLayout;

import esprit.tn.farmily.entity.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class login extends AppCompatActivity {

    private ApiInterface apiInterface;
    EditText password;
    EditText username;
    Button checkUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        checkUser = findViewById(R.id.toProfile);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        checkUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl("http://192.168.1.4:3000/api/user/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                    apiInterface = retrofit.create(ApiInterface.class);
                    User user = new User(username.getText().toString(), password.getText().toString());
                    Call<User> call = apiInterface.LoginUser(user);
                    call.enqueue(new Callback<User>() {
                        @Override
                        public void onResponse(Call<User> call, Response<User> response) {
                            handleLoginDialog();
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

    private void handleLoginDialog() {

        View view=getLayoutInflater().inflate(R.layout.login, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this );
        builder.setView(view).show();
        EditText username= view.findViewById(R.id.username);
        EditText password= view.findViewById(R.id.password);
    }
}
