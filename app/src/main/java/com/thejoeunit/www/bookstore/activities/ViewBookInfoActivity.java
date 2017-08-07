package com.thejoeunit.www.bookstore.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.thejoeunit.www.bookstore.R;
import com.thejoeunit.www.bookstore.datas.Book;

public class ViewBookInfoActivity extends AppCompatActivity {
    private Book mBook;
    private android.widget.TextView titleTxt;
    private android.widget.TextView authorNameTxt;
    private android.widget.TextView publisherTxt;
    private android.widget.TextView costTxt;
    private android.widget.Button notifyBtn;
    private TextView textView;
    private android.widget.ImageView bookImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_book_info);

        bindViews();
        mBook = (Book) getIntent().getSerializableExtra("book");
        setValues();
    }

    private void setValues() {
        titleTxt.setText(mBook.getTitle());
        authorNameTxt.setText(mBook.getAuthorName());
        publisherTxt.setText(mBook.getPublisherName());
        costTxt.setText(mBook.getCost()+" 원");
        bookImg.setImageResource(mBook.getBookImgId());
    }

    private void bindViews() {
        this.notifyBtn = (Button) findViewById(R.id.notifyBtn);
        this.costTxt = (TextView) findViewById(R.id.costTxt);
        this.publisherTxt = (TextView) findViewById(R.id.publisherTxt);
        this.authorNameTxt = (TextView) findViewById(R.id.authorNameTxt);
        this.titleTxt = (TextView) findViewById(R.id.titleTxt);
        this.bookImg = (ImageView) findViewById(R.id.bookImg);
        this.textView = (TextView) findViewById(R.id.textView);
    }
}
