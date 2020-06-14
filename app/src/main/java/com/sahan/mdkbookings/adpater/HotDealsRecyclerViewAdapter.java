package com.sahan.mdkbookings.adpater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sahan.mdkbookings.model.Dashboard;
import com.sahan.mdkbookings.R;

import java.util.List;

public class HotDealsRecyclerViewAdapter extends RecyclerView.Adapter<HotDealsRecyclerViewAdapter.MyViewHolder> {

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvDestination;
        TextView tvDate;
        TextView tvTime;
        TextView tvFlightNo;
        Button btnBookNow;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDestination = itemView.findViewById(R.id.tvDestinationHD);
            tvDate = itemView.findViewById(R.id.tvDateHD);
            tvTime = itemView.findViewById(R.id.tvTimeHD);
            tvFlightNo = itemView.findViewById(R.id.tvFlightNoHD);
            btnBookNow = itemView.findViewById(R.id.btnBookNowHD);
        }
    }

    private Context context;
    private List<Dashboard> dashboardList;

    public HotDealsRecyclerViewAdapter(Context context, List<Dashboard> dashboardList) {
        this.context = context;
        this.dashboardList = dashboardList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.hotdeals_list_row_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(itemView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Dashboard dashboard = dashboardList.get(position);


        holder.tvDestination.setText(dashboard.getTo());
        holder.tvFlightNo.setText(dashboard.getFlight_no());
        holder.tvTime.setText(dashboard.getTime());
        holder.tvDate.setText(dashboard.getTime());
        holder.btnBookNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dashboardList.size();
    }
}
