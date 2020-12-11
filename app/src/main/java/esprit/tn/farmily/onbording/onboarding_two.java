package esprit.tn.farmily.onbording;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import esprit.tn.farmily.R;

public class onboarding_two extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.onboarding_two);
        Button start2 = (Button)findViewById(R.id.button2_3);
        start2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent1 = new Intent(getApplicationContext(), onboarding_three.class);
                startActivity(startIntent1);
                overridePendingTransition(0,0);
                startIntent1.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                finish();
            }
        });
        Button start1 = (Button)findViewById(R.id.button2_1);
        start1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent2 = new Intent(getApplicationContext(), onboarding_one.class);
                startActivity(startIntent2);
                overridePendingTransition(0,0);
                startIntent2.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                finish();
            }
        });
        Button next = (Button)findViewById(R.id.butnext2);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(getApplicationContext(),onboarding_three.class);
                startActivity(next);
                overridePendingTransition(0,0);
                next.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                finish();
            }
        });
    }
}
