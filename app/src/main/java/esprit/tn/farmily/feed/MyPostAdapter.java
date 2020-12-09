package esprit.tn.farmily.feed;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import esprit.tn.farmily.R;

public class MyPostAdapter extends RecyclerView.Adapter<MyPostAdapter.ViewHolder> {

    MypostsData [] mypostsData ;
    Context context ;
    public MyPostAdapter(MypostsData[] mypostsData, feed activity) {
        this.mypostsData =mypostsData;
        this.context=activity;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view =  layoutInflater.inflate(R.layout.postscards,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final MypostsData mypostsDataList = mypostsData [position];
        holder.textViewname.setText(mypostsDataList.getPublisherName());
        holder.textViewrole.setText(mypostsDataList.getPublisherRole());
        holder.profilepic.setImageResource(mypostsDataList.getPublisherPhoto());
        holder.textViewpost.setText(mypostsDataList.getPublisherPost());


    }

    @Override
    public int getItemCount() {
        return mypostsData.length ;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
         ImageView profilepic;
         TextView  textViewname;
         TextView  textViewrole;
         TextView  textViewpost;
         ImageView comments;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            profilepic = itemView.findViewById(R.id.profilepic);
            textViewname = itemView.findViewById(R.id.Name);
            textViewrole= itemView.findViewById(R.id.role);
            textViewpost= itemView.findViewById(R.id.post);



        }
    }

}
