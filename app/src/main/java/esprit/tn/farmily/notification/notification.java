package esprit.tn.farmily.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

import esprit.tn.farmily.Networking.APIclient;
import esprit.tn.farmily.Profile.NotficationAdapter;
import esprit.tn.farmily.Profile.Profiles.profileeng;
import esprit.tn.farmily.R;
import esprit.tn.farmily.feed.MyPostAdapter;
import esprit.tn.farmily.feed.feed;
import esprit.tn.farmily.messages.messages;
import esprit.tn.farmily.models.Notification;
import esprit.tn.farmily.utilities.CurrentSession;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import esprit.tn.farmily.models.Notification;

public class notification extends AppCompatActivity {
    String role ;
    RecyclerView rvc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification);
        //CurrentSession.CurrentUser.getRole().toString();
        rvc=findViewById(R.id.NotifRV);
        Call<List<Notification>> mynotifications = APIclient.apIinterface().mynotifications(CurrentSession.CurrentUser.getUsername());
        mynotifications.enqueue(new Callback<List<Notification>>() {
            @Override
            public void onResponse(Call<List<Notification>> call, Response<List<Notification>> response) {
                NotficationAdapter myAdapter = new NotficationAdapter(getApplicationContext(), response.body());
                rvc.setAdapter(myAdapter);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
                layoutManager.setStackFromEnd(true);
                rvc.setLayoutManager(layoutManager);
                rvc.scrollToPosition(0);
            }

            @Override
            public void onFailure(Call<List<Notification>> call, Throwable t) {

            }
        });

        Button profile = (Button) findViewById(R.id.profil_notif);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (CurrentSession.CurrentUser.getRole()) {
                    case "Farmer":
                        Intent proint = new Intent(getApplicationContext(), esprit.tn.farmily.Profile.Profiles.profile.class);
                        startActivity(proint);
                        overridePendingTransition(0, 0);
                        proint.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        finish();
                        break;
                    case "Engineer":
                        Intent to = new Intent(getApplicationContext(), profileeng.class);
                        startActivity(to);
                        overridePendingTransition(0, 0);
                        to.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        finish();
                        break;

                }

            }
        });
        Button home = (Button) findViewById(R.id.home_notif);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home = new Intent(getApplicationContext(), feed.class);
                startActivity(home);
                overridePendingTransition(0,0);
                home.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                finish();

            }
        });
        Button message = (Button) findViewById(R.id.message_notif);
        message.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent message= new Intent(getApplicationContext(), messages.class);
                startActivity(message);
                overridePendingTransition(0, 0);
                message.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                finish();
            }
        });
    }
}