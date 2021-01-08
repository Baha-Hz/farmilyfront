package esprit.tn.farmily.messages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import esprit.tn.farmily.Profile.profile;
import esprit.tn.farmily.Profile.profile2;
import esprit.tn.farmily.R;
import esprit.tn.farmily.feed.feed;
import esprit.tn.farmily.notification.notification;
import esprit.tn.farmily.utilities.CurrentSession;

public class messages extends AppCompatActivity {
    String role ;
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
                new MyMessageData("Houda Jlassi","behy el jem3a hedhy na3mlou visite ",R.drawable.walid),
                new MyMessageData("Hend Touzri","manajamchnji nekhdem ghodoi ",R.drawable.walid),
                new MyMessageData("Walid Nasri","Wa9tech tabda el 7sida",R.drawable.hamed),
                new MyMessageData("Hamed Guizani","T7ebchi nkhaderlek el senya ?",R.drawable.faouzi),
                new MyMessageData("Kais Hannechi","hawka khalsin fe transport ",R.drawable.riadh),
                new MyMessageData("Neyla Jabri","wa9tech nokhless fel zorri3a",R.drawable.walid),

        };
        MyMessageAdapter myMessageAdapter = new MyMessageAdapter(myMessageData,messages.this);
        recyclerView.setAdapter(myMessageAdapter);



        role= CurrentSession.CurrentUser.getRole().toString();
        Button profile = (Button) findViewById(R.id.profil_message);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (role) {
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