package com.daoben.youwenmanager.ui.home.account;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.DisplayMetrics;

import com.daoben.youwenmanager.R;
import com.daoben.youwenmanager.ui.BaseActivtiy;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

public class StatisticsActivity extends BaseActivtiy
{
    private PieChart mPieChart;
    private String[] mParties;

    private Typeface mTfLight;
    private Typeface mTfRegular;

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
    }

    private void initData()
    {
        PieData mPieData = getPieData(4, 100);
        showChart(mPieChart, mPieData);
    }

    public PieData getPieData(int count, float range)
    {
        ArrayList<String> xValues = new ArrayList<String>();  //xVals用来表示每个饼块上的内容

        for (int i = 0; i < count; i++)
        {
            xValues.add("Quarterly" + (i + 1));  //饼块上显示成Quarterly1, Quarterly2, Quarterly3, Quarterly4
        }

        ArrayList<PieEntry> yValues = new ArrayList<PieEntry>();  //yVals用来表示封装每个饼块的实际数据

        // 饼图数据
        /**
         * 将一个饼形图分成四部分， 四部分的数值比例为14:14:34:38
         * 所以 14代表的百分比就是14%
         */
        float quarterly1 = 14;
        float quarterly2 = 30;
        float quarterly3 = 34;
        float quarterly4 = 38;

        yValues.add(new PieEntry(quarterly1, "Quarterly1"));
        yValues.add(new PieEntry(quarterly2, "Quarterly2"));
        yValues.add(new PieEntry(quarterly3, "Quarterly3"));
        yValues.add(new PieEntry(quarterly4, "Quarterly4"));
//                yValues.add(new PieEntry(quarterly1));
//                yValues.add(new PieEntry(quarterly2));
//                yValues.add(new PieEntry(quarterly3));
//                yValues.add(new PieEntry(quarterly4));

        //y轴的集合
        PieDataSet pieDataSet = new PieDataSet(yValues, "Quarterly Revenue 2014"/*显示在比例图上*/);
        pieDataSet.setSliceSpace(0f); //设置个饼状图之间的距离

        ArrayList<Integer> colors = new ArrayList<Integer>();

        // 饼图颜色
        colors.add(Color.rgb(205, 205, 205));
        colors.add(Color.rgb(114, 188, 223));
        colors.add(Color.rgb(255, 123, 124));
        colors.add(Color.rgb(57, 135, 200));

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
//        pieChart.setTransparentCircleRadius(44f); // 半透明圈
        //pieChart.setHoleRadius(0)  //实心圆
        pieChart.setExtraOffsets(5, 10, 5, 5);
        pieChart.setDrawSliceText(false);
        Description description = new Description();
        description.setText("测试饼状图");
        pieChart.setDescription(description);
        pieData.setValueTextSize(15);
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
        // mChart.setUnit(" €");
        // mChart.setDrawUnitsInChart(true);

        // add a selection listener
        //      mChart.setOnChartValueSelectedListener(this);
        // mChart.setTouchEnabled(false);

        //      mChart.setOnAnimationListener(this);

        pieChart.setCenterText("Quarterly Revenue");  //饼状图中间的文字

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
}
