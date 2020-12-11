package esprit.tn.farmily.feed;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import esprit.tn.farmily.R;
import esprit.tn.farmily.messages.messages;
import esprit.tn.farmily.notification.notification;

public class feed extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feed);

        RecyclerView recyclerView =findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MypostsData[] mypostsData = new MypostsData[]{

                new MypostsData("Walid","farmer",R.drawable.walid,"asslema ya jme3a bellehy el zenbe3 win yetbe3"),
                new MypostsData("salah","engineer",R.drawable.salah,"famech tractor behy lel kre pour le mois de mars"),
                new MypostsData("Hamed","farmer",R.drawable.hamed,"wa9tech saison mta3 el toffe7 fi tounes ?"),
                new MypostsData("Riadh","farmer",R.drawable.riadh,"win nal9a zorri3a behya mta3 tomate cerise ?"),

        };
        MyPostAdapter myPostAdapter = new MyPostAdapter(mypostsData,feed.this);
        recyclerView.setAdapter(myPostAdapter);

        Button profile = (Button) findViewById(R.id.profil_feed);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent proint = new Intent(getApplicationContext(), esprit.tn.farmily.profilre.profile.class);
                startActivity(proint);
                overridePendingTransition(0,0);
                proint.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                finish();

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

