package esprit.tn.farmily.Profile;

import android.annotation.SuppressLint;
import android.content.Context;
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
import esprit.tn.farmily.R;
import esprit.tn.farmily.models.Notification;
import esprit.tn.farmily.utilities.CurrentSession;

public class NotficationAdapter extends RecyclerView.Adapter<NotficationAdapter.ViewHolder> {

    public static List<Notification> notifdata;
    public Context context ;


    public NotficationAdapter(Context context, List<Notification> data) {
        this.context = context;
        this.notifdata = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.notification_card, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textViewname.setText(notifdata.get(position).getSender());
        holder.textViewrole.setText(notifdata.get(position).getAction());
        Glide.with(context).load(APIclient.base_url+ notifdata.get(position).getProfileimage()).into(holder.profilepicture);
    }

    @Override
    public int getItemCount() {
        return notifdata.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView profilepicture;
        TextView textViewname;
        TextView  textViewrole;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            profilepicture = itemView.findViewById(R.id.profilepicture);
            textViewname = itemView.findViewById(R.id.Sender);
            textViewrole= itemView.findViewById(R.id.actiontxt);

        }
    }
}
