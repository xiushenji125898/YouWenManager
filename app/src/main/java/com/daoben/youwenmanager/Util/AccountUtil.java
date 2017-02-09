package com.daoben.youwenmanager.Util;

import android.content.Context;
import android.util.Log;

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
//    public static DaoAccountDao dao = YouWenApplication.getApplication().getDaoSession().getDaoAccountDao();

    /**
     * 查询当天支出
     *
     * @return
     */
    public static double getToDayMoney(DaoAccountDao dao, Context mContext)
    {
        double d = 0;
        String year = Util.getSysTime("yyyy");
        String month = Util.getSysTime("M");
        String day = Util.getSysTime("d");
        Log.e("day ", "------------------" + day + "----------------------------");
        List<DaoAccount> dayList = new ArrayList<>();

        QueryBuilder queryBuilder = dao.queryBuilder();
        queryBuilder.where(DaoAccountDao.Properties.Year.eq(year), DaoAccountDao.Properties.Month.eq(month), DaoAccountDao.Properties.Day.eq(day));
//        queryBuilder.and(DaoAccountDao.Properties.Year.eq(year),DaoAccountDao.Properties.Month.eq(month),DaoAccountDao.Properties.Day.eq(day));
        dayList = queryBuilder.list();
        if (dayList.size() > 0)
        {
            for (int i = 0; i < dayList.size(); i++)
            {
                d += dayList.get(i).getMoney();
            }
        }
        return d;
    }

    /**
     * 查询本周支出
     *
     * @param dao
     * @return
     */
    public static double getToWeekMoney(DaoAccountDao dao, Context mContext)
    {
        double d = 0;
        String year = Util.getSysTime("yyyy");
        int week = Util.getWeek();
        Log.e("week", "====================" + week + "============================");
        List<DaoAccount> list = new ArrayList<>();

        QueryBuilder queryBuilder = dao.queryBuilder();

        queryBuilder.where(DaoAccountDao.Properties.Year.eq(year), DaoAccountDao.Properties.Week.eq(week + ""));
        list = queryBuilder.list();
        if (list.size() > 0)
        {
            for (int i = 0; i < list.size(); i++)
            {
                d += list.get(i).getMoney();
            }
        }
        return d;
    }

    /**
     * 查询本月支出
     *
     * @param dao
     * @return
     */
    public static double getToMonthMoney(DaoAccountDao dao, Context mContext)
    {
        double d = 0;
        String year = Util.getSysTime("yyyy");
        String month = Util.getSysTime("M");
        List<DaoAccount> list = new ArrayList<DaoAccount>();
        QueryBuilder queryBuilder = dao.queryBuilder();
        queryBuilder.where(DaoAccountDao.Properties.Year.eq(year), DaoAccountDao.Properties.Month.eq(month));
        list = queryBuilder.list();
        if (list.size() > 0)
        {
            for (int i = 0; i < list.size(); i++)
            {
                d += list.get(i).getMoney();
            }
        }
        return d;
    }
}
