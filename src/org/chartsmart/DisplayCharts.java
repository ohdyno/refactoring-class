package org.chartsmart;

import javax.swing.*;
import java.awt.*;

public class DisplayCharts extends JPanel {
    private static final String SINGLE_MODE = "rpfll";
    private static final int BAR_CHART_TYPE = 406;
    private String comparisonMode;
    private String chartTitle;
    private int chartType;

    /**
     * InitializeDrawArea
     */
    private void setChartTitle() {
        this.setPreferredSize(new Dimension(600, 600));
        if (chartType == BAR_CHART_TYPE) {
            if (comparisonMode.equals(SINGLE_MODE)) {
                chartTitle = "Bar Chart - Single Mode";
            } else {
                chartTitle = "Bar Chart - Compare Mode";
            }
        } else {
            if (comparisonMode.equals(SINGLE_MODE)) {
                chartTitle = "Pie Chart - Single Mode";
            } else {
                chartTitle = "Pie Chart - Compare Mode";
            }
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
            barChart.colorCanvasForBarChart(canvas, getWidth());
            String[] barCharts = barChart.createTitleForBarChart();

            barChart.drawBarChart(canvas, barCharts);

            return;
        }
        PieChart pieChart = new PieChart(comparisonMode);
        pieChart.drawPieChart(canvas, this);
    }

}
