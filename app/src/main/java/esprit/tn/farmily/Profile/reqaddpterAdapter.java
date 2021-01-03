package esprit.tn.farmily.Profile;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import esprit.tn.farmily.Networking.APIclient;
import esprit.tn.farmily.R;
import esprit.tn.farmily.feed.com_display;
import esprit.tn.farmily.feed.feed;
import esprit.tn.farmily.models.Hire;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class reqaddpterAdapter extends RecyclerView.Adapter<reqaddpterAdapter.ViewHolder> {

    public static List<Hire> REQ;
    public Context context;
    public reqaddpterAdapter(Context context, List<Hire> data) {
        this.context = context;
        this.REQ = data;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.hirereq, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder ;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.textViewname.setText(REQ.get(position).getEmployer());
        holder.id.setText(REQ.get(position).getId());
        String ID = holder.id.getText().toString();
        holder.accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<Hire> showEng = APIclient.apIinterface().acceptJob (ID);
                showEng.enqueue(new Callback<Hire>() {
                    @Override
                    public void onResponse(Call<Hire> call, Response<Hire> response) {
                        if(!response.isSuccessful()){
                            return;
                        }

                        Toast.makeText(holder.itemView.getContext(), "This is my Toast message!",
                                Toast.LENGTH_LONG).show();
                        holder.itemView.setVisibility(View.INVISIBLE);

                    }

                    @Override
                    public void onFailure(Call<Hire> call, Throwable t) {



                    }
                });

                Intent intent = new Intent(holder.itemView.getContext(), HIre_req.class);
                holder.itemView.getContext().startActivity(intent);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);



            }
        });







    }

    @Override
    public int getItemCount() {
        return REQ.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textViewname,id,sorry;
        Button accept ;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            textViewname = itemView.findViewById(R.id.EMPEE);
            sorry = itemView.findViewById(R.id.sorry);
            id = itemView.findViewById(R.id.id);
            accept =itemView.findViewById(R.id.accept);






        }
    }
}