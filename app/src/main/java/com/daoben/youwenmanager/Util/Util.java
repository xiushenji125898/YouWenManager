package com.daoben.youwenmanager.Util;

import android.content.Context;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/1/20.
 */

public class Util
{
    public static void showToast(Context context,String msg)
    {
        Toast toast = Toast.makeText(context,msg,Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,10);
        toast.show();
    }

    /**
     * dp2px
     * @param context
     * @param dp
     * @return
     */
    public static int dp2px(Context context,int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                context.getResources().getDisplayMetrics());
    }
}
