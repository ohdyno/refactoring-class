package org.chartsmart;

import javax.swing.*;
import java.awt.*;

public class DisplayCharts extends JPanel {
    private static final int BAR_CHART_TYPE = 406;
    private Chart chart;

    String getChartTitle() {
        return chart.title();
    }

    public void initializeChart(int chartType, String mode, boolean setTitle) {
        if (setTitle) {
            this.setPreferredSize(new Dimension(600, 600));
            if (chartType == BAR_CHART_TYPE) {
                chart = new BarChart(mode);
            } else {
                chart = new PieChart(mode);
            }
        }
    }

    public void paint(Graphics g) {
        drawChart(g);
    }

    private void drawChart(Graphics canvas) {
        chart.draw(canvas, getWidth(), getHeight());
    }
}
