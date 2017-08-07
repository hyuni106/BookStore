package com.thejoeunit.www.bookstore.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.thejoeunit.www.bookstore.R;

public class LoginActivity extends AppCompatActivity {
    private Button loginBtn;
    private EditText idEdt, pwEdt;

    LoginActivity lgnActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        bindViews();

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(idEdt.getText().toString().equals("admin")) {
                    if(pwEdt.getText().toString().equals("123123")) {
                        Intent myIntent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(myIntent);
                        finish();
                    } else if(pwEdt.getText().toString().equals("")) {
                        Toast.makeText(lgnActivity, "비밀번호를 입력하세요", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(lgnActivity, "아이디 혹은 비밀번호가 올바르지 않습니다.", Toast.LENGTH_SHORT).show();
                    }
                } else if(idEdt.getText().toString().equals("")) {
                    Toast.makeText(lgnActivity, "아이디를 입력하세요", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    void bindViews() {
        loginBtn = (Button)findViewById(R.id.loginBtn);
        idEdt = (EditText)findViewById(R.id.idEdt);
        pwEdt = (EditText)findViewById(R.id.pwEdt);

        lgnActivity = this;
    }
}
