package esprit.tn.farmily.Profile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

import esprit.tn.farmily.Networking.APIclient;
import esprit.tn.farmily.R;
import esprit.tn.farmily.feed.CommentAdapter;
import esprit.tn.farmily.models.Engineer;
import esprit.tn.farmily.models.Hire;
import esprit.tn.farmily.utilities.CurrentSession;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Myengineer extends AppCompatActivity {
    TextView usename,current;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myengineer);


        usename = findViewById(R.id.EMP);
        current = findViewById(R.id.employer23);

        current.setText(CurrentSession.CurrentUser.getUsername());
        String employer = current.getText().toString();

        RecyclerView recyclerView =findViewById(R.id.recyclerView9);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        Call<List<Hire>> showEng = APIclient.apIinterface().Pending (employer);
        showEng.enqueue(new Callback<List<Hire>>() {
            @Override
            public void onResponse(Call<List<Hire>> call, Response<List<Hire>> response) {
                if(!response.isSuccessful()){
                    return;
                }

                pendingAdapter myAdapter = new pendingAdapter(getApplicationContext(), response.body());
                recyclerView.setAdapter(myAdapter);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
                layoutManager.setStackFromEnd(true);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.scrollToPosition(0);



            }

            @Override
            public void onFailure(Call<List<Hire>> call, Throwable t) {
            }
        });



    }
}
