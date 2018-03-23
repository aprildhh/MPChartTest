package com.dhh.test.mpcharttest;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

/**
 * Created by DHH on 2018/1/30.
 * 页面：
 */

public class RadarChartActivity extends Activity{

    private RadarChart mChart;
    private Typeface tf;
    private String[] mParties = new String[] {
            "Party A", "Party B", "Party C", "Party D", "Party E", "Party F", "Party G", "Party H",
            "Party I"
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView(R.layout.activity_radarchart);

        mChart = (RadarChart) findViewById(R.id.mRadarChar);
//        tf = Typeface.createFromAsset(getAssets(), "OpenSans-Regular.ttf");
        // 描述，在底部
        mChart.setDescription("我是描述");
        // 绘制线条宽度，圆形向外辐射的线条
        mChart.setWebLineWidth(1.5f);
        // 内部线条宽度，外面的环状线条
        mChart.setWebLineWidthInner(1.0f);
        // 所有线条WebLine透明度
        mChart.setWebAlpha(100);

        setData();

        XAxis xAxis = mChart.getXAxis();
        // X坐标值字体样式
//        xAxis.setTypeface(tf);
        // X坐标值字体大小
        xAxis.setTextSize(12f);

        YAxis yAxis = mChart.getYAxis();
        // Y坐标值字体样式
//        yAxis.setTypeface(tf);
        // Y坐标值标签个数
        yAxis.setLabelCount(6);
        // Y坐标值字体大小
        yAxis.setTextSize(15f);
        // Y坐标值是否从0开始
        yAxis.setStartAtZero(true);

        Legend l = mChart.getLegend();
        // 图例位置
        l.setPosition( Legend.LegendPosition.LEFT_OF_CHART);
        // 图例字体样式
        l.setTypeface(tf);
        // 图例X间距
        l.setXEntrySpace(2f);
        // 图例Y间距
        l.setYEntrySpace(1f);

    }

    private void setData() {
        float mult = 150;
        int cnt = 9; // 不同的维度Party A、B、C...总个数

        // Y的值，数据填充
        ArrayList<Entry> yVals1 = new ArrayList<Entry>();
        ArrayList<Entry> yVals2 = new ArrayList<Entry>();

        // IMPORTANT: In a PieChart, no values (Entry) should have the same
        // xIndex (even if from different DataSets), since no values can be
        // drawn above each other.
        for (int i = 0; i < cnt; i++) {
            yVals1.add(new Entry((float) (Math.random() * mult) + mult / 2, i));
        }

        for (int i = 0; i < cnt; i++) {
            yVals2.add(new Entry((float) (Math.random() * mult) + mult / 2, i));
        }

        // Party A、B、C..
        ArrayList<String> xVals = new ArrayList<String>();

        for (int i = 0; i < cnt; i++)
            xVals.add(mParties[i % mParties.length]);

        RadarDataSet set1 = new RadarDataSet(yVals1, "Set 1");
        // Y数据颜色设置
        set1.setColor( ColorTemplate.VORDIPLOM_COLORS[0]);
        // 是否实心填充区域
        set1.setDrawFilled(true);
        // 数据线条宽度
        set1.setLineWidth(2f);

        RadarDataSet set2 = new RadarDataSet(yVals2, "Set 2");
        set2.setColor(ColorTemplate.VORDIPLOM_COLORS[4]);
        set2.setDrawFilled(true);
        set2.setLineWidth(2f);

        ArrayList<RadarDataSet> sets = new ArrayList<RadarDataSet>();
        sets.add(set1);
        sets.add(set2);

        RadarData data = new RadarData(xVals, sets);
        // 数据字体样式
        data.setValueTypeface(tf);
        // 数据字体大小
        data.setValueTextSize(8f);
        // 是否绘制Y值到图表
        data.setDrawValues(true);

        mChart.setData(data);

        mChart.invalidate();
    }
}
