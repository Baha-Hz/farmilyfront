package esprit.tn.farmily;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class messages extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.messages);
        Button profile = (Button) findViewById(R.id.profil_message);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profile = new Intent(getApplicationContext(),profile.class);
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
                Intent home = new Intent(getApplicationContext(),feed.class);
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