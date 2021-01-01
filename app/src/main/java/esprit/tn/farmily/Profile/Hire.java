package esprit.tn.farmily.Profile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import esprit.tn.farmily.Networking.APIclient;
import esprit.tn.farmily.R;
import esprit.tn.farmily.feed.com_display;
import esprit.tn.farmily.models.Engineer;
import esprit.tn.farmily.models.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Hire extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hire);

        RecyclerView recyclerView =findViewById(R.id.recyclerView5);



        Call<List<Engineer>> Show = APIclient.apIinterface().showeng("Engineer");
        Show.enqueue(new Callback<List<Engineer>>() {
            @Override
            public void onResponse(Call<List<Engineer>> call, Response<List<Engineer>> response) {
                if(!response.isSuccessful()){
                    Log.d("FeedNet" ,toString());}



                HireAdapter myAdapter = new HireAdapter(getApplicationContext(), response.body());
                recyclerView.setAdapter(myAdapter);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
                layoutManager.setStackFromEnd(true);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.scrollToPosition(0);



            }
            //Log.d("dfdfdfdf",posts.toString());



            @Override
            public void onFailure(Call<List<Engineer>> call, Throwable t) {
                Log.d("FeedNet1111" , t.toString());
            }
        });


    }




}