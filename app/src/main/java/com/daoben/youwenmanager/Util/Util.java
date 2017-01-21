package com.daoben.youwenmanager.Util;

import android.content.Context;
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
}
