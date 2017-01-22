package com.daoben.youwenmanager.ui.home.notebook;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.daoben.youwenmanager.R;
import com.daoben.youwenmanager.Util.Util;
import com.daoben.youwenmanager.adapter.NoteBookAdapter;
import com.daoben.youwenmanager.bean.NoteBookBean;
import com.daoben.youwenmanager.ui.BaseActivtiy;

import java.util.ArrayList;
import java.util.List;

public class NoteBookActivity extends BaseActivtiy
{
    private List<NoteBookBean> mAppList;
    private NoteBookAdapter mAdapter;
    private SwipeMenuListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_book);
        setupToolbar();
        setTitle("心情日记");
        setAddVisiblty(true);
        initView();
        initData();
    }

    private void initView()
    {
        mAppList = new ArrayList<NoteBookBean>();
        mListView = (SwipeMenuListView) findViewById(R.id.listView);
    }
    private void initData()
    {
        mAppList.add(new NoteBookBean("2017年1月", "", "", ""));
        mAppList.add(new NoteBookBean("2017年1月", "上午 9：45", "就是测试的", "华苑"));
        mAppList.add(new NoteBookBean("2017年1月", "上午 9：45", "就是测试的2", "华苑"));
        mAppList.add(new NoteBookBean("2017年1月", "上午 9：45", "就是测试的3", "华苑"));
        mAppList.add(new NoteBookBean("2017年1月", "上午 9：45", "就是测试的4", "华苑"));
        mAppList.add(new NoteBookBean("2017年2月", "", "", ""));
        mAppList.add(new NoteBookBean("2017年2月", "上午 9：45", "就是测试的4", "华苑"));
        mAppList.add(new NoteBookBean("2017年2月", "上午 9：45", "就是测试的4", "华苑"));
        mAppList.add(new NoteBookBean("2017年3月", "", "", ""));
        mAppList.add(new NoteBookBean("2017年3月", "上午 9：45", "就是测试的4", "华苑"));
        mAppList.add(new NoteBookBean("2017年3月", "上午 9：45", "就是测试的4", "华苑"));
        mAdapter = new NoteBookAdapter(mAppList, this);
        mListView.setAdapter(mAdapter);

        initSwipeMenu();
    }

    private void initSwipeMenu()
    {
        SwipeMenuCreator creator = new SwipeMenuCreator()
        {
            @Override
            public void create(SwipeMenu menu)
            {
                SwipeMenuItem deleteItem = new SwipeMenuItem(
                        getApplicationContext());
                deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9,
                        0x3F, 0x25)));
                // set item width
                deleteItem.setWidth(Util.dp2px(NoteBookActivity.this,90));
                // set a icon
                deleteItem.setTitle("删除");
                deleteItem.setTitleColor(Color.WHITE);
                deleteItem.setTitleSize(18);
                // add to menu
                menu.addMenuItem(deleteItem);
            }
        };
        // set creator
        mListView.setMenuCreator(creator);
        for (int i = 0; i < mAppList.size(); i++)
        {
            if (mAppList.get(i).getContent().getBytes().length ==0)
            {
//                mListView.setEnabled(false);
//                mListView.smoothCloseMenu();
            }else
            {
//                mListView.smoothOpenMenu(i);
            }
        }

    }
}
