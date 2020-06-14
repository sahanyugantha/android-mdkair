package com.sahan.mdkbookings.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.sahan.mdkbookings.R;
import com.sahan.mdkbookings.adpater.DashboardBaseAdapter;
import com.sahan.mdkbookings.model.Dashboard;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment {

    public DashboardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        ListView listView = (ListView) view.findViewById(R.id.lvDashboard);
        List<Dashboard> dashboardList = getDashboardPosts();
        DashboardBaseAdapter dashboardBaseAdapter = new DashboardBaseAdapter(getContext(), dashboardList);

        listView.setAdapter(dashboardBaseAdapter);

        return view;
    }


    //Simulate Method DB transaction.
    private List<Dashboard> getDashboardPosts(){
        List<Dashboard> dashboardList = new ArrayList<>();

        Dashboard dashboard1 = new Dashboard("Sri Lankan", "UL 306", "Doha", "2020-05-29");
        dashboardList.add(dashboard1);
        Dashboard dashboard2 = new Dashboard("Etihad", "ET8889u", "London", "2020-05-30");
        dashboardList.add(dashboard2);
        Dashboard dashboard3 = new Dashboard("Sri Lankan", "UL 306", "Doha", "2020-05-29");
        dashboardList.add(dashboard3);
        Dashboard dashboard4 = new Dashboard("Etihad", "ET8889u", "London", "2020-05-30");
        dashboardList.add(dashboard4);

        return dashboardList;
    }

}
