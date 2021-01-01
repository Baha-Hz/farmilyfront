package esprit.tn.farmily.feed;

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
import esprit.tn.farmily.models.Post;

public class MyPostAdapter extends RecyclerView.Adapter<MyPostAdapter.ViewHolder>  {


    public static List<Post> postdata;
    public Context context ;
    public MyPostAdapter(Context context , List<Post> data) {
        this.context = context;
        this.postdata = data;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.postscards, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder ;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {



        holder.textViewname.setText(postdata.get(position).getUser());
        holder.textViewrole.setText(postdata.get(position).getTopic());
        String id = postdata.get(position).getId();
        //holder.profilepic.setImageResource(postUser.getProfileimage());
        holder.textViewpost.setText(postdata.get(position).getQuestion());
        holder.comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), com_display.class);
                intent.putExtra("Postid",id);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                holder.itemView.getContext().startActivity(intent);
            }
        });




    }

    @Override
    public int getItemCount() {
        return postdata.size() ;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView profilepic;
        TextView  textViewname;
        TextView  textViewrole;
        TextView  textViewpost;
        Button  comment ;
        // ImageView comments;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            profilepic = itemView.findViewById(R.id.profilepic);
            textViewname = itemView.findViewById(R.id.userpost);
            textViewrole= itemView.findViewById(R.id.topic);
            textViewpost= itemView.findViewById(R.id.Question);
            comment= itemView.findViewById((R.id.commentsButton));







        }


    }

}
