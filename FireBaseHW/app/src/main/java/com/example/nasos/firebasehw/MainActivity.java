package com.example.nasos.firebasehw;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.crash.FirebaseCrash;
import com.google.firebase.iid.FirebaseInstanceId;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @OnClick({ R.id.realtimeDB, R.id.authentication , R.id.Crash})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.realtimeDB:
                startActivity(new Intent(getApplicationContext(), realtimeActivity.class));
                break;
            case R.id.authentication:
                startActivity(new Intent(getApplicationContext(), Authentication.class));
                break;
            case R.id.Crash:
                FirebaseCrash.report(new Exception("My first Android non-fatal error"));
                Toast.makeText(v.getContext(), "오류 보고 완료!", Toast.LENGTH_SHORT).show();

                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        String token = FirebaseInstanceId.getInstance().getToken();
        Log.d("FCM_Token", token);




    }
}
