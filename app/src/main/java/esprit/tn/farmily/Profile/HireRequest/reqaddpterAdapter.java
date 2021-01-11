package esprit.tn.farmily.Profile.HireRequest;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import esprit.tn.farmily.Networking.APIclient;
import esprit.tn.farmily.R;
import esprit.tn.farmily.models.Hire;
import esprit.tn.farmily.models.Notification;
import esprit.tn.farmily.utilities.CurrentSession;
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
                Call<Hire> showEng = APIclient.apIinterface().acceptJob(ID);
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
                Notification notification= new Notification();
                notification.setProfileimage(CurrentSession.CurrentUser.getProfileimage());
                notification.setSender(CurrentSession.CurrentUser.getUsername());
                notification.setReceiver(REQ.get(position).getEmployer());
                notification.setAction(CurrentSession.CurrentUser.getUsername()+"Accepted your offer");
                Call<Notification> addnotification = APIclient.apIinterface().addnotification(notification);
                addnotification.enqueue(new Callback <Notification>() {
                    @Override
                    public void onResponse(Call<Notification> call, Response<Notification> response) {


                    }

                    @Override
                    public void onFailure(Call<Notification> call, Throwable t) {

                    }


                    //Log.d("dfdfdfdf",posts.toString());
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