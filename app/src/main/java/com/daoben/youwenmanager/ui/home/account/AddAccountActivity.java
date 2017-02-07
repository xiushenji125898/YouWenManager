package com.daoben.youwenmanager.ui.home.account;

import android.graphics.Color;
import android.os.Bundle;
import android.text.InputFilter;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.bigkoo.alertview.AlertView;
import com.bigkoo.alertview.OnItemClickListener;
import com.daoben.youwenmanager.Dao.DaoAccountDao;
import com.daoben.youwenmanager.Dao.DaoMaster;
import com.daoben.youwenmanager.R;
import com.daoben.youwenmanager.Util.CashierInputFilter;
import com.daoben.youwenmanager.Util.Util;
import com.daoben.youwenmanager.YouWenApplication;
import com.daoben.youwenmanager.entity.DaoAccount;
import com.daoben.youwenmanager.ui.BaseActivtiy;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 记一笔
 */
public class AddAccountActivity extends BaseActivtiy implements View.OnClickListener, OnItemClickListener
{
    private Button btnCanyin, btnWanggou, btnJiaotong, btnYiwu, btnGouwu, btnYule, btnLicai, btnJiaofei, btnXuexi, btnOther;
    private int tag ;
    private Button[] btns;
    private DaoAccount mDaoAccount;
    private DaoAccountDao dao;
    private EditText etMoney, etRemark;
    private TextView tvMode;
    private String[] modes;
    private int modepos;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_account);
        setupToolbar();
        setTitle("记一笔");
        setSaveVisiblty(true);

        dao = YouWenApplication.getApplication().getDaoSession().getDaoAccountDao();
        initView();
        initData();
    }

    private void initData()
    {
        btns = new Button[]{btnCanyin, btnWanggou, btnJiaotong, btnYiwu, btnGouwu, btnYule, btnLicai, btnJiaofei, btnXuexi, btnOther};
        btnCanyin.setOnClickListener(this);
        btnWanggou.setOnClickListener(this);
        btnJiaotong.setOnClickListener(this);
        btnYiwu.setOnClickListener(this);
        btnGouwu.setOnClickListener(this);
        btnYule.setOnClickListener(this);
        btnLicai.setOnClickListener(this);
        btnJiaofei.setOnClickListener(this);
        btnXuexi.setOnClickListener(this);
        btnOther.setOnClickListener(this);
        save.setOnClickListener(this);
        tvMode.setOnClickListener(this);

    }

    private void initView()
    {
        btnCanyin = (Button) findViewById(R.id.btn_select_canyin);
        btnWanggou = (Button) findViewById(R.id.btn_select_wanggou);
        btnJiaotong = (Button) findViewById(R.id.btn_select_jiaotong);
        btnYiwu = (Button) findViewById(R.id.btn_select_yiwu);
        btnGouwu = (Button) findViewById(R.id.btn_select_gouwu);
        btnYule = (Button) findViewById(R.id.btn_select_yule);
        btnLicai = (Button) findViewById(R.id.btn_select_licai);
        btnJiaofei = (Button) findViewById(R.id.btn_select_jiaofei);
        btnXuexi = (Button) findViewById(R.id.btn_select_xuexi);
        btnOther = (Button) findViewById(R.id.btn_select_other);
        etMoney = (EditText) findViewById(R.id.et_addaccount_money);
        etMoney.setFilters(new InputFilter[]{new CashierInputFilter(etMoney)});
        etRemark = (EditText) findViewById(R.id.et_addaccount_remark);
        tvMode = (TextView) findViewById(R.id.tv_addaccount_mode);
        modes = new String[]{"支付宝", "微信", "现金", "银行卡"};

    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.btn_select_canyin:
                tag = 0;
                break;
            case R.id.btn_select_wanggou:
                tag = 1;
                break;
            case R.id.btn_select_jiaotong:
                tag = 2;
                break;
            case R.id.btn_select_yiwu:
                tag = 3;
                break;
            case R.id.btn_select_gouwu:
                tag = 4;
                break;
            case R.id.btn_select_yule:
                tag = 5;
                break;
            case R.id.btn_select_licai:
                tag = 6;
                break;
            case R.id.btn_select_jiaofei:
                tag = 7;
                break;
            case R.id.btn_select_xuexi:
                tag = 8;
                break;
            case R.id.btn_select_other:
                tag = 9;
                break;
            case R.id.tv_addaccount_mode:
                new AlertView("选择支付方式", "", "取消", modes, null, this, AlertView.Style.ActionSheet, this).show();
                break;
            case R.id.save:
//                Util.showToast(this, "你点击了保存");

                double money = Double.parseDouble(etMoney.getText().toString().trim());
                String remark = etRemark.getText().toString();


                if (tvMode.getText().toString().equals("点击选择支付方式"))
                {
                    Util.showToast(this, "请选择支付方式");
                } else if (remark.getBytes().length == 0)
                {
                    Util.showToast(this, "请输入备注");
                } else
                {
                    mDaoAccount = new DaoAccount(null,money,tag,modepos,remark,System.currentTimeMillis()+"");
                    mDaoAccount.setMoney(money);
                    mDaoAccount.setMode(modepos);
                    mDaoAccount.setRemark(remark);
                    mDaoAccount.setType(tag);
                    mDaoAccount.setDate(Util.getSysTime("yyyy-MM-dd"));

                    dao.insert(mDaoAccount);
                    Util.showToast(this,"保存完成");
                    finish();
                }
//                mDaoAccount.setMoney();
                break;
        }
        chengeBackground(tag);
        Log.e("Tag", "==============================     " + tag + "      ==========================");
    }

    private void chengeBackground(int tag)
    {
        for (int i = 0; i < btns.length; i++)
        {
            if (i == tag)
            {
                btns[i].setBackgroundColor(Color.parseColor("#008000"));
            } else
            {
                btns[i].setBackgroundColor(Color.parseColor("#a9a9a9"));
            }
        }
    }

    @Override
    public void onItemClick(Object o, int position)
    {
        if (position != -1)
        {
            modepos = position;
            tvMode.setText(modes[modepos]);
        }
    }
}
