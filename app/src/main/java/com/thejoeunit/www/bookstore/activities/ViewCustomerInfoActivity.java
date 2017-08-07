package com.thejoeunit.www.bookstore.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.thejoeunit.www.bookstore.R;
import com.thejoeunit.www.bookstore.datas.Customer;

public class ViewCustomerInfoActivity extends AppCompatActivity {
    private TextView nameTxt, numTxt, mailTxt;
    private Customer mCustomer;
    private Button notifyBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_info);
        bindView();

        nameTxt.setText(mCustomer.name);
        numTxt.setText(mCustomer.phoneNum);
        mailTxt.setText(mCustomer.email);

        notifyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewCustomerInfoActivity.this, EditCustomerInfoActivity.class);
                intent.putExtra("customer", mCustomer);
                startActivityForResult(intent, 1000);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1000) {
            if(resultCode == RESULT_OK) {
                Customer tmpCustomer = (Customer)data.getSerializableExtra("newCustomer");
                nameTxt.setText(tmpCustomer.name);
                numTxt.setText(tmpCustomer.phoneNum);
                mailTxt.setText(tmpCustomer.email);

                int orgPosition = getIntent().getIntExtra("position", -1);

                Customer orgCustomer = CustomerListActivity.customers.get(orgPosition);
                orgCustomer.name = tmpCustomer.name;
                orgCustomer.phoneNum = tmpCustomer.phoneNum;
                orgCustomer.email = tmpCustomer.email;
            }
        }
    }

    void bindView() {
        mCustomer = (Customer) getIntent().getSerializableExtra("customerInfo");
        nameTxt = (TextView)findViewById(R.id.nameTxt);
        numTxt = (TextView)findViewById(R.id.numTxt);
        mailTxt = (TextView)findViewById(R.id.mailTxt);
        notifyBtn = (Button)findViewById(R.id.notifyBtn);
    }
}
