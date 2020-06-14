package com.sahan.mdkbookings.database;

import android.os.AsyncTask;
import android.util.Log;

import com.sahan.mdkbookings.model.Dashboard;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class DashboardAsyncTask extends AsyncTask<Void,Void, List<Dashboard>> {

    private static final String TAG = "dashTag";
    private static final String API_URL = "http://10.0.2.2/api/postsapi.php";

    @Override
    protected List<Dashboard> doInBackground(Void... voids) {
        List<Dashboard> dashboardList = new ArrayList<Dashboard>();

        try{
            URL url = new URL(API_URL);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(1000*5);
            httpURLConnection.setReadTimeout(1000*5);
            httpURLConnection.setDoOutput(false); //no uploads
            httpURLConnection.setDoInput(true); // yes downloads

            if(httpURLConnection.getResponseCode() == 200){

                InputStream inputStream = httpURLConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String line;
                StringBuilder sb = new StringBuilder();

                while ((line = bufferedReader.readLine()) != null){
                    sb.append(line);
                }

                JSONArray jsonArray = new JSONArray(sb.toString());

                for(int i = 0; i < jsonArray.length(); i++){

                    JSONObject obj = jsonArray.getJSONObject(i);

                    Dashboard dashboard = new Dashboard();

                    dashboard.setId(obj.getInt("id"));
                    dashboard.setCompany(obj.getString("company"));
                    dashboard.setFlight_no(obj.getString("flight_no"));
                    dashboard.setFrom(obj.getString("from"));
                    dashboard.setTo(obj.getString("to"));
                    dashboard.setTime(obj.getString("time"));
                    dashboard.setType(obj.getString("type"));

                    dashboardList.add(dashboard);
                }

                Log.i(TAG, "JSON DATA : "+sb.toString());

            } else {
                Log.i(TAG, "HTTP CODE : "+httpURLConnection.getResponseCode());
            }


        } catch (Exception ex){
            Log.i(TAG, "ERROR : "+ex.getMessage());
        }

        return dashboardList;
    }
}
