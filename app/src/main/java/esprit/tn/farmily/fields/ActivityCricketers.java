package esprit.tn.farmily.fields;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import esprit.tn.farmily.R;



public class ActivityCricketers extends AppCompatActivity {

    RecyclerView recyclerCricketers;
    ArrayList<Worker> cricketersList = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cricketers);

        recyclerCricketers = findViewById(R.id.recycler_cricketers);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerCricketers.setLayoutManager(layoutManager);

        //cricketersList = (ArrayList<Worker>) getIntent().getExtras().getSerializable("list");

        recyclerCricketers.setAdapter(new CricketerAdapter(cricketersList));

    }
}
