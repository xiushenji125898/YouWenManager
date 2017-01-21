package com.daoben.youwenmanager.ui.contact;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daoben.youwenmanager.R;

/**
 * 通讯录
 * Created by Administrator on 2017/1/17.
 */

public class ContactFragment extends Fragment
{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_contact,container,false);
        return v;
    }
}
