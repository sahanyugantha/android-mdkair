package com.sahan.mdkbookings;

import com.sahan.mdkbookings.database.DashboardAsyncTask;
import com.sahan.mdkbookings.model.Dashboard;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class DashboardTest {



    @Test
    public void DBTest() throws ExecutionException, InterruptedException {
        DashboardAsyncTask asyncTask = new DashboardAsyncTask();
        List<Dashboard> actual = asyncTask.execute().get();

        Assert.assertNotEquals(null, actual);

    }
}
