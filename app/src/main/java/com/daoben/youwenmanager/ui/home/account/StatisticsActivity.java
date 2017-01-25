package com.daoben.youwenmanager.ui.home.account;

import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.daoben.youwenmanager.R;
import com.daoben.youwenmanager.Util.Util;
import com.daoben.youwenmanager.ui.BaseActivtiy;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

public class StatisticsActivity extends BaseActivtiy implements View.OnClickListener
{
    private PieChart mPieChart;
    private ImageView ivUp, ivDown;
    private TextView tvShwoYear;
    private static final int maxYear = 2017;
    private static final int maxMonth = 1;
    private static final int minYear = 2016;
    private static final int minMonth = 6;
    private int year;
    private int month;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        setupToolbar();
        setTitle("消费统计");
        initView();
        initData();
    }

    private void initView()
    {
        mPieChart = (PieChart) findViewById(R.id.spread_pie_chart);
        ivUp = (ImageView) findViewById(R.id.iv_up);
        ivDown = (ImageView) findViewById(R.id.iv_down);
        tvShwoYear = (TextView) findViewById(R.id.tv_yearandmonth);
    }

    private void initData()
    {
        PieData mPieData = getPieData(4, 100);
        showChart(mPieChart, mPieData);
//        tvShwoYear.setText(maxYear + "年" + maxMonth + "月");
        year = maxYear;
        month = maxMonth;
        setTvShowYear(year, month);
        tvShwoYear.setOnClickListener(this);
        ivUp.setOnClickListener(this);
        ivDown.setOnClickListener(this);
    }

    /**
     * 修改时间显示
     *
     * @param year
     * @param month
     */
    private void setTvShowYear(int year, int month)
    {
        tvShwoYear.setText(year + " 年 " + month + " 月");
    }

    public PieData getPieData(int count, float range)
    {
//        ArrayList<String> xValues = new ArrayList<String>();  //xVals用来表示每个饼块上的内容
//
//        for (int i = 0; i < count; i++)
//        {
//            xValues.add("Quarterly" + (i + 1));  //饼块上显示成Quarterly1, Quarterly2, Quarterly3, Quarterly4
//        }

        ArrayList<PieEntry> yValues = new ArrayList<PieEntry>();  //yVals用来表示封装每个饼块的实际数据

        // 饼图数据

        String[] name = new String[]{"餐饮", "网购", "交通", "衣物", "购物", "娱乐", "理财", "缴费", "学习", "其他"};
        float[] values = new float[]{14, 25, 32, 44, 65, 56, 78, 23, 21, 46};
        for (int i = 0; i < name.length; i++)
        {
            yValues.add(new PieEntry(values[i], name[i]));
        }
//                yValues.add(new PieEntry(quarterly1));
//                yValues.add(new PieEntry(quarterly2));
//                yValues.add(new PieEntry(quarterly3));
//                yValues.add(new PieEntry(quarterly4));

        //y轴的集合
        PieDataSet pieDataSet = new PieDataSet(yValues, ""/*显示在比例图上*/);
        pieDataSet.setSliceSpace(0f); //设置个饼状图之间的距离

        ArrayList<Integer> colors = new ArrayList<Integer>();

        // 饼图颜色
//        colors.add(Color.rgb(205, 205, 205));
//        colors.add(Color.rgb(114, 188, 223));
//        colors.add(Color.rgb(255, 123, 124));
        colors.add(Color.parseColor("#7fff5454"));
        colors.add(Color.parseColor("#ff69b4"));
        colors.add(Color.parseColor("#eb4f38"));
        colors.add(Color.parseColor("#ffd4bc77"));
        colors.add(Color.parseColor("#FF4081"));
        colors.add(Color.parseColor("#ff00ff"));
        colors.add(Color.parseColor("#87d0f2"));
        colors.add(Color.parseColor("#ffb6c1"));
        colors.add(Color.parseColor("#ff9428"));
        colors.add(Color.parseColor("#ff4500"));

        pieDataSet.setColors(colors);

        DisplayMetrics metrics = getResources().getDisplayMetrics();
        float px = 5 * (metrics.densityDpi / 160f);
        pieDataSet.setSelectionShift(px); // 选中态多出的长度

        PieData pieData = new PieData(pieDataSet);

        return pieData;

    }

    private void showChart(PieChart pieChart, PieData pieData)
    {
//        pieChart.setHoleColorTransparent(true);
        pieChart.setHoleRadius(40f);  //半径
        pieChart.setTransparentCircleRadius(20f); // 半透明圈
        //pieChart.setHoleRadius(0)  //实心圆
        pieChart.setExtraOffsets(5, 10, 5, 5);
        //设置是否显示饼图文字
        pieChart.setDrawSliceText(true);
        Description description = new Description();
        description.setText("");
        pieChart.setDescription(description);
        pieData.setValueTextSize(15);
        pieData.setValueTextColor(Color.parseColor("#ffffff"));
        // mChart.setDrawYValues(true);
        pieChart.setDrawCenterText(true);  //饼状图中间可以添加文字

        pieChart.setDrawHoleEnabled(true);

        pieChart.setRotationAngle(90); // 初始旋转角度

        // draws the corresponding description value into the slice
        // mChart.setDrawXValues(true);

        // enable rotation of the chart by touch
        pieChart.setRotationEnabled(true); // 可以手动旋转

        // display percentage values
        pieChart.setUsePercentValues(true);  //显示成百分比
//        pieChart.setUnit(" ￥");
        // mChart.setDrawUnitsInChart(true);

        // add a selection listener
        //      mChart.setOnChartValueSelectedListener(this);
        // mChart.setTouchEnabled(false);

        //      mChart.setOnAnimationListener(this);

        pieChart.setCenterText("消费统计图");  //饼状图中间的文字

        //设置数据
        pieChart.setData(pieData);

        // undo all highlights
        //      pieChart.highlightValues(null);
        //      pieChart.invalidate();

        Legend mLegend = pieChart.getLegend();  //设置比例图
        mLegend.setPosition(Legend.LegendPosition.BELOW_CHART_LEFT);  //最右边显示
        //      mLegend.setForm(LegendForm.LINE);  //设置比例图的形状，默认是方形
        mLegend.setFormSize(12f);//比例块字体大小
        //设置比例块换行...
        mLegend.setWordWrapEnabled(true);
//        mLegend.setDirection(Legend.LegendDirection.LEFT_TO_RIGHT);
        mLegend.setXEntrySpace(7f);
        mLegend.setYEntrySpace(5f);

//        mLegend.setTextColor(getResources().getColor(R.color.app_green_alpha));
//        mLegend.setForm(Legend.LegendForm.SQUARE);//设置比例块形状，默认为方块

        pieChart.animateXY(1000, 1000);  //设置动画
        // mChart.spin(2000, 0, 360);
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.tv_yearandmonth:

                break;
            case R.id.iv_up:
                if (year == minYear)
                {
                    if (month - 1 < minMonth)
                    {
                        Util.showToast(this, "已是最早记账月份");
                    } else
                    {
                        month = month - 1;
                        setTvShowYear(year, month);
                    }
                } else if (year > minYear)
                {
                    if (month - 1 < 1)
                    {
                        month = 12;
                        year = year - 1;
                        setTvShowYear(year, month);
                    }
                }
                break;
            case R.id.iv_down:
                if (year < maxYear)
                {
                    if (month + 1 > 12)
                    {
                        month = 1;
                        year = year + 1;
                        setTvShowYear(year, month);

                    } else
                    {
                        month = month + 1;
                        setTvShowYear(year, month);
                    }
                } else if (year == maxYear)
                {
                    if (month + 1 > maxMonth)
                    {
                        Util.showToast(this, "已是最后记账月份");
                    }else
                    {
                        month = month + 1;
                        setTvShowYear(year, month);
                    }
                }
                break;
        }
    }
}
