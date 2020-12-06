package esprit.tn.farmily;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class getStarted extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_started);
        Button sign = (Button)findViewById(R.id.buttonsignup);
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gosignup = new Intent(getApplicationContext(),signUp.class);
                startActivity(gosignup);
                overridePendingTransition(0,0);
                gosignup.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                finish();
            }
        });
        Button login = (Button)findViewById(R.id.toLoginButton);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gologin = new Intent(getApplicationContext(),login.class);
                startActivity(gologin);
                overridePendingTransition(0,0);
                gologin.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                finish();
            }
        });

    }
}
