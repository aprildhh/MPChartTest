package com.dhh.test.mpcharttest;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ValueFormatter;

import java.util.ArrayList;

/**
 * Created by DHH on 2018/1/30.
 * 页面：
 */

@SuppressLint("Registered")
public class BarChartActivity extends Activity {
    private BarChart barChart;
    private XAxis xAxis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_chart);
        barChart= (BarChart) findViewById(R.id.barChart);
        //1、基本设置
        xAxis=barChart.getXAxis();
        xAxis.setDrawAxisLine(true);
        xAxis.setDrawGridLines(false);
        barChart.setDrawGridBackground(false); // 是否显示表格颜色
        barChart.getAxisLeft().setDrawAxisLine(false);
        barChart.setTouchEnabled(false); // 设置是否可以触摸
        barChart.setDragEnabled(true);// 是否可以拖拽
        barChart.setScaleEnabled(true);// 是否可以缩放
        //2、y轴和比例尺

        barChart.setDescription("四个季度");// 数据描述

        barChart.getAxisLeft().setEnabled(false);
        barChart.getAxisRight().setEnabled(false);

        Legend legend = barChart.getLegend();//隐藏比例尺
        legend.setEnabled(false);

        //3、x轴数据,和显示位置
        ArrayList<String> xValues = new ArrayList<String>();
        xValues.add("一季度");
        xValues.add("二季度");
        xValues.add("三季度");
        xValues.add("四季度");

        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);//数据位于底部


        //4、y轴数据
        ArrayList<BarEntry> yValues = new ArrayList<BarEntry>();
        //new BarEntry(20, 0)前面代表数据，后面代码柱状图的位置；
        yValues.add(new BarEntry(20, 0));
        yValues.add(new BarEntry(18, 1));
        yValues.add(new BarEntry(4, 2));
        yValues.add(new BarEntry(45, 3));

        //5、设置显示的数字为整形
        BarDataSet barDataSet=new BarDataSet(yValues,"");
        barDataSet.setValueFormatter(new ValueFormatter () {
            @Override
            public String getFormattedValue(float v) {
                int n = (int) v;
                return n + "";
            }
        });
        //6、设置柱状图的颜色
        barDataSet.setColors(new int[]{Color.rgb(104, 202, 37), Color.rgb(192, 32, 32),
                Color.rgb(34, 129, 197), Color.rgb(175, 175, 175)});
        //7、显示，柱状图的宽度和动画效果
        BarData barData = new BarData(xValues, barDataSet);
        barDataSet.setBarSpacePercent(40f);//值越大，柱状图就越宽度越小；
        barChart.animateY(1000);
        barChart.setData(barData); //
    }
}
