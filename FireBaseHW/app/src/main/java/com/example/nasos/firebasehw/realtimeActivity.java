package com.example.nasos.firebasehw;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class realtimeActivity extends AppCompatActivity {
    @BindView(R.id.editEmail)
    EditText email;
    @BindView(R.id.editName)
    EditText name;

    @OnClick(R.id.editNameEmailBtn)
    public void sendData(View v) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Users");
        myRef.push().setValue(makeUser());

        Toast.makeText(v.getContext(), "보내기 완료!", Toast.LENGTH_SHORT).show();
        name.setText("");
        email.setText("");
    }

    private User makeUser() {
        User newUser = new User();
        newUser.setName(name.getText().toString());
        newUser.setEmail(email.getText().toString());
        return newUser;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realtime);
        ButterKnife.bind(this);
    }
}
