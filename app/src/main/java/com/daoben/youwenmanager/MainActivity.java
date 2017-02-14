package com.daoben.youwenmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.daoben.youwenmanager.bean.TabEntity;
import com.daoben.youwenmanager.ui.contact.AddContactActivity;
import com.daoben.youwenmanager.ui.contact.ContactFragment;
import com.daoben.youwenmanager.ui.home.HomeFragment;
import com.daoben.youwenmanager.ui.me.MeFragment;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnTabSelectListener, View.OnClickListener
{
    //随便添加的
    private TextView tvTitle;
    private ImageView addContact;

    private String[] mTitles = new String[]{"主页", "通讯录", "我的"};
    private int[] mIconUnselectIds = new int[]{
            R.mipmap.tab_home_unselect,
            R.mipmap.tab_contact_unselect, R.mipmap.tab_me_unselect};
    private int[] mIconSelectIds = new int[]{
            R.mipmap.tab_home_select,
            R.mipmap.tab_contact_select, R.mipmap.tab_me_select};
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private CommonTabLayout mCommonTabLayout;
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupToolbar();
        initView();
        initData();
    }

    /**
     * 初始化数据
     */
    private void initData()
    {
        mFragments.add(new HomeFragment());
        mFragments.add(new ContactFragment());
        mFragments.add(new MeFragment());

        for (int i = 0; i < mTitles.length; i++)
        {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }

        mCommonTabLayout.setTabData(mTabEntities, this, R.id.fl_main, mFragments);
        mCommonTabLayout.setOnTabSelectListener(this);
        addContact.setOnClickListener(this);
    }

    /**
     * 初始化控件
     */
    private void initView()
    {
        tvTitle = (TextView) findViewById(R.id.title);
        addContact = (ImageView) findViewById(R.id.addcontact);
        mCommonTabLayout = (CommonTabLayout) findViewById(R.id.tl_2);
    }

    /**
     * 初始化toolbar
     */
    private void setupToolbar()
    {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //用toolbar 取代actionBar
        setSupportActionBar(toolbar);
        //不显示actionBar
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    @Override
    public void onTabSelect(int position)
    {
        switch (position)
        {
            case 0:
                tvTitle.setText("主页");
                addContact.setVisibility(View.GONE);
                break;
            case 1:
                tvTitle.setText("通讯录");
                addContact.setVisibility(View.VISIBLE);

                break;
            case 2:
                tvTitle.setText("我的");
                addContact.setVisibility(View.GONE);
                break;
        }
    }

    @Override
    public void onTabReselect(int position)
    {

    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.addcontact:
                startActivity(new Intent(this, AddContactActivity.class));
                break;
        }
    }
}
