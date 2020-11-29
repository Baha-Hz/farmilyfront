package esprit.tn.farmily;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class signUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        Button gotoProfile = (Button)findViewById(R.id.gotoProfile);
        gotoProfile.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {
                Intent gotoProfileIntent = new Intent(getApplicationContext(), profile.class);
                startActivity(gotoProfileIntent);
            }
        });

    }
}