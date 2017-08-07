package com.thejoeunit.www.bookstore.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import com.thejoeunit.www.bookstore.R;
import com.thejoeunit.www.bookstore.datas.Book;

import java.util.ArrayList;

public class BookListActivity extends AppCompatActivity {

    private android.widget.ImageButton addCustomerImgBtn;
    private android.widget.ListView BookListView;
    ArrayList<Book> books = new ArrayList<Book>();
    ArrayAdapter<Book> booksAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);
        bindViews();
        addBooksToArray();
        booksAdapter = new ArrayAdapter<Book>(BookListActivity.this, android.R.layout.simple_list_item_1, books);
        BookListView.setAdapter(booksAdapter);

        BookListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(BookListActivity.this, ViewBookInfoActivity.class);
                intent.putExtra("book", books.get(position));
                startActivity(intent);
            }
        });

        BookListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(BookListActivity.this);
                Book tmp = books.get(position);
                myBuilder.setTitle("삭제");
                String msgStr = "정말 [ " + tmp.getTitle() + " ] 을 삭제하시겠습니까?";
                myBuilder.setMessage(msgStr);
                myBuilder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        books.remove(position);
                        booksAdapter.notifyDataSetChanged();
                    }
                });
                myBuilder.setNegativeButton("삭제", null);
                myBuilder.show();
                return true;    // 짧은 클릭과 긴 클릭을 구별하려면 retrun true로 전환
            }
        });
    }

    private void addBooksToArray() {
        books.clear();
        books.add(new Book("의학의 법칙들", "싯다르타 무케르지", "문학동네", 1500, R.drawable.book1));
        books.add(new Book("여자의 독서", "김진애", "다산북스", 2000, R.drawable.book2));
        books.add(new Book("기억 독서법", "기성준", "북씽크", 1500, R.drawable.book3));
        books.add(new Book("인간의 위대한 여정", "배철현", "21세기북스", 1000, R.drawable.book4));
    }

    void bindViews() {
        this.BookListView = (ListView) findViewById(R.id.customerList);
        this.addCustomerImgBtn = (ImageButton) findViewById(R.id.addCustomerImgBtn);
    }
}
