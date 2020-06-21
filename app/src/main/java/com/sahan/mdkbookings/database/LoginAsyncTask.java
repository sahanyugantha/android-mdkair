package com.sahan.mdkbookings.database;

import android.os.AsyncTask;
import android.util.Log;

import com.sahan.mdkbookings.model.User;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class LoginAsyncTask extends AsyncTask<Void, Void, User> {


    private static final String TAG = "loginTag";
    private static final String LoginURL = "http://10.0.2.2/api/authApi.php";

    private String email;
    private String password;

    public LoginAsyncTask(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    protected User doInBackground(Void... voids) {
        User user = new User();
        user.setLogged_in(false);

        try {
            URL url = new URL(LoginURL);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(1000*5);
            httpURLConnection.setReadTimeout(1000*5);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);

            String data =  "uemail="+URLEncoder.encode(email, "utf-8")+"&"+
                            "upassword="+URLEncoder.encode(password, "utf-8");
            //Log.i(TAG, "DataString : "+data);

            OutputStream outputStream = httpURLConnection.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

            bufferedWriter.write(data);
            bufferedWriter.flush();
            bufferedWriter.close();

            if(httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK){

                InputStream inputStream = httpURLConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String line;
                StringBuilder sb = new StringBuilder();

                while ((line = bufferedReader.readLine()) != null){

                    sb.append(line);

                }

               // Log.i(TAG, "Data : "+sb.toString());

                JSONObject jsonObject = new JSONObject(sb.toString());
                String message = jsonObject.getString("message");
                if(message.equals("SUCCESS")){
                    //TODO::
                } else {
                    //TODO: do some redirection
                }


            }




            httpURLConnection.disconnect();
        } catch (Exception ex){
            Log.i(TAG, "Error : "+ex.getMessage());
        }


        return user;
    }
}

