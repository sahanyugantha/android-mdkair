package com.sahan.mdkbookings.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sahan.mdkbookings.R;
import com.sahan.mdkbookings.database.UserDao;
import com.sahan.mdkbookings.view.AboutActivity;
import com.sahan.mdkbookings.view.HomeActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "customTag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLogin = (Button) findViewById(R.id.btnSignIn);
        final EditText etEmail = (EditText) findViewById(R.id.txtEmail);
        final EditText etPass = (EditText) findViewById(R.id.txtPassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email =  etEmail.getText().toString();
                String password = etPass.getText().toString();

                UserDao userDao = new UserDao();
                boolean result = userDao.LoginChecker(email, password);

                if(result){
                    Toast.makeText(getApplicationContext(), "Successfully logged in", Toast.LENGTH_SHORT).show();

                    Intent intentHome = new Intent(getApplicationContext(), HomeActivity.class);
                    intentHome.putExtra("email", email);
                    startActivity(intentHome);

                } else{
                    Toast.makeText(getApplicationContext(), "Authentication failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.menuAbout:
                Toast.makeText(getApplicationContext(), "Clicked at about", Toast.LENGTH_SHORT).show();

                //Opening AboutActivity
                Intent intentAbout = new Intent(getApplicationContext(), AboutActivity.class);
                startActivity(intentAbout);
                break;

            case R.id.menuHelp:
                Toast.makeText(getApplicationContext(), "Help.....", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuSetting:
                Toast.makeText(getApplicationContext(), "Settings will be open", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
