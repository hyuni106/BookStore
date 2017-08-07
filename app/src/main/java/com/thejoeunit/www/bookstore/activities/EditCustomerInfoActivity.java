package com.thejoeunit.www.bookstore.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.thejoeunit.www.bookstore.R;
import com.thejoeunit.www.bookstore.datas.Customer;

public class EditCustomerInfoActivity extends AppCompatActivity {
    private EditText nameEdt, phoneEdt, emailEdt;
    private Button addBtn;
    private TextView titleTxt;

    private Customer mCustomer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_customer_info);
        bindViews();

        mCustomer = (Customer) getIntent().getSerializableExtra("customer");

        if(mCustomer != null) {
            nameEdt.setText(mCustomer.name);
            phoneEdt.setText(mCustomer.phoneNum);
            emailEdt.setText(mCustomer.email);
            titleTxt.setText("회원 정보 수정");
            addBtn.setText("수정 완료");
        }

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String customerName = nameEdt.getText().toString();
                String customerPhone = phoneEdt.getText().toString();
                String customerEmail = emailEdt.getText().toString();

                Customer myCustomer = new Customer(customerName, customerPhone, customerEmail);
                Toast.makeText(EditCustomerInfoActivity.this, "저장이 완료되었습니다.", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent();
                // 이전 화면으로 데이터 전송
                intent.putExtra("newCustomer", myCustomer);
                setResult(RESULT_OK, intent);

                finish();

            }
        });
    }

    void bindViews() {
        nameEdt = (EditText) findViewById(R.id.nameEdt);
        phoneEdt = (EditText) findViewById(R.id.phoneEdt);
        emailEdt = (EditText) findViewById(R.id.emailEdt);
        addBtn = (Button) findViewById(R.id.addBtn);
        titleTxt = (TextView)findViewById(R.id.titleTxt);
    }
}
