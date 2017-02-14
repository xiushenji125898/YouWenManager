package com.daoben.youwenmanager.ui.contact;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.daoben.youwenmanager.R;
import com.daoben.youwenmanager.ui.BaseActivtiy;

public class AddContactActivity extends BaseActivtiy
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        setupToolbar();
        setTitle("添加联系人");
    }
}
