package esprit.tn.farmily.Profile.hireEngineer;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import esprit.tn.farmily.Networking.APIclient;
import esprit.tn.farmily.Profile.MyEngineerDisplay.Detail;


import esprit.tn.farmily.R;
import esprit.tn.farmily.models.Engineer;



public class HireAdapter extends RecyclerView.Adapter<HireAdapter.ViewHolder> {

    public static List<Engineer> engdata;
    public Context context ;
    public HireAdapter(Context context , List<Engineer> data) {
        this.context = context;
        this.engdata = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(context);
            View view = inflater.inflate(R.layout.hire_carde, parent, false);
            ViewHolder viewHolder = new ViewHolder(view);
            return viewHolder ;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.textViewname.setText(engdata.get(position).getUsername());
        String User = engdata.get(position).getUsername();

        Glide.with(context).load(APIclient.base_url+ engdata.get(position).getProfileimage()).into(holder.profileng);
        holder.Addeng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), Detail.class);
                intent.putExtra("UserName",User);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                holder.itemView.getContext().startActivity(intent);
            }

        });



    }

    @Override
    public int getItemCount() {
        return engdata.size() ;}

    public class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView profileng;
        TextView textViewname;
        TextView  textViewrole;
        Button Addeng ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            profileng = itemView.findViewById(R.id.profileng);
            textViewname = itemView.findViewById(R.id.nameng);
            textViewrole= itemView.findViewById(R.id.roleeng);
            Addeng= itemView.findViewById((R.id.Addeng));
        }
    }
}

