package com.dhh.test.mpcharttest;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BubbleChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BubbleData;
import com.github.mikephil.charting.data.BubbleDataSet;
import com.github.mikephil.charting.data.BubbleEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.Highlight;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by DHH on 2018/1/30.
 * 页面：
 */

public class BubbleChartActivity extends Activity{

    private BubbleChart mBubbleChart;
    private Random random;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_bubble_chart );

        mBubbleChart = (BubbleChart) findViewById(R.id.mBubbleChart);

        random = new Random ();

        ArrayList<BubbleEntry> yVals1 = new ArrayList<BubbleEntry>();
        ArrayList<BubbleEntry> yVals2 = new ArrayList<BubbleEntry>();
        ArrayList<BubbleEntry> yVals3 = new ArrayList<BubbleEntry>();

        ArrayList<String> xVals = new ArrayList<>();//初始化横纵坐标内容

        for (int i = 0; i < 10; i++) {

            xVals.add((i + 1) + "月");

            float val = (float) (Math.random() * 30);
            float size = (float) (Math.random() * 40);

            yVals1.add(new BubbleEntry(i, val, size));
        }

        for (int i = 0; i < 20; i++) {
            float val = (float) (Math.random() * 40);
            float size = (float) (Math.random() * 50);

            yVals2.add(new BubbleEntry(i, val, size));
        }

        for (int i = 0; i < 30; i++) {
            float val = (float) (Math.random() * 50);
            float size = (float) (Math.random() * 60);

            yVals3.add(new BubbleEntry(i, val, size));
        }

        BubbleDataSet set1 = new BubbleDataSet(yVals1, "优秀");
        //可以谁知alpha
        set1.setColor(ColorTemplate.COLORFUL_COLORS[0]);
        set1.setDrawValues(true);
        BubbleDataSet set2 = new BubbleDataSet(yVals2, "及格");
        set2.setColor(ColorTemplate.COLORFUL_COLORS[1]);
        set2.setDrawValues(true);
        BubbleDataSet set3 = new BubbleDataSet(yVals3, "不及格");
        set3.setColor(ColorTemplate.COLORFUL_COLORS[2]);
        set3.setDrawValues(true);

        ArrayList<BubbleDataSet> dataSets = new ArrayList<BubbleDataSet>();
        dataSets.add(set1);
        dataSets.add(set2);
        dataSets.add(set3);

        BubbleData data = new BubbleData (xVals,set1);
        data.setDrawValues(false);
        data.setValueTextSize(8f);
        data.setValueTextColor(Color.WHITE);
        data.setHighlightCircleWidth(1.5f);

        mBubbleChart.setData(data);
        mBubbleChart.invalidate();

        //默认动画
        mBubbleChart.animateXY(3000, 3000);
//        BubbleDataSet scatterDataSet = new BubbleDataSet(yVals, "小明每月支出");
//        scatterDataSet.setColors( ColorTemplate.COLORFUL_COLORS);//设置丰富多彩的颜色
//        BubbleData scatterData = new BubbleData(xVals, scatterDataSet);//生成Scatterdata对象

//        mBubbleChart.setData(scatterData);//设置对应数据
        mBubbleChart.getLegend().setPosition( Legend.LegendPosition.BELOW_CHART_LEFT);
        mBubbleChart.getLegend().setForm(Legend.LegendForm.CIRCLE);
        mBubbleChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener () {
            @Override
            public void onValueSelected(Entry entry, int i, Highlight highlight) {
                Toast.makeText(BubbleChartActivity.this, "Something selected value = " + entry.getVal(), Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected() {
            }
        });

        mBubbleChart.getXAxis().setPosition( XAxis.XAxisPosition.BOTTOM);//设置X轴位置
        mBubbleChart.getAxisRight().setEnabled(false);//右侧Y轴关闭
        mBubbleChart.getAxisLeft().setAxisMinValue(0.0f);//设置最小Y值
        mBubbleChart.getXAxis().setGridColor( Color.RED);//设置纵向网格线条颜色
        mBubbleChart.getAxisLeft().setGridColor(Color.GREEN);//设置横向网格颜色
        mBubbleChart.setDescription("No Deal");//设置描述内容
        mBubbleChart.setDescriptionTextSize(20.f);//设置描述文字的字体颜色
        mBubbleChart.animateXY(1000, 1000);//动画效果
    }
}
