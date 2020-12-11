package esprit.tn.farmily.notification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import esprit.tn.farmily.R;
import esprit.tn.farmily.feed.feed;
import esprit.tn.farmily.messages.messages;

public class notification extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification);
        Button profile = (Button) findViewById(R.id.profil_notif);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profile = new Intent(getApplicationContext(), esprit.tn.farmily.profilre.profile.class);
                startActivity(profile);
                overridePendingTransition(0,0);
                profile.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                finish();

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