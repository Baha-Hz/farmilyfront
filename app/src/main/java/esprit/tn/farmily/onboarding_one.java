package esprit.tn.farmily;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class onboarding_one extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.onboarding_one);

        Button start = (Button)findViewById(R.id.button1_2);
        start.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent startIntent = new Intent(getApplicationContext(),onboarding_two.class);
                startActivity(startIntent);
                overridePendingTransition(0,0);
                startIntent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                finish();
            }
        });
        Button next = (Button)findViewById(R.id.btnext1);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next1 = new Intent(getApplicationContext(),onboarding_two.class);
                startActivity(next1);
                overridePendingTransition(0,0);
                next1.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                finish();
            }
        });
    }
}