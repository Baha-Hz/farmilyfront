package esprit.tn.farmily.feed;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

import esprit.tn.farmily.Networking.APIclient;
import esprit.tn.farmily.R;
import esprit.tn.farmily.models.Comment;
import esprit.tn.farmily.models.Notification;
import esprit.tn.farmily.models.Post;
import esprit.tn.farmily.utilities.CurrentSession;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class com_display extends AppCompatActivity {

    EditText comm ;
    Button send ;
    TextView user ,PostId,errorText,postowner ;
    Notification notification = new Notification();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comment);

        comm = findViewById(R.id.comm);
        user = findViewById(R.id.textView6);
        send = findViewById(R.id.send);
        postowner = findViewById(R.id.postowner);

        user.setText(CurrentSession.CurrentUser.getUsername());

        Intent intent = getIntent();
        String postid = intent.getStringExtra("Postid");
        postowner.setText(intent.getStringExtra("User"));
        PostId = findViewById(R.id.textView7);
        PostId.setText(postid);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addComment();



            }


        });






        RecyclerView recyclerView =findViewById(R.id.recyclerView2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        Call<List<Comment>> showpost = APIclient.apIinterface().getallPostcomment(postid);
        showpost.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                if(!response.isSuccessful()){
                    Log.d("FeedNet" ,toString());

                }

                //Comment.setPostid(textView.getText().toString());


                CommentAdapter myAdapter = new CommentAdapter(getApplicationContext(), response.body());
                recyclerView.setAdapter(myAdapter);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
                layoutManager.setStackFromEnd(true);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.scrollToPosition(0);



            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {

            }
            //Log.d("dfdfdfdf",posts.toString());




        });



    }

    private void addComment() {

        comm = findViewById(R.id.comm);
        user = findViewById(R.id.textView6);
        PostId = findViewById(R.id.textView7);
        errorText = findViewById(R.id.textView8);
        postowner = findViewById(R.id.postowner);

        Comment comment =new Comment();
        comment.setUsercomment(user.getText().toString());
        comment.setBody(comm.getText().toString());
        comment.setPostid(PostId.getText().toString());

        Call<Comment> addC = APIclient.apIinterface().addcomment(comment);
        addC.enqueue(new Callback<Comment>() {
            @Override
            public void onResponse(Call<Comment> call, Response<Comment> response) {
                if (response.isSuccessful()) {


                    Log.d("RegisterNet", String.valueOf(response.code()));
                    Toast.makeText(com_display.this, "New post Added", Toast.LENGTH_LONG).show();
                    Intent addnew = new Intent(com_display.this, feed.class);
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
            public void onFailure(Call<Comment> call, Throwable t) {

            }


        });

        notification.setProfileimage(CurrentSession.CurrentUser.getProfileimage());
        notification.setSender(CurrentSession.CurrentUser.getUsername());
        notification.setReceiver(postowner.getText().toString());
        notification.setAction(CurrentSession.CurrentUser.getUsername()+" commented on your Post");

        Call<Notification> addnotification = APIclient.apIinterface().addnotification(notification);
        addnotification.enqueue(new Callback <Notification>() {
            @Override
            public void onResponse(Call<Notification> call, Response<Notification> response) {

                Log.d("ezzab", String.valueOf(response));
            }

            @Override
            public void onFailure(Call<Notification> call, Throwable t) {
                Log.d("ezzab", "chfama");
            }


            //Log.d("dfdfdfdf",posts.toString());
        });



    }

}