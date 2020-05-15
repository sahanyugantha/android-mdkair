package com.sahan.mdkbookings.database;

import com.sahan.mdkbookings.Dashboard;

import java.util.ArrayList;
import java.util.List;

public class DashboardDao {

    public DashboardDao() {
    }

    public List<Dashboard> getAll(){

        List<Dashboard> dashboardList = new ArrayList<>();

        Dashboard dashboard1 = new Dashboard(1, "Sri Lankan", "UL 309", "Departure", "CMB", "WHN", "2020-05-15 11:30:00");
        dashboardList.add(dashboard1);
        Dashboard dashboard2 = new Dashboard(1, "Emirate", "EM 2333", "Transit", "DOHA", "MLBN", "2020-05-15 11:50:00");
        dashboardList.add(dashboard2);

        return dashboardList;

    }
}
