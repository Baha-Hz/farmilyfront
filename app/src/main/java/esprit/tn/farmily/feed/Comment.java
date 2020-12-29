package esprit.tn.farmily.feed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import esprit.tn.farmily.R;

public class Comment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comment);

        Intent intent = getIntent();
        String id = intent.getStringExtra("Postid");
        TextView textView =findViewById(R.id.idpost);
        textView.setText(id);
    }
}