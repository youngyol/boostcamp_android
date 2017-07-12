package com.example.nasos.firebasehw;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Authentication extends AppCompatActivity {
    @BindView(R.id.editID)
    EditText ID ;
    @BindView(R.id.editPW)
    EditText password ;
    private FirebaseAuth mAuth;

    @OnClick({ R.id.signIn, R.id.signUp})
    public void onClick(View v) {


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Users");
        switch (v.getId()) {
            case R.id.signUp:
                mAuth.createUserWithEmailAndPassword(ID.getText().toString(), password.getText().toString())
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (!task.isSuccessful()) {
                                    Log.w("failure", task.getException());
                                    Toast.makeText(Authentication.this, "회원가입 실패",
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    ID.setText("");
                                    password.setText("");
                                    Toast.makeText(Authentication.this, "가입완료 로그인하세요!",
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        });

                break;
            case R.id.signIn:

                mAuth.signInWithEmailAndPassword(ID.getText().toString(), password.getText().toString())
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (!task.isSuccessful()) {
                                    Log.w("failure", task.getException());
                                    Toast.makeText(Authentication.this, "로그인 실패",
                                            Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    ID.setText("");
                                    password.setText("");
                                    Toast.makeText(Authentication.this, "로그인 성공!",
                                            Toast.LENGTH_SHORT).show();
                                }

                            }
                        });
                break;
        }
    }

    private void signUp(String email, String password) {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Users");
        FirebaseAuth auth = FirebaseAuth.getInstance();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);
        mAuth = FirebaseAuth.getInstance();


        ButterKnife.bind(this);
    }
}
