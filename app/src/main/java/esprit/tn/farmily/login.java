package esprit.tn.farmily;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);


        Button gotoFeed = (Button)findViewById(R.id.toLoginButton);
        gotoFeed.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {
                Intent gotoFeedIntent = new Intent(getApplicationContext(), feed.class);
                startActivity(gotoFeedIntent);
            }
        });
    }
}