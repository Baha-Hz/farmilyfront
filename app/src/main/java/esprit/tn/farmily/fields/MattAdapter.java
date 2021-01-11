package esprit.tn.farmily.fields;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import esprit.tn.farmily.R;

public class MattAdapter extends RecyclerView.Adapter<MattAdapter.CricketerView> {

    List<Material> cricketersList = new ArrayList<>();

    public MattAdapter(List<Material> cricketersList) {
        this.cricketersList = cricketersList;
    }

    @NonNull
    @Override
    public CricketerView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_cricketer2,parent,false);

        return new CricketerView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CricketerView holder, int position) {

        Material cricketer = cricketersList.get(position);
        holder.textCricketerName.setText(cricketer.getType());


    }

    @Override
    public int getItemCount() {
        return cricketersList.size();
    }

    public class CricketerView extends RecyclerView.ViewHolder{

        TextView textCricketerName;
        public CricketerView(@NonNull View itemView) {
            super(itemView);

            textCricketerName = (TextView)itemView.findViewById(R.id.text_cricketer_name2);


        }
    }

}