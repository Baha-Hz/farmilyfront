package esprit.tn.farmily.fields;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import esprit.tn.farmily.Networking.APIclient;
import esprit.tn.farmily.R;
import esprit.tn.farmily.feed.CommentAdapter;
import esprit.tn.farmily.models.Comment;
import esprit.tn.farmily.models.Filedsmodel;
import esprit.tn.farmily.utilities.CurrentSession;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyFields extends AppCompatActivity {

    public ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myfileds);

        viewPager =findViewById(R.id.viewPager);




        Call<ArrayList<Filedsmodel>> showfield = APIclient.apIinterface().getuserFields(CurrentSession.CurrentUser.getUsername().toString());
        showfield.enqueue(new Callback<ArrayList<Filedsmodel>>() {
            @Override
            public void onResponse(Call<ArrayList<Filedsmodel>> call, Response<ArrayList<Filedsmodel>> response) {
                if(!response.isSuccessful()){
                    Log.d("FeedNet" ,toString());

                }

                //Comment.setPostid(textView.getText().toString());


                FieldAdapter myAdapter = new FieldAdapter(getApplicationContext(), response.body());
                viewPager.setAdapter(myAdapter);
                viewPager.setPadding(20,80,20,20);
                viewPager.setPageMargin(90);





            }

            @Override
            public void onFailure(Call<ArrayList<Filedsmodel>> call, Throwable t) {

            }
            //Log.d("dfdfdfdf",posts.toString());




        });



    }


}