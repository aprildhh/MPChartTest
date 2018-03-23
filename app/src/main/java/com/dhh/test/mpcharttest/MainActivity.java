package com.dhh.test.mpcharttest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.github.mikephil.charting.charts.BubbleChart;
import com.github.mikephil.charting.charts.ScatterChart;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
    }

    //条形图
    public void barChart(View view) {
        startActivity ( new Intent ( this, BarChartActivity.class));
    }

    //折线图
    public void lineChart(View view) {
        startActivity ( new Intent ( this, LineChartActivity.class));
    }

    //饼图
    public void pieChart(View view) {
        startActivity ( new Intent ( this, PieActivity.class));
    }

    //散点图
    public void scatterChart(View view) {
        startActivity ( new Intent ( this, ScatterChartActivity.class));
    }

    //泡泡图
    public void bubbleChart(View view) {
        startActivity ( new Intent ( this, BubbleChartActivity.class));
    }

    //直方图（柱状图）
    public void BarGraph(View view) {
        startActivity ( new Intent ( this, LineChartActivity.class));
    }

    //雷达图
    public void radarChart(View view) {
        startActivity ( new Intent ( this, RadarChartActivity.class));
    }

    //组合图
    public void combinationChart(View view) {
    }

}
