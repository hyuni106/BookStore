package com.thejoeunit.www.bookstore.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.thejoeunit.www.bookstore.R;
import com.thejoeunit.www.bookstore.datas.Customer;

import java.util.ArrayList;

public class CustomerListActivity extends AppCompatActivity {
    private ListView customerList;
    private ImageButton addCustomerImgBtn;
    public static ArrayList<Customer> customers = new ArrayList<Customer>();
    // static : 프로그램 실행시 단 한번 생성되는 변수
    // 아무리 다시 new를 만나도 기존 객체들 가지고있음
    ArrayAdapter<Customer> customerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_list);
        bindViews();

        customers.clear();
        arrayListMaker();

        customerAdapter = new ArrayAdapter<Customer>(CustomerListActivity.this, android.R.layout.simple_list_item_1, customers);

        customerList.setAdapter(customerAdapter);

        event();
    }

    @Override
    protected void onResume() {
        super.onResume();
        customerAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1000) {
            Log.d("sh", "사용자 객체가 돌아옴");

            if(resultCode == RESULT_OK) {
                Log.d("sh", "RESULT_OK");
                Customer tmpCustomer = (Customer) data.getSerializableExtra("newCustomer");

                customers.add(tmpCustomer);
                customerAdapter.notifyDataSetChanged();
            }
        }
    }

    void bindViews() {
        customerList = (ListView)findViewById(R.id.customerList);
        addCustomerImgBtn = (ImageButton)findViewById(R.id.addCustomerImgBtn);
    }

    void event() {
        customerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myIntent = new Intent(CustomerListActivity.this, ViewCustomerInfoActivity.class);
                myIntent.putExtra("customerInfo", customers.get(position));
                myIntent.putExtra("position", position);
                startActivity(myIntent);
            }
        });

        addCustomerImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO - 고객 추가 화면으로 이동시켜야한다.
//                Toast.makeText(CustomerListActivity.this, "준비 중입니다.", Toast.LENGTH_SHORT).show();
                Intent myIntent = new Intent(CustomerListActivity.this, EditCustomerInfoActivity.class);
                startActivityForResult(myIntent, 1000);
            }
        });

        customerList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(CustomerListActivity.this);
                myBuilder.setTitle("삭제");
                myBuilder.setMessage("삭제하시겠습니까?");
                myBuilder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(CustomerListActivity.this, "삭제되었습니다.", Toast.LENGTH_SHORT).show();
                        customers.remove(position);
                        customerAdapter.notifyDataSetChanged();
                    }
                });
                myBuilder.setNegativeButton("취소", null);
                myBuilder.setNeutralButton("임시저장", null);
                myBuilder.setIcon(R.mipmap.ic_launcher_round);
                myBuilder.show();
                return true;
            }
        });
    }

    void arrayListMaker() {
        customers.add(new Customer("고동윤", "010-4238-2185", "asd@dfkl.com"));
        customers.add(new Customer("권성민", "010-4532-7652", "wer@dsfsad.com"));
        customers.add(new Customer("김현철", "010-1234-8565", "hjgh@gjb.com"));
        customers.add(new Customer("박석영", "010-0557-8654", "fddgf@rtte.com"));
        customers.add(new Customer("박수현", "010-1993-0929", "hb@hbhb.com"));
        customers.add(new Customer("박영주", "010-7652-8652", "trty@dfbvjhkl.com"));
        customers.add(new Customer("손익상", "010-9224-7852", "3ser@wer.com"));
        customers.add(new Customer("이승헌", "010-8245-3751", "brt6@zsdf.com"));
        customers.add(new Customer("이요한", "010-1675-3741", "khgy5@retd.com"));
        customers.add(new Customer("한상일", "010-2785-7322", "bser@ljhg.com"));
    }
}
