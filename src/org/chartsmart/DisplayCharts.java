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
        drawPieChart(canvas);
    }

    private void drawPieChart(Graphics canvas) {
        colorCanvasForPieChart(canvas);

        String[] pieCharts = createPieChartTitle();

        drawPieChart(canvas, pieCharts);

    }

    private void drawPieChart(Graphics canvas, String[] pieCharts) {
        Font font;
        if (comparisonMode.equals(SINGLE_MODE)) {
            font = new Font("Bookman Old Style", Font.BOLD, 55);
            canvas.setColor(Color.WHITE);
            canvas.setFont(font);
            canvas.drawString(pieCharts[0], 200, 340);
        } else {
            font = new Font("Bookman Old Style", Font.BOLD, 30);
            canvas.setFont(font);
            canvas.setColor(Color.WHITE);
            for (int i = 0; i < 20; i++)
                canvas.drawString(pieCharts[0], 145, 205);
            canvas.drawString(pieCharts[1], 170, 235);
        }
    }

    private String[] createPieChartTitle() {
        String[] pieCharts = new String[2];
        if (comparisonMode.equals(SINGLE_MODE)) {
            pieCharts[0] = "Pie Chart";
        } else {
            pieCharts[1] = "Small";
            pieCharts[0] = "Pie Chart";
        }
        return pieCharts;
    }

    private void colorCanvasForPieChart(Graphics canvas) {
        if (comparisonMode.equals(SINGLE_MODE)) {
            Color blueBackGroundColor;
            blueBackGroundColor = Color.BLUE;
            canvas.setColor(blueBackGroundColor);
            canvas.fillOval(100, 100, 450, getHeight() - 150);
        } else {
            canvas.setColor(Color.BLUE);
            double canvasSize = 405;
            float padding = 90;
            int diameter = (int) (canvasSize - padding * 2);
            canvas.fillOval(100, 100, diameter, diameter);
        }
    }

}
