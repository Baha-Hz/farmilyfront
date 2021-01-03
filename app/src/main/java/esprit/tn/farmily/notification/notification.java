package esprit.tn.farmily.notification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import esprit.tn.farmily.Profile.profile;
import esprit.tn.farmily.Profile.profile2;
import esprit.tn.farmily.R;
import esprit.tn.farmily.feed.feed;
import esprit.tn.farmily.messages.messages;
import esprit.tn.farmily.utilities.CurrentSession;

public class notification extends AppCompatActivity {
    String role ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification);
        role= CurrentSession.CurrentUser.getRole().toString();

        Button profile = (Button) findViewById(R.id.profil_notif);
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