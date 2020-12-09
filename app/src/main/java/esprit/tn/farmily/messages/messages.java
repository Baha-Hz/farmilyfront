package esprit.tn.farmily.messages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import esprit.tn.farmily.R;
import esprit.tn.farmily.feed.MyPostAdapter;
import esprit.tn.farmily.feed.MypostsData;
import esprit.tn.farmily.feed.feed;
import esprit.tn.farmily.notification;
import esprit.tn.farmily.profile;

public class messages extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.messages);


        RecyclerView recyclerView =findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MyMessageData[] myMessageData = new MyMessageData[]{

                new MyMessageData("Amir Aissaoui","Aslema khouya enty eli 3andek El batata ",R.drawable.walid),
                new MyMessageData("Salah Zelfani","3la 9adech el 3jel",R.drawable.salah),
                new MyMessageData("Houda Jlassi","behy el jem3a hedhy na3mlou visite ",R.drawable.houda),
                new MyMessageData("Hend Touzri","manajamchnji nekhdem ghodoi ",R.drawable.hend),
                new MyMessageData("Walid Nasri","Wa9tech tabda el 7sida",R.drawable.hamed),
                new MyMessageData("Hamed Guizani","T7ebchi nkhaderlek el senya ?",R.drawable.faouzi),
                new MyMessageData("Kais Hannechi","hawka khalsin fe transport ",R.drawable.riadh),
                new MyMessageData("Neyla Jabri","wa9tech nokhless fel zorri3a",R.drawable.neila),

        };
        MyMessageAdapter myMessageAdapter = new MyMessageAdapter(myMessageData,messages.this);
        recyclerView.setAdapter(myMessageAdapter);




        Button profile = (Button) findViewById(R.id.profil_message);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profile = new Intent(getApplicationContext(), esprit.tn.farmily.profile.class);
                startActivity(profile);
                overridePendingTransition(0,0);
                profile.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                finish();

            }
        });
        Button home = (Button) findViewById(R.id.home_message);
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
        Button notif = (Button) findViewById(R.id.notif_message);
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