package com.daoben.youwenmanager.ui.home.notebook;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.daoben.youwenmanager.R;
import com.daoben.youwenmanager.Util.Util;
import com.daoben.youwenmanager.ui.BaseActivtiy;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AddNoteActivity extends BaseActivtiy
{
    private TextView tvTime;
    private TextView tvAddress;
    private EditText etContent;
    //声明AMapLocationClient类对象
    public AMapLocationClient mLocationClient = null;
    //声明AMapLocationClientOption对象
    public AMapLocationClientOption mLocationOption = null;
    //声明定位回调监听器
    AMapLocationListener mLocationListener;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        setupToolbar();
        setTitle("写日记");
        setSaveVisiblty(true);
        initView();
        initDate();
    }

    private void initDate()
    {
        tvTime.setText(Util.getSysTime("yyyy年MM月dd日 HH:mm"));

    }

    private void initView()
    {
        tvTime = (TextView) findViewById(R.id.tv_addnote_time);
        tvAddress = (TextView) findViewById(R.id.tv_addnote_address);
        etContent = (EditText) findViewById(R.id.et_addnote_content);
        //声明定位回调监听器
        mLocationListener = new AMapLocationListener()
        {
            @Override
            public void onLocationChanged(AMapLocation amapLocation)
            {
                if (amapLocation != null)
                {
                    if (amapLocation.getErrorCode() == 0)
                    {
                        //可在其中解析amapLocation获取相应内容。
//                        amapLocation.getLocationType();//获取当前定位结果来源，如网络定位结果，详见定位类型表
//                        amapLocation.getLatitude();//获取纬度
//                        amapLocation.getLongitude();//获取经度
//                        amapLocation.getAccuracy();//获取精度信息
//                        amapLocation.getAddress();//地址，如果option中设置isNeedAddress为false，则没有此结果，网络定位结果中会有地址信息，GPS定位不返回地址信息。
//                        amapLocation.getCountry();//国家信息
//                        amapLocation.getProvince();//省信息
                        String city = amapLocation.getCity();//城市信息
                        String district = amapLocation.getDistrict();//城区信息
                        String street = amapLocation.getStreet();//街道信息
//                        amapLocation.getStreetNum();//街道门牌号信息
//                        amapLocation.getCityCode();//城市编码
//                        amapLocation.getAdCode();//地区编码
                        String aoiName = amapLocation.getAoiName();//获取当前定位点的AOI信息
//                        amapLocation.getBuildingId();//获取当前室内定位的建筑物Id
//                        amapLocation.getFloor();//获取当前室内定位的楼层
//                        //获取定位时间
//                        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                        Date date = new Date(amapLocation.getTime());
//                        df.format(date);
//                        Log.e("获取当前定位结果来源",amapLocation.getLocationType()+"");
//                        Log.e("获取纬度",amapLocation.getLatitude()+"");
//                        Log.e("获取精度信息",amapLocation.getLongitude()+"");
//                        Log.e("地址",amapLocation.getAccuracy()+"");
//                        Log.e("国家信息",amapLocation.getAddress()+"");
//                        Log.e("省信息",amapLocation.getCountry()+"");
//                        Log.e("城市信息",amapLocation.getProvince()+"");
//                        Log.e("城区信息",amapLocation.getCity()+"");
//                        Log.e("街道信息",amapLocation.getDistrict()+"");
//                        Log.e("街道门牌号信息",amapLocation.getStreet()+"");
//                        Log.e("城市编码",amapLocation.getStreetNum()+"");
//                        Log.e("地区编码",amapLocation.getCityCode()+"");
//                        Log.e("获取当前定位点的AOI信息",amapLocation.getAoiName()+"");
//                        Log.e("获取当前室内定位的建筑物Id",amapLocation.getBuildingId()+"");
//                        Log.e("获取当前室内定位的楼层",amapLocation.getFloor()+"");
                    tvAddress.setText(city+district+street+aoiName);

                    } else
                    {
                        //定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
                        Log.e("AmapError", "location Error, ErrCode:"
                                + amapLocation.getErrorCode() + ", errInfo:"
                                + amapLocation.getErrorInfo());
                    }
                }
            }
        };
        //初始化定位
        mLocationClient = new AMapLocationClient(getApplicationContext());
        //设置定位回调监听
        mLocationClient.setLocationListener(mLocationListener);
        //初始化AMapLocationClientOption对象
        mLocationOption = new AMapLocationClientOption();

        //设置定位模式为AMapLocationMode.Hight_Accuracy，高精度模式。
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        //设置是否返回地址信息（默认返回地址信息）
        mLocationOption.setNeedAddress(true);
        //设置是否允许模拟位置,默认为false，不允许模拟位置
        mLocationOption.setMockEnable(false);
        //单位是毫秒，默认30000毫秒，建议超时时间不要低于8000毫秒。
        mLocationOption.setHttpTimeOut(20000);
        //关闭缓存机制
        mLocationOption.setLocationCacheEnable(false);

        //给定位客户端对象设置定位参数
        mLocationClient.setLocationOption(mLocationOption);
        //启动定位
        mLocationClient.startLocation();
    }
}
