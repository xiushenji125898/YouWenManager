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
            h.tvDate = (TextView) view.findViewById(R.id.item_notebook_date);
            h.tvTime = (TextView) view.findViewById(R.id.tv_item_notebook_time);
            h.tvContent = (TextView) view.findViewById(R.id.tv_item_notebook_content);
            h.tvAddress = (TextView) view.findViewById(R.id.tv_item_notebook_address);
            h.rivImage = (RoundImageView) view.findViewById(R.id.riv_item_notebook);
            h.llContent = (LinearLayout) view.findViewById(R.id.ll_item_content);
            view.setTag(h);
        } else
        {
            h = (ViewHolder) view.getTag();
        }
        NoteBookBean bean = list.get(i);
//        h.tvDate.setText(bean.getDate());
        h.tvTime.setText(bean.getTime());
        h.tvContent.setText(bean.getContent());
        h.tvAddress.setText(bean.getAddress());
        h.rivImage.setType(RoundImageView.TYPE_ROUND);
        h.rivImage.setImageResource(R.drawable.man);
//        if (needTitle(i))
//        {
//
//            notifyDataSetChanged();
//
//        }
//        if ( needTitle(i) ) {
////            list.add(i,new NoteBookBean(list.get(i).getDate(),"","",""));
//            // 显示标题并设置内容
//            h.tvDate.setText(bean.getDate());
//            h.tvDate.setVisibility(View.VISIBLE);
////            h.llContent.setVisibility(View.GONE);
//        } else {
//            // 内容项隐藏标题
//            h.tvDate.setVisibility(View.GONE);
////            h.llContent.setVisibility(View.VISIBLE);
//        }
        if (bean.getContent().getBytes().length==0)
        {
            h.tvDate.setText(bean.getDate());
            h.tvDate.setVisibility(View.VISIBLE);
            h.llContent.setVisibility(View.GONE);
        } else
        {
            h.tvDate.setVisibility(View.GONE);
            h.llContent.setVisibility(View.VISIBLE);
        }
//        notifyDataSetChanged();
        return view;
    }

    /**
     * 判断是否需要显示标题
     *
     * @param position
     * @return
     */
    private boolean needTitle(int position)
    {
        // 第一个肯定是分类
        if (position == 0)
        {
            return true;
        }

        // 边界处理
        if (position < 0)
        {
            return false;
        }

        // 当前  // 上一个
        NoteBookBean currentEntity = (NoteBookBean) getItem(position);
        NoteBookBean previousEntity = (NoteBookBean) getItem(position - 1);
        if (null == currentEntity || null == previousEntity)
        {
            return false;
        }

        String currentTitle = currentEntity.getDate();
        String previousTitle = previousEntity.getDate();
        if (null == previousTitle || null == currentTitle)
        {
            return false;
        }

        // 当前item分类名和上一个item分类名不同，则表示两item属于不同分类
        if (currentTitle.equals(previousTitle))
        {
            return false;
        }

        return true;
    }

    class ViewHolder
    {
        TextView tvDate, tvTime, tvContent, tvAddress;
        RoundImageView rivImage;
        LinearLayout llContent;
    }
}
