package com.daoben.youwenmanager.adapter;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.daoben.youwenmanager.R;

/**
 * @Description:gridview的Adapter
 * @author http://blog.csdn.net/finddreams
 */
public class MyGridAdapter extends BaseAdapter {
	private Context mContext;

	public String[] img_text = { "账号管理", "消费记账", "心情日记", "代办备忘", "号码归属", "出行天气",
			"驾考宝典", "娱乐游戏", "星座运势","开发中","开发中","开发中" };
	public int[] imgs = { R.mipmap.account, R.mipmap.money,
			R.mipmap.notebook, R.mipmap.today,
			R.mipmap.phone, R.mipmap.weather,
			R.mipmap.car, R.mipmap.game, R.mipmap.star,R.mipmap.developing, R.mipmap.developing,R.mipmap.developing};

	public MyGridAdapter(Context mContext) {
		super();
		this.mContext = mContext;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return img_text.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = LayoutInflater.from(mContext).inflate(
					R.layout.grid_item, parent, false);
		}
		TextView tv = BaseViewHolder.get(convertView, R.id.tv_item);
		ImageView iv = BaseViewHolder.get(convertView, R.id.iv_item);
		iv.setImageResource(imgs[position]);

		tv.setText(img_text[position]);
		return convertView;
	}

}
