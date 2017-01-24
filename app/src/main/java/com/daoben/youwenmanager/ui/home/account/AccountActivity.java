package com.daoben.youwenmanager.ui.home.account;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.daoben.youwenmanager.R;
import com.daoben.youwenmanager.ui.BaseActivtiy;

/**
 * 消费记账
 */
public class AccountActivity extends BaseActivtiy implements View.OnClickListener
{
    /**
     * 记一笔
     */
    private Button btnAddExpend;
    /**
     * 消费统计
     */
    private LinearLayout llStatistics;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        setupToolbar();
        setTitle("消费记账");
        initView();
        initData();
    }

    private void initData()
    {
        btnAddExpend.setOnClickListener(this);
        llStatistics.setOnClickListener(this);
    }

    private void initView()
    {
        btnAddExpend = (Button) findViewById(R.id.btn_add_expend);
        llStatistics = (LinearLayout) findViewById(R.id.ll_expend_statistics);
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.btn_add_expend:
                startActivity(new Intent(this,AddAccountActivity.class));
                break;
            case R.id.ll_expend_statistics:
                startActivity(new Intent(this,StatisticsActivity.class));
                break;
        }
    }
}
