package esprit.tn.farmily.feed;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import esprit.tn.farmily.R;
import esprit.tn.farmily.messages.MyMessageAdapter;
import esprit.tn.farmily.models.Comment;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder>  {

    public static List<Comment> commentsdata;
    public Context context ;
    public CommentAdapter (Context context , List<Comment> data) {
        this.context = context;
        this.commentsdata = data;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.comment_card, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder ;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.textViewuser.setText(commentsdata.get(position).getUsercomment());
        holder.textViewcom.setText(commentsdata.get(position).getBody());

    }

    @Override
    public int getItemCount() {
        return commentsdata.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewuser;
        TextView textViewcom;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            textViewuser = itemView.findViewById(R.id.usercompost);
            textViewcom= itemView.findViewById(R.id.combody);
        }
    }
}
