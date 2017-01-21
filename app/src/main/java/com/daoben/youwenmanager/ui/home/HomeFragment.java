package com.daoben.youwenmanager.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.daoben.youwenmanager.R;
import com.daoben.youwenmanager.adapter.LocalImageHolderView;
import com.daoben.youwenmanager.adapter.MyGridAdapter;
import com.daoben.youwenmanager.ui.home.account.AccountActivity;

import java.util.ArrayList;

/**
 * 主页
 * Created by Administrator on 2017/1/17.
 */

public class HomeFragment extends Fragment implements OnItemClickListener, AdapterView.OnItemClickListener
{
    private ConvenientBanner convenientBanner;//顶部广告栏控件
    private ArrayList<Integer> localImages = new ArrayList<Integer>();
    private GridView mGridView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        initView(v);
        initData();
        return v;
    }


    private void initView(View v)
    {
        convenientBanner = (ConvenientBanner) v.findViewById(R.id.convenientBanner);
        mGridView = (GridView) v.findViewById(R.id.gv_home);
    }

    private void initData()
    {
        loadTestDatas();
        //本地图片例子
        convenientBanner.setPages(
                new CBViewHolderCreator<LocalImageHolderView>()
                {
                    @Override
                    public LocalImageHolderView createHolder()
                    {
                        return new LocalImageHolderView();
                    }
                }, localImages)
                //设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器,不需要圆点指示器可用不设
                .setPageIndicator(new int[]{R.mipmap.ic_page_indicator, R.mipmap.ic_page_indicator_focused})
                //设置指示器的方向
//                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT)
//                .setOnPageChangeListener(this)//监听翻页事件
                .setOnItemClickListener(this);

        mGridView.setAdapter(new MyGridAdapter(getContext()));
        mGridView.setOnItemClickListener(this);
    }

    /**
     * 添加本地图片
     */
    private void loadTestDatas()
    {
        localImages.add(R.mipmap.top1);
        localImages.add(R.mipmap.top2);
        localImages.add(R.mipmap.top3);
        localImages.add(R.mipmap.top4);
        localImages.add(R.mipmap.top5);
        localImages.add(R.mipmap.top6);
    }

    @Override
    public void onItemClick(int position)
    {
        Toast.makeText(getActivity(), "点击了第" + position + "个", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResume()
    {
        super.onResume();
        //开始自动翻页
        convenientBanner.startTurning(3000);
    }

    @Override
    public void onPause()
    {
        super.onPause();
        //停止翻页
        convenientBanner.stopTurning();
    }

    @Override
    public void onItemClick(AdapterView<?> view, View view1, int i, long l)
    {
        switch (i)
        {
            case 0:
                break;
            case 1:
                startActivity(new Intent(getContext(),AccountActivity.class));
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
        }
    }
}
