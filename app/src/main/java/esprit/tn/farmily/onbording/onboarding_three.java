package esprit.tn.farmily.onbording;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import esprit.tn.farmily.R;

public class onboarding_three extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.onboarding_three);
        Button start3 = (Button)findViewById(R.id.button3_2);
        start3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent1 = new Intent(getApplicationContext(), onboarding_two.class);
                startActivity(startIntent1);
                finish();
            }
        });
        Button start4 = (Button)findViewById(R.id.button3_1);
        start4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent2 = new Intent(getApplicationContext(), onboarding_one.class);
                startActivity(startIntent2);
                overridePendingTransition(0,0);
                startIntent2.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                finish();
               
            }
        });
        Button start = (Button)findViewById(R.id.btnstart);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent welcome = new Intent(getApplicationContext(), getStarted.class);
                startActivity(welcome);
                overridePendingTransition(0,0);
                welcome.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                finish();
                
            }
        });

    }
}
