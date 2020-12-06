package esprit.tn.farmily;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class feed extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feed);

        Button profile = (Button) findViewById(R.id.profil_feed);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent proint = new Intent(getApplicationContext(),profile.class);
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
                Intent message = new Intent(getApplicationContext(),messages.class);
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

