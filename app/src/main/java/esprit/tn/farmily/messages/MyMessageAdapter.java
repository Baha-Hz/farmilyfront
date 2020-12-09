package esprit.tn.farmily.messages;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import esprit.tn.farmily.R;

public class MyMessageAdapter extends RecyclerView.Adapter<MyMessageAdapter.ViewHolder> {


    MyMessageData[] myMessageData ;
    Context context ;
    public MyMessageAdapter(MyMessageData[] myMessageData, messages activity) {
        this.myMessageData = myMessageData;
        this.context=activity;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view =  layoutInflater.inflate(R.layout.messagescard,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyMessageAdapter.ViewHolder holder, int position) {

        final MyMessageData myMessageDataList = myMessageData [position];
        holder.textViewname.setText(myMessageDataList.getSenderName());
        holder.textViewMessage.setText(myMessageDataList.getSenderMessage());
        holder.profilepic.setImageResource(myMessageDataList.getSenderPhoto());



    }

    @Override
    public int getItemCount() {
        return myMessageData.length ;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView profilepic;
        TextView textViewname;
        TextView  textViewMessage;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            profilepic = itemView.findViewById(R.id.profilepic_msg);
            textViewname = itemView.findViewById(R.id.Name_msg);
            textViewMessage= itemView.findViewById(R.id.message_content);



        }
    }




}
