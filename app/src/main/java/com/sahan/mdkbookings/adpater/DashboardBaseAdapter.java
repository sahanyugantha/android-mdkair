package com.sahan.mdkbookings.adpater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.sahan.mdkbookings.model.Dashboard;
import com.sahan.mdkbookings.R;

import java.util.List;

public class DashboardBaseAdapter extends BaseAdapter {

    class MyViewHolder{
        TextView tvDestination;
        TextView tvDate;
        TextView tvTime;
        TextView tvFlightNo;
        Button btnBookNow;

        public MyViewHolder(View convertView){
            tvDestination = convertView.findViewById(R.id.tvDestination);
            tvDate = convertView.findViewById(R.id.tvDate);
            tvTime = convertView.findViewById(R.id.tvTime);
            tvFlightNo = convertView.findViewById(R.id.tvFlightNo);
            btnBookNow = convertView.findViewById(R.id.btnBookNow);
        }
    }

    private Context context;
    private List<Dashboard> dashboardList;

    public DashboardBaseAdapter(Context context, List<Dashboard> dashboardList) {
        this.context = context;
        this.dashboardList = dashboardList;
    }

    @Override
    public int getCount() {
        return dashboardList.size();
    }

    @Override
    public Object getItem(int position) {
        return dashboardList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.dashboard_list_row_item, parent, false);
        }

        final Dashboard dashboard = dashboardList.get(position);
        MyViewHolder myViewHolder = new MyViewHolder(convertView);

        myViewHolder.tvDestination.setText(dashboard.getTo());
        myViewHolder.tvFlightNo.setText(dashboard.getFlight_no());
        myViewHolder.tvTime.setText(dashboard.getTime());
        myViewHolder.tvDate.setText(dashboard.getTime());
        myViewHolder.btnBookNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "You clicked at : "+dashboard.getCompany(), Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }
}
