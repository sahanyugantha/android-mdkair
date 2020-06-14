package com.sahan.mdkbookings.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sahan.mdkbookings.R;
import com.sahan.mdkbookings.adpater.HotDealsRecyclerViewAdapter;
import com.sahan.mdkbookings.database.DashboardAsyncTask;
import com.sahan.mdkbookings.database.DashboardDao;
import com.sahan.mdkbookings.model.Dashboard;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;


/**
 * A simple {@link Fragment} subclass.
 */
public class HotDealsFragment extends Fragment {

    public HotDealsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hot_deals, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rvDashboard);

        //Setup a layout manager.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(getResources().getDrawable(R.drawable.hotdeals_divider, getActivity().getTheme()));
        recyclerView.addItemDecoration(dividerItemDecoration);

        //Setup the adapter.
        List<Dashboard> dashboardList = DashboardDao.getInstance().getAll();
        HotDealsRecyclerViewAdapter adapter = new HotDealsRecyclerViewAdapter(getContext(), dashboardList);
        recyclerView.setAdapter(adapter);

        return view;
        
    }

    //Simulate Method DB transaction.
//    private List<Dashboard> getDashboardPosts(){
//        List<Dashboard> dashboardList = new ArrayList<>();
//
//        Dashboard dashboard1 = new Dashboard("Sri Lankan", "UL 306", "Doha", "2020-05-29");
//        dashboardList.add(dashboard1);
//        Dashboard dashboard2 = new Dashboard("Etihad", "ET8889u", "London", "2020-05-30");
//        dashboardList.add(dashboard2);
//        Dashboard dashboard3 = new Dashboard("Sri Lankan", "UL 306", "Doha", "2020-05-29");
//        dashboardList.add(dashboard3);
//        Dashboard dashboard4 = new Dashboard("Etihad", "ET8889u", "London", "2020-05-30");
//        dashboardList.add(dashboard4);
//
//        return dashboardList;
//    }
}
