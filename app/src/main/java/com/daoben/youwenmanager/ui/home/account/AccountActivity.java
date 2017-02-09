package com.daoben.youwenmanager.ui.home.account;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.daoben.youwenmanager.Dao.DaoAccountDao;
import com.daoben.youwenmanager.Dao.DaoMaster;
import com.daoben.youwenmanager.R;
import com.daoben.youwenmanager.Util.AccountUtil;
import com.daoben.youwenmanager.Util.Util;
import com.daoben.youwenmanager.YouWenApplication;
import com.daoben.youwenmanager.entity.DaoAccount;
import com.daoben.youwenmanager.ui.BaseActivtiy;

import java.util.List;

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

    private TextView tvDay,tvMonth,tvWeek;

    private DaoAccountDao dao;
    private DaoMaster mDaoMaster;
    private double dayMoney;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        setupToolbar();
        setTitle("消费记账");
        dao = YouWenApplication.getApplication().getDaoSession().getDaoAccountDao();
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
        tvDay = (TextView) findViewById(R.id.tv_expend_day);
        tvMonth = (TextView) findViewById(R.id.tv_expend_month);
        tvWeek = (TextView) findViewById(R.id.tv_expend_week);
    }

    @Override
    protected void onResume()
    {
        super.onResume();

        double daymoney = AccountUtil.getToDayMoney(dao,this);
        if(daymoney ==0)
        {
            tvDay.setText("￥0.0");
        }else
        {
            tvDay.setText("￥"+daymoney);
        }
        double weekmoney = AccountUtil.getToWeekMoney(dao,this);
        if(weekmoney ==0)
        {
            tvWeek.setText("￥0.0");
        }else
        {
            tvWeek.setText("￥"+weekmoney);
        }
        double monthmoney = AccountUtil.getToMonthMoney(dao,this);
//        tvMonth.setText(AccountUtil.getToMonthMoney(dao,this)+"");
        if(monthmoney ==0)
        {
            tvMonth.setText("￥0.0");
        }else
        {
            tvMonth.setText("￥"+monthmoney);
        }

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
