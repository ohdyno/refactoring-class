package org.chartsmart;

import javax.swing.*;
import java.awt.*;

public class DisplayCharts extends JPanel {
    private static final String SINGLE_MODE = "rpfll";
    private static final int BAR_CHART_TYPE = 406;
    private String comparisonMode;
    String chartTitle;
    private int chartType;

    /**
     * InitializeDrawArea
     */
    private void setChartTitle() {
        this.setPreferredSize(new Dimension(600, 600));
        if (chartType == BAR_CHART_TYPE) {
            BarChart barChart = new BarChart(comparisonMode);
            chartTitle = barChart.setBarChartTitle();
        } else {
            PieChart pieChart = new PieChart(comparisonMode);
            chartTitle = pieChart.setPieChartTitle();
        }
    }

    String getChartTitle() {
        return chartTitle;
    }

    public void initializeChart
            (int chartType, String mode, boolean setTitle) {
        this.chartType = chartType;
        this.comparisonMode = mode;
        if (setTitle) {
            setChartTitle();
        }
    }

    public void paint(Graphics g) {
        drawChart(g);
    }

    private void drawChart(Graphics canvas) {
        if (chartType == BAR_CHART_TYPE) {
            BarChart barChart = new BarChart(comparisonMode);
            barChart.drawBarChart(canvas, getWidth());
            return;
        }
        PieChart pieChart = new PieChart(comparisonMode);
        pieChart.drawPieChart(canvas, this);
    }

}
