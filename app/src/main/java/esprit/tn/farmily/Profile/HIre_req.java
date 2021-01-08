package esprit.tn.farmily.Profile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

import esprit.tn.farmily.Networking.APIclient;
import esprit.tn.farmily.R;
import esprit.tn.farmily.models.Hire;
import esprit.tn.farmily.utilities.CurrentSession;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HIre_req extends AppCompatActivity {
    TextView current;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h_ire_req);



        current = findViewById(R.id.employer23);

        current.setText(CurrentSession.CurrentUser.getUsername());
        String employee = current.getText().toString();


        RecyclerView recyclerView =findViewById(R.id.recyclerView12);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        Call<List<Hire>> showEng = APIclient.apIinterface().EngPending(employee);
        showEng.enqueue(new Callback<List<Hire>>() {
            @Override
            public void onResponse(Call<List<Hire>> call, Response<List<Hire>> response) {
                if(!response.isSuccessful()){
                    return;
                }

                reqaddpterAdapter myAdapter = new reqaddpterAdapter(getApplicationContext(), response.body());
                recyclerView.setAdapter(myAdapter);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
                layoutManager.setStackFromEnd(true);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.scrollToPosition(0);
                myAdapter.notifyDataSetChanged();



            }

            @Override
            public void onFailure(Call<List<Hire>> call, Throwable t) {
            }
        });



    }
}
