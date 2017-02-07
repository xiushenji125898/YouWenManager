package com.daoben.youwenmanager.Util;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.daoben.youwenmanager.Dao.DaoAccountDao;
import com.daoben.youwenmanager.entity.DaoAccount;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/7.
 */

public class AccountUtil
{

    /**
     * 查询当天支出
     * @param dao
     * @return
     */
    public static double getToDayMoney(DaoAccountDao dao)
    {
        double d = 0;
        List<DaoAccount> list = dao.queryRaw("where date= ?",Util.getSysTime("yyyy-MM-dd"));
        for (int i = 0; i < list.size(); i++)
        {
            d+= list.get(i).getMoney();
        }
        return d;
    }

    /**
     * 查询本周支出
     * @param dao
     * @return
     */
    public static double getToWeekMoney(DaoAccountDao dao, Context mContext)
    {
        double d = 0;
//        select * from t_task t  where t.taskstarttime  > '2017/2/4 16:36:08' and t.taskstarttime <'2017/1/23 14:41:59'
//       String sql= "where date > '?' and date < '?'";
        List<DaoAccount> list = new ArrayList<>();
        SQLiteDatabase db = GreenDaoUtils.getSingleTon(mContext).getDb();
        String sql = "select * from " + dao.TABLENAME + " where date between  DATE('?') and  DATE('?')";

        Cursor c = db.rawQuery(sql, new String[]{"2017-02-07","2017-02-07"});
        if (c.moveToFirst())
        {
            int index_id = c.getColumnIndex("_id");
            int index_money = c.getColumnIndex("MONEY");
            int index_type = c.getColumnIndex("TYPE");
            int index_mode = c.getColumnIndex("MODE");
            int index_Date = c.getColumnIndex("DATE");
            int index_remark = c.getColumnIndex("REMARK");
            do
            {
                DaoAccount bean = new DaoAccount();
                bean.setId(c.getLong(index_id));
                bean.setMoney(c.getDouble(index_money));
                bean.setType(c.getInt(index_type));
                bean.setMode(c.getInt(index_mode));
                bean.setDate(c.getString(index_Date));
                bean.setRemark(c.getString(index_remark));
                list.add(bean);
            } while (c.moveToNext());

            if (!c.isClosed())
            {
                c.close();
                c = null;
            }
        }


        for (int i = 0; i < list.size(); i++)
        {
            d+= list.get(i).getMoney();
        }
        return d;
    }
}
