package esprit.tn.farmily.Profile;

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

import java.util.List;

import esprit.tn.farmily.R;
import esprit.tn.farmily.feed.CommentAdapter;
import esprit.tn.farmily.feed.MyPostAdapter;
import esprit.tn.farmily.feed.com_display;
import esprit.tn.farmily.models.Engineer;
import esprit.tn.farmily.models.Post;
import esprit.tn.farmily.models.User;

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

        ImageView profilepic;
        TextView textViewname;
        TextView  textViewrole;
        Button Addeng ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            profilepic = itemView.findViewById(R.id.profileng);
            textViewname = itemView.findViewById(R.id.nameng);
            textViewrole= itemView.findViewById(R.id.roleeng);
            Addeng= itemView.findViewById((R.id.Addeng));
        }
    }
}

