package com.dhh.test.mpcharttest;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.PercentFormatter;

import java.util.ArrayList;

/**
 * Created by DHH on 2018/1/30.
 * 页面：
 */

public class PieActivity extends Activity {
    private PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie);
        pieChart = (PieChart) findViewById(R.id.pie_chart);
        //1、基本设置
        pieChart.setDrawCenterText(false);  //饼状图中间文字不显示
        pieChart.setDescription("aaaaaaaaaaaaa");
        pieChart.setDrawHoleEnabled(false);    //设置实心
        pieChart.setRotationAngle(90); // 初始旋转角度

        //2、添加数据
        ArrayList<String> xValues = new ArrayList<String>();  //xVals用来表示每个饼块上的内容
        xValues.add("this is one");
        xValues.add("this is two");
        xValues.add("this is three");
        xValues.add("this is four");

        ArrayList<Entry> yValues = new ArrayList<Entry>();
        yValues.add(new Entry(0, 0));
        yValues.add(new Entry(0, 1));
        yValues.add(new Entry(0, 2));
        yValues.add(new Entry(5, 3));
        //3、y轴数据
        PieDataSet pieDataSet = new PieDataSet(yValues, ""/*显示在比例图上*/);
        pieDataSet.setSliceSpace(0f); //设置个饼状图之间的距离
        //4、设置颜色
        ArrayList<Integer> colors = new ArrayList<Integer>();
        colors.add( Color.rgb(205, 205, 205));
        colors.add(Color.rgb(114, 188, 223));
        colors.add(Color.rgb(255, 123, 124));
        colors.add(Color.rgb(57, 135, 200));
        pieDataSet.setColors(colors);
        //5、 设置数据
        PieData pieData = new PieData(xValues, pieDataSet);
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        float px = 5 * (metrics.densityDpi / 160f);
        pieDataSet.setSelectionShift(px); // 选中态多出的长度
        pieData.setValueFormatter(new PercentFormatter ());//显示百分比
        //6、去掉比例尺和说明
        Legend legend = pieChart.getLegend();//下标说明，false
        legend.setEnabled(true);
        pieChart.setDescription("wwwwwww");

        //7、显示百分比
        pieData.setValueFormatter(new PercentFormatter());

        //8、显示
        pieChart.setData(pieData);
    }
}
