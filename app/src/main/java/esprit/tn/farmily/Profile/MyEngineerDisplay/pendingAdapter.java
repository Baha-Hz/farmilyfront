package esprit.tn.farmily.Profile.MyEngineerDisplay;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import esprit.tn.farmily.R;
import esprit.tn.farmily.models.Hire;

public class pendingAdapter extends RecyclerView.Adapter<pendingAdapter.ViewHolder> {

    public static List<Hire> engdata;
    public Context context;
    public pendingAdapter(Context context, List<Hire> data) {
        this.context = context;
        this.engdata = data;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.engcard, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder ;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.textViewname.setText(engdata.get(position).getEmployee());


        switch (engdata.get(position).getState().toString())
        {
            case "true" :
                holder.pendingimage.setImageResource(R.drawable.hired);
                holder.status.setText("Hired");
            break;

            case "false" :
                holder.pendingimage.setImageResource(R.drawable.pending);
                holder.status.setText("pending");
        }




    }

    @Override
    public int getItemCount() {
        return engdata.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView pendingimage;
        TextView textViewname,status;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            textViewname = itemView.findViewById(R.id.EMP);
            status = itemView.findViewById(R.id.status);
            String stat = status.getText().toString()  ;
            pendingimage =itemView.findViewById(R.id.imagestatus);



        }
    }
}