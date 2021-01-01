package esprit.tn.farmily.Profile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

import esprit.tn.farmily.LoginrRegister.User;
import esprit.tn.farmily.LoginrRegister.login;
import esprit.tn.farmily.LoginrRegister.signUp;
import esprit.tn.farmily.Networking.APIclient;
import esprit.tn.farmily.R;
import esprit.tn.farmily.feed.CommentAdapter;
import esprit.tn.farmily.feed.feed;
import esprit.tn.farmily.models.Comment;
import esprit.tn.farmily.models.Engineer;
import esprit.tn.farmily.models.Hire;
import esprit.tn.farmily.utilities.CurrentSession;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Detail extends AppCompatActivity {
    TextView usename,phone,fullname,email,current;
    Button hire,cv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);
        usename = findViewById(R.id.UsernameEng);
        phone = findViewById(R.id.phoneEng);
        fullname = findViewById(R.id.fullnameEng);
        current =findViewById(R.id.current);
        email = findViewById(R.id.emailEng);
        Intent intent = getIntent();
        String UserName = intent.getStringExtra("UserName");
        usename.setText(UserName);
        current.setText(CurrentSession.CurrentUser.getUsername());
        hire = findViewById(R.id.hire);
        hire.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hirenew();
            }
        }));



        Call<Engineer> showEng = APIclient.apIinterface().detail (UserName);
        showEng.enqueue(new Callback<Engineer>() {
            @Override
            public void onResponse(Call<Engineer> call, Response<Engineer> response) {
                if(!response.isSuccessful()){
                    return;
                }
                phone.setText(response.body().getPhone().toString());
                email.setText(response.body().getEmail().toString());
                fullname.setText(response.body().getFullname().toString());
            }

            @Override
            public void onFailure(Call<Engineer> call, Throwable t) {
            }
        });


    }

    private void hirenew() {
        usename = findViewById(R.id.UsernameEng);
        current = findViewById(R.id.current);


        String employee = usename.getText().toString();
        String employer = current.getText().toString();
        Hire hire = new Hire();
        hire.setEmployer(employer);
        hire.setEmployee(employee);

        // doing the call
        Call<Hire> loginCall = APIclient.apIinterface().Hire(hire);
        loginCall.enqueue(new Callback<Hire>() {
            @Override
            public void onResponse(Call<Hire> call, Response<Hire> response) {
                if(response.isSuccessful()) {

                    Toast.makeText(Detail.this, "Hire Request is Sent ", Toast.LENGTH_LONG).show();


                } else {

                    Toast.makeText(Detail.this, "Engineer is already Hired ", Toast.LENGTH_LONG).show();

                }
            }

            @Override
            public void onFailure(Call<Hire> call, Throwable t) {
                Log.d("loginNet1" , t.toString());
            }
        });

    }
}