package esprit.tn.farmily.Profile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import esprit.tn.farmily.R;
import esprit.tn.farmily.messages.MyMessageAdapter;
import esprit.tn.farmily.messages.MyMessageData;
import esprit.tn.farmily.messages.messages;


public class Myfiledsadapter extends  RecyclerView.Adapter<Myfiledsadapter.ViewHolder> {


    Myfiledsdata[] myfiledsdata;
    Context context ;
    public Myfiledsadapter(Myfiledsdata[] myfiledsdata, showfileds activity) {
        this.myfiledsdata = myfiledsdata ;
        this.context=activity;

    }

    @NonNull
    @Override

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view =  layoutInflater.inflate(R.layout.filed,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }



    @Override
    public void onBindViewHolder(@NonNull Myfiledsadapter.ViewHolder holder, int position) {

        final Myfiledsdata myMessageDataList = myfiledsdata [position];
        holder.texttitle.setText(myMessageDataList.getTitel());
        holder.progression.setText(myMessageDataList.getRemaining());
        holder.profilepic.setImageResource(myMessageDataList.getPhoto());
        holder.surface.setText(myMessageDataList.getSurface());


    }



    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView profilepic;
        TextView texttitle;
        TextView  progression ;
        TextView  surface ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            profilepic = itemView.findViewById(R.id.tsawer);
            texttitle = itemView.findViewById(R.id.type);
            progression= itemView.findViewById(R.id.progress);
            surface= itemView.findViewById(R.id.sutface);

        }
    }
}
