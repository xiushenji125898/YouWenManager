package com.daoben.youwenmanager.ui.home.account;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.daoben.youwenmanager.R;
import com.daoben.youwenmanager.Util.Util;
import com.daoben.youwenmanager.ui.BaseActivtiy;

/**
 * 记一笔
 */
public class AddAccountActivity extends BaseActivtiy implements View.OnClickListener
{
    private Button btnCanyin, btnWanggou, btnJiaotong, btnYiwu, btnGouwu, btnYule, btnLicai, btnJiaofei, btnXuexi, btnOther;
    private int tag = 0;
    private Button[] btns;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_account);
        setupToolbar();
        setTitle("记一笔");
        setSaveVisiblty(true);
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
            case R.id.save:
                Util.showToast(this,"你点击了保存");
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
}
