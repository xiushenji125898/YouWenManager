package com.daoben.youwenmanager.ui.me;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daoben.youwenmanager.R;

/**
 * 我的
 * Created by Administrator on 2017/1/17.
 */

public class MeFragment extends Fragment
{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_me,container,false);
        return v;
    }
}
