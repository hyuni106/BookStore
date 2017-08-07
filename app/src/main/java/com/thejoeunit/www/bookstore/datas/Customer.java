package com.thejoeunit.www.bookstore.datas;

import java.io.Serializable;

/**
 * Created by the on 2017-07-25.
 */

public class Customer implements Serializable {
    public String name;
    public String phoneNum;
    public String email;

    public Customer() {

    }

    public Customer(String name, String phoneNum, String email) {
        this.name = name;
        this.phoneNum = phoneNum;
        this.email = email;
    }

    @Override
    public String toString() {
        String str=this.name + " : " + this.phoneNum;
        return str;
    }
}
