package esprit.tn.farmily.fields;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;
import java.util.List;

import esprit.tn.farmily.Networking.APIclient;
import esprit.tn.farmily.R;
import esprit.tn.farmily.feed.MyPostAdapter;
import esprit.tn.farmily.feed.feed;
import esprit.tn.farmily.models.Comment;
import esprit.tn.farmily.models.Filedsmodel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FieldAdapter extends PagerAdapter {

    public static ArrayList<Filedsmodel> filed ;
    public Context context ;
    TextView display ;

    public FieldAdapter(Context context , ArrayList<Filedsmodel> filed) {
        this.context = context;
        this.filed = filed ;
    }

    @Override
    public int getCount() {
        return filed.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.filed_card,container,false);

        RecyclerView recyclerCricketers;
        RecyclerView recyclerMat;
        ImageView type_image = view.findViewById(R.id.type_image);
        TextView type_name = view.findViewById(R.id.type_name);
        TextView surface = view.findViewById(R.id.surface);
        TextView readyTime = view.findViewById(R.id.readyTime);



        Filedsmodel filedsmodel = filed.get(position);
        String type =(String) filedsmodel.getTypeName();
        String surf =filedsmodel.getDimensions().toString();
        String time =filedsmodel.getReadyTime().toString();
        List<Worker> cricketersList = filedsmodel.getWorker();
        List<Material> materials = filedsmodel.getMaterials();
        String id =filedsmodel.getId();
        Button DeleteField = view.findViewById(R.id.deletefiled);
        DeleteField.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<Filedsmodel> add = APIclient.apIinterface().delete(id);
                add.enqueue(new Callback<Filedsmodel>() {
                    @Override
                    public void onResponse(Call<Filedsmodel> call, Response<Filedsmodel> response) {
                        if (response.isSuccessful()) {
                            container.removeView(view);

                        } else {
                            Log.d("RegisterNet", "unsucc response");


                        }
                    }

                    @Override
                    public void onFailure(Call<Filedsmodel> call, Throwable t) {
                        Log.d("RegisterNet", t.toString());
                    }
                });





            }
        });
                recyclerCricketers = view.findViewById(R.id.recycler_cricketers);
        recyclerMat = view.findViewById(R.id.recycler_mat);

        LinearLayoutManager layoutManager = new LinearLayoutManager(context, RecyclerView.VERTICAL,false);
        recyclerCricketers.setLayoutManager(layoutManager);

        //cricketersList = (ArrayList<Worker>) getIntent().getExtras().getSerializable("list");

        recyclerCricketers.setAdapter(new CricketerAdapter(cricketersList));

        LinearLayoutManager layoutManager2 = new LinearLayoutManager(context, RecyclerView.VERTICAL,false);
        recyclerMat.setLayoutManager(layoutManager2);

        //cricketersList = (ArrayList<Worker>) getIntent().getExtras().getSerializable("list");

        recyclerMat.setAdapter(new MattAdapter(materials));






        type_name.setText(type);
        surface.setText(surf);
        readyTime.setText(time);

        switch (type) {
            case "Potato":
                type_image.setImageResource(R.drawable.potato);
                break;
            case "Tomato":
                type_image.setImageResource(R.drawable.tomato);
                break;
            case "Eggplant":
                type_image.setImageResource(R.drawable.eggplant);
                break;
        }

        container.addView(view,position);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }


}
