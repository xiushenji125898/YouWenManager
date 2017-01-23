package com.daoben.youwenmanager.Util;

import android.content.Context;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/1/20.
 */

public class Util
{
    public static void showToast(Context context, String msg)
    {
        Toast toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 10);
        toast.show();
    }

    /**
     * dp2px
     *
     * @param context
     * @param dp
     * @return
     */
    public static int dp2px(Context context, int dp)
    {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                context.getResources().getDisplayMetrics());
    }

    /**
     * 获取系统时间
     * @param type
     * @return
     */
    public static String getSysTime(String type)
    {
        SimpleDateFormat formatter = new SimpleDateFormat(type);
        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
        String str = formatter.format(curDate);
        return str;
    }
}
