package com.daoben.youwenmanager.ui;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.daoben.youwenmanager.R;

/**
 * Created by Administrator on 2017/1/18.
 */

public class BaseActivtiy extends AppCompatActivity
{
    public TextView title, save;
    public ImageView add;

    public void setupToolbar()
    {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        title = (TextView) findViewById(R.id.title);
        save = (TextView) findViewById(R.id.save);
        add = (ImageView) findViewById(R.id.add);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                finish();
            }
        });
    }

    /**
     * 修改标题
     *
     * @param str
     */
    public void setTitle(String str)
    {
        title.setText(str);
    }

    /**
     * 添加按钮是否显示
     *
     * @param b
     */
    public void setSaveVisiblty(boolean b)
    {
        if (b)
        {
            save.setVisibility(View.VISIBLE);
            add.setVisibility(View.GONE);
        } else
        {
            save.setVisibility(View.GONE);
        }
    }

    /**
     * 保存按钮是否显示
     *
     * @param b
     */
    public void setAddVisiblty(boolean b)
    {
        if (b)
        {
            save.setVisibility(View.GONE);
            add.setVisibility(View.VISIBLE);
        } else
        {
            add.setVisibility(View.GONE);
        }
    }

//    public void saveSetOnClick()
//    {
//        save.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View view)
//            {
//
//            }
//        });
//    }

}
