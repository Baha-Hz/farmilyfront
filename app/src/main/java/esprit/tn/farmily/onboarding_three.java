package esprit.tn.farmily;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class onboarding_three extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.onboarding_three);
        Button start3 = (Button)findViewById(R.id.button3_2);
        start3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent1 = new Intent(getApplicationContext(),onboarding_two.class);
                startActivity(startIntent1);
            }
        });
        Button start4 = (Button)findViewById(R.id.button3_1);
        start4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent2 = new Intent(getApplicationContext(),onboarding_one.class);
                startActivity(startIntent2);
            }
        });
        Button btnstart = (Button)findViewById(R.id.btnstart);
        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent welcome = new Intent(getApplicationContext(),getStarted.class);
                startActivity(welcome);
            }
        });

    }
}
