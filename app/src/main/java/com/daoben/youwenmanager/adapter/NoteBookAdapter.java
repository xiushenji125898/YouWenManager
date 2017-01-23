package com.daoben.youwenmanager.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.daoben.youwenmanager.R;
import com.daoben.youwenmanager.bean.NoteBookBean;
import com.daoben.youwenmanager.weight.RoundImageView;

import java.util.List;

/**
 * Created by Administrator on 2017/1/22.
 */

public class NoteBookAdapter extends BaseAdapter
{
    private List<NoteBookBean> list;
    private Context mContext;
    private LayoutInflater mInflater;

    public NoteBookAdapter(List<NoteBookBean> list, Context context)
    {
        this.list = list;
        this.mContext = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount()
    {
        return list.size();
    }

    @Override
    public Object getItem(int i)
    {
        return list.get(i);
    }

    @Override
    public long getItemId(int i)
    {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup group)
    {
        ViewHolder h;
        if (view == null)
        {
            view = mInflater.inflate(R.layout.notebook_item, group, false);
            h = new ViewHolder();
            h.tvTime = (TextView) view.findViewById(R.id.tv_item_notebook_time);
            h.tvContent = (TextView) view.findViewById(R.id.tv_item_notebook_content);
            h.tvAddress = (TextView) view.findViewById(R.id.tv_item_notebook_address);
            h.rivImage = (RoundImageView) view.findViewById(R.id.riv_item_notebook);
            h.tvMonth = (TextView) view.findViewById(R.id.tv_item_month);
            h.tvDay = (TextView) view.findViewById(R.id.tv_item_day);
            view.setTag(h);
        } else
        {
            h = (ViewHolder) view.getTag();
        }
        NoteBookBean bean = list.get(i);
        h.tvTime.setText(bean.getTime());
        h.tvContent.setText(bean.getContent());
        h.tvAddress.setText(bean.getAddress());
        h.rivImage.setType(RoundImageView.TYPE_ROUND);
        h.rivImage.setImageResource(R.drawable.man);
        h.tvMonth.setText("1月");
        h.tvDay.setText("20日");
        return view;
    }

    class ViewHolder
    {
        TextView  tvTime, tvContent, tvAddress,tvMonth,tvDay;
        RoundImageView rivImage;
    }
}
