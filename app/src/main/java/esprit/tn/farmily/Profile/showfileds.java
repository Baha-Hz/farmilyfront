package esprit.tn.farmily.Profile;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import esprit.tn.farmily.R;
import esprit.tn.farmily.messages.MyMessageAdapter;
import esprit.tn.farmily.messages.MyMessageData;
import esprit.tn.farmily.messages.messages;

public class showfileds extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myfileds);

        RecyclerView recyclerView =findViewById(R.id.recyclerView2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Myfiledsdata[] myfiledsdata = new Myfiledsdata[]{

                new Myfiledsdata("tomatos","60 day until recolt ",R.drawable.tomato,"1 Hectar"),
                new Myfiledsdata("potato","60 day until recolt ",R.drawable.potato,"1.5 Hectar"),
                new Myfiledsdata("eggplant","60 day until recolt ",R.drawable.eggplant,"0.5 Hectar"),

        };
        Myfiledsadapter myfiledsadapter = new Myfiledsadapter (myfiledsdata,showfileds.this);
        recyclerView.setAdapter(myfiledsadapter);


    }
}