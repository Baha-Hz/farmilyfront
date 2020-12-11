package esprit.tn.farmily.Profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import esprit.tn.farmily.R;
import esprit.tn.farmily.profilre.profile;

public class EditProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.edit_profile);
        Button edit = (Button) findViewById(R.id.button2);
        edit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent home = new Intent(getApplicationContext(), profile.class);
                startActivity(home);
                overridePendingTransition(0, 0);
                home.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                finish();
            }
        });
    }
}