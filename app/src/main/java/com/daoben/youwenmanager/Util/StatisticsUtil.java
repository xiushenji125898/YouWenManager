package com.daoben.youwenmanager.Util;

import com.daoben.youwenmanager.Dao.DaoAccountDao;
import com.daoben.youwenmanager.entity.DaoAccount;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/9.
 */

public class StatisticsUtil
{

    /**
     * 获取数据库最大年
     * @param dao
     * @return
     */
    public static String getMaxYear(DaoAccountDao dao) {
        String year = "";
        List<DaoAccount> list = new ArrayList<>();
        QueryBuilder queryBuilder = dao.queryBuilder();
        queryBuilder.orderDesc(DaoAccountDao.Properties.Year);
        list = queryBuilder.list();
        if (list.size()!=0)
        {
            year = list.get(0).getYear();
        }else
        {
            year = Util.getSysTime("yyyy");
        }
        return year;
    }

    /**
     * 获取数据库最大月
     * @param dao
     * @return
     */
    public static String getMaxMonth(DaoAccountDao dao) {
        String month = "";
        List<DaoAccount> list = new ArrayList<>();
        QueryBuilder queryBuilder = dao.queryBuilder();
        String year = getMaxYear(dao);
        queryBuilder.where(DaoAccountDao.Properties.Year.eq(year)).orderDesc(DaoAccountDao.Properties.Month);
        list = queryBuilder.list();
        if (list.size()!=0)
        {
            month = list.get(0).getMonth();
        }else
        {
            month = Util.getSysTime("MM");
        }
        return month;
    }
    /**
     * 获取数据库最小年
     * @param dao
     * @return
     */
    public static String getMinYear(DaoAccountDao dao) {
        List<DaoAccount> list = new ArrayList<>();
        QueryBuilder queryBuilder = dao.queryBuilder();
        String year = "";
        queryBuilder.orderAsc(DaoAccountDao.Properties.Year);
        list = queryBuilder.list();
        if (list.size()!=0)
        {
            year = list.get(0).getYear();
        }else
        {
            year = Util.getSysTime("yyyy");
        }
        return year;
    }

    /**
     * 获取数据库最小月
     * @param dao
     * @return
     */
    public static String getMinMonth(DaoAccountDao dao) {
        String month = "";
        List<DaoAccount> list = new ArrayList<>();
        QueryBuilder queryBuilder = dao.queryBuilder();
        String year = getMinYear(dao);
        queryBuilder.where(DaoAccountDao.Properties.Year.eq(year)).orderAsc(DaoAccountDao.Properties.Month);
        list = queryBuilder.list();
        if (list.size()!=0)
        {
            month = list.get(0).getMonth();
        }else
        {
            month = Util.getSysTime("MM");
        }
        return month;
    }

}
