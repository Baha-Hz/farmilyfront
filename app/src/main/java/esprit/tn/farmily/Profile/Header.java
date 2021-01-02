package esprit.tn.farmily.Profile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import esprit.tn.farmily.R;
import esprit.tn.farmily.utilities.CurrentSession;

public class Header extends AppCompatActivity {
    TextView username,role;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.header_);
        role = findViewById(R.id.HeaderRole);
        username = findViewById(R.id.headeruser);

        role.setText("engineer");
        username.setText(CurrentSession.CurrentUser.getUsername());
    }
}