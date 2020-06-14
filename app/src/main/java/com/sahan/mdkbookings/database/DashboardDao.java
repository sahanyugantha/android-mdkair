package com.sahan.mdkbookings.database;

import com.sahan.mdkbookings.model.Dashboard;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class DashboardDao {

    private static DashboardDao myInstance = new DashboardDao();;

    private DashboardDao() {
    }

    public static DashboardDao getInstance(){
        return myInstance;
    }

    public List<Dashboard> getAll(){

        List<Dashboard> dashboardList = new ArrayList<>();

        DashboardAsyncTask dashboardAsyncTask = new DashboardAsyncTask();
        try {
            dashboardList =  dashboardAsyncTask.execute().get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }


        return dashboardList;

    }
}
