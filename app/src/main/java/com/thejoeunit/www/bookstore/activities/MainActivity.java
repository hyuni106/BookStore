package com.thejoeunit.www.bookstore.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.thejoeunit.www.bookstore.R;

public class MainActivity extends AppCompatActivity {
    private Button customerAdminBtn;
    private Button bookListBtn;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.button = (Button) findViewById(R.id.button);
        this.bookListBtn = (Button) findViewById(R.id.bookListBtn);
        this.customerAdminBtn = (Button) findViewById(R.id.customerAdminBtn);

        bindViews();

        customerAdminBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, CustomerListActivity.class);
                startActivity(myIntent);
            }
        });

        bookListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, BookListActivity.class);
                startActivity(myIntent);
            }
        });

    }

    void bindViews() {
        customerAdminBtn = (Button)findViewById(R.id.customerAdminBtn);
    }
}
