package com.dhh.test.mpcharttest;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.github.mikephil.charting.charts.ScatterChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.data.ScatterDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.Highlight;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by DHH on 2018/1/30.
 * 页面：散点图
 */

public class ScatterChartActivity extends Activity {

    private ScatterChart scatterChart;
    private Random random;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_scatter_chart );

        scatterChart = (ScatterChart) findViewById ( R.id.mScatterChart );

        random = new Random ();

        ArrayList<Entry> yVals = new ArrayList<> ();
        ArrayList<String> xVals = new ArrayList<>();//初始化横纵坐标内容
        for (int i = 0; i < 5; i++) {
            xVals.add((i + 1) + "月");
            yVals.add(new Entry(random.nextInt(1000), i));//产生数据
        }
        ScatterDataSet scatterDataSet = new ScatterDataSet(yVals, "小明每月支出");
        scatterDataSet.setColors( ColorTemplate.COLORFUL_COLORS);//设置丰富多彩的颜色
        ScatterData scatterData = new ScatterData(xVals, scatterDataSet);//生成Scatterdata对象

        scatterChart.setData(scatterData);//设置对应数据
        scatterChart.getLegend().setPosition( Legend.LegendPosition.BELOW_CHART_LEFT);
        scatterChart.getLegend().setForm(Legend.LegendForm.CIRCLE);
        scatterChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener () {
            @Override
            public void onValueSelected(Entry entry, int i, Highlight highlight) {
                Toast.makeText(ScatterChartActivity.this, "Something selected value = " + entry.getVal(), Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected() {
            }
        });

        scatterChart.getXAxis().setPosition( XAxis.XAxisPosition.BOTTOM);//设置X轴位置
        scatterChart.getAxisRight().setEnabled(false);//右侧Y轴关闭
        scatterChart.getAxisLeft().setAxisMinValue(0.0f);//设置最小Y值
        scatterChart.getXAxis().setGridColor( Color.RED);//设置纵向网格线条颜色
        scatterChart.getAxisLeft().setGridColor(Color.GREEN);//设置横向网格颜色
        scatterChart.setDescription("No Deal");//设置描述内容
        scatterChart.setDescriptionTextSize(20.f);//设置描述文字的字体颜色
        scatterChart.animateXY(1000, 1000);//动画效果
    }
}
