package com.daoben.youwenmanager.Util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.daoben.youwenmanager.Dao.DaoMaster;
import com.daoben.youwenmanager.Dao.DaoSession;


/**
 * Created by Administrator on 2016/12/23.
 */

public class GreenDaoUtils
{
    private DaoMaster.DevOpenHelper mHelper;
    private SQLiteDatabase db;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;
    private Context context;

    private static GreenDaoUtils greenDaoUtils;

    private GreenDaoUtils(Context context)
    {
        this.context = context;
    }

    public static GreenDaoUtils getSingleTon(Context context)
    {
        if (greenDaoUtils == null)
        {
            greenDaoUtils = new GreenDaoUtils(context);
        }
        return greenDaoUtils;
    }

    private void initGreenDao()
    {
        mHelper = new DaoMaster.DevOpenHelper(context, "mSms-db", null);
        db = mHelper.getWritableDatabase();
        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
    }

    public DaoSession getmDaoSession()
    {
        if (mDaoMaster == null)
        {
            initGreenDao();
        }
        return mDaoSession;
    }

    public SQLiteDatabase getDb()
    {
        if (db == null)
        {
            initGreenDao();
        }
        return db;
    }

}
