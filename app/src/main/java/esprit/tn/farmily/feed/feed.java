package esprit.tn.farmily.feed;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import esprit.tn.farmily.Networking.APIclient;
import esprit.tn.farmily.R;
import esprit.tn.farmily.messages.messages;
import esprit.tn.farmily.models.Post;
import esprit.tn.farmily.notification.notification;
import esprit.tn.farmily.utilities.CurrentSession;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class feed extends AppCompatActivity {

    String role ;
    TextView question,userpost,topic;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feed);

        RecyclerView recyclerView =findViewById(R.id.recyclerView);



        Call<List<Post>> showpostsCall = APIclient.apIinterface().getallPosts();
        showpostsCall.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if(!response.isSuccessful()){Log.d("FeedNet" ,toString());}

                    Log.d("feednet", response.body().get(0).getQuestion());

                    MyPostAdapter myAdapter = new MyPostAdapter(getApplicationContext(), response.body());
                    recyclerView.setAdapter(myAdapter);
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
                    layoutManager.setStackFromEnd(true);
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.scrollToPosition(0);



                }
                //Log.d("dfdfdfdf",posts.toString());



            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Log.d("FeedNet" , t.toString());
            }
        });

        Button addpost = (Button) findViewById(R.id.add_post);
        addpost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent post = new Intent(getApplicationContext(), esprit.tn.farmily.feed.AddPost.class);
                startActivity(post);
                overridePendingTransition(0,0);
                post.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                finish();
            }
        });
// bottembar navigation


     //   role=CurrentSession.CurrentUser.getRole().toString();

        Button profile = (Button) findViewById(R.id.profil_feed);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (CurrentSession.CurrentUser.getRole()) {
                    case "Farmer":
                        Intent proint = new Intent(getApplicationContext(), esprit.tn.farmily.Profile.profile.class);
                        startActivity(proint);
                        overridePendingTransition(0, 0);
                        proint.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        finish();
                        break;
                    case "Engineer":
                        Intent to = new Intent(getApplicationContext(), esprit.tn.farmily.Profile.profileeng.class);
                        startActivity(to);
                        overridePendingTransition(0, 0);
                        to.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        finish();
                        break;

                }
            }
        });

        Button message = (Button) findViewById(R.id.message_feed);
        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent message = new Intent(getApplicationContext(), messages.class);
                startActivity(message);
                overridePendingTransition(0,0);
                message.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                finish();

            }
        });
        Button notif = (Button) findViewById(R.id.notif_feed);
        notif.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent notif= new Intent(getApplicationContext(), notification.class);
                startActivity(notif);
                overridePendingTransition(0, 0);
                notif.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                finish();
            }
        });



    }


}

