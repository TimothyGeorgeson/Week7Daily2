package com.example.consultants.week7daily2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private LoginView loginView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginView = findViewById(R.id.loginView);

        loginView.setOnLoginResultsListener(new LoginView.OnLoginResults() {
            @Override
            public void onSuccess(String email) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                intent.putExtra("email", email);
                startActivity(intent);
            }

            @Override
            public void onFailure(String error) {
                Toast.makeText(MainActivity.this, "Invalid email or password", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
