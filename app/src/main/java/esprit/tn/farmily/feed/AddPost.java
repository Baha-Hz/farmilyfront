package esprit.tn.farmily.feed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import esprit.tn.farmily.LoginrRegister.User;
import esprit.tn.farmily.LoginrRegister.login;
import esprit.tn.farmily.LoginrRegister.signUp;
import esprit.tn.farmily.Networking.APIclient;
import esprit.tn.farmily.R;
import esprit.tn.farmily.models.Post;
import esprit.tn.farmily.utilities.CurrentSession;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddPost extends AppCompatActivity {
    EditText question ;
    TextView Username,Role,errorText;
    Button addbutton ;
    RadioGroup radioGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_post);
        Username = findViewById(R.id.User1);
        Role = findViewById(R.id.Role_1);
        addbutton = findViewById(R.id.newpost);
        Role.setText(CurrentSession.CurrentUser.getRole());
        Username.setText(CurrentSession.CurrentUser.getUsername());

        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addPost();
            }
        });

    }

    private void addPost() {

        Username = findViewById(R.id.User1);
        Role = findViewById(R.id.Role_1);
        question =findViewById(R.id.add_quest);
        radioGroup=findViewById(R.id.radiogr);
        errorText = findViewById(R.id.textView5);

        Post post = new Post();
        post.setUser(Username.getText().toString());
        post.setQuestion(question.getText().toString());

        int chekedId = radioGroup.getCheckedRadioButtonId();
        switch (chekedId) {
            case R.id.radioButton2:
                post.setTopic("Filed");
                break;
            case R.id.radioButton3:
                post.setTopic("Animals");
                break;
        }

        Call<Post> add = APIclient.apIinterface().addpost(post);
        add.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (response.isSuccessful()) {
                    Log.d("RegisterNet", String.valueOf(response.code()));
                    Toast.makeText(AddPost.this, "New post Added", Toast.LENGTH_LONG).show();
                    Intent addnew = new Intent(AddPost.this, feed.class);
                    startActivity(addnew);
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
            public void onFailure(Call<Post> call, Throwable t) {
                Log.d("RegisterNet", t.toString());
            }
        });





    }




}
