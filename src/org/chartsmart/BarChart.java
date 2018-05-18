package org.chartsmart;

import java.awt.*;

public class BarChart {

    private final String comparisonMode;
    private static final String SHARED_MODE = "shareddisplay";
    private static final String SINGLE_MODE = "rpfll";

    public BarChart(String comparisonMode) {
        this.comparisonMode = comparisonMode;
    }

    void drawBarChart(Graphics canvas, String[] barCharts) {
        Font font;
        if (comparisonMode.equals(SHARED_MODE)) {
            font = new Font("Arial Black", Font.BOLD, 25);
            canvas.setColor(Color.CYAN);
            int bottomY = 300;
            canvas.fillRect(100, bottomY - 100, 40, 100);
            canvas.fillRect(140, bottomY - 200, 40, 200);
            canvas.fillRect(180, bottomY - 150, 40, 150);
            canvas.fillRect(220, bottomY - 125, 40, 125);
            canvas.fillRect(260, bottomY - 170, 40, 170);
            canvas.setColor(Color.RED);
            canvas.setFont(font);
            canvas.drawString(barCharts[0], 130, 250);
            canvas.drawString(barCharts[1], 130, 270);
        } else {
            int bottomY = 500;
            canvas.setColor(Color.CYAN);
            canvas.fillRect(112, bottomY - 200, 75, 200);
            canvas.fillRect(187, bottomY - 400, 75, 400);
            canvas.fillRect(262, bottomY - 300, 75, 300);
            canvas.fillRect(337, bottomY - 250, 75, 250);
            canvas.fillRect(412, bottomY - 340, 75, 340);
            font = new Font("Arial Black", Font.BOLD, 55);
            canvas.setColor(Color.BLACK);
            canvas.setFont(font);
            canvas.drawString(barCharts[0], 130, 400);
        }
    }

    String[] createTitleForBarChart() {
        String[] barCharts;
        if (comparisonMode.equals(SINGLE_MODE)) {
            barCharts = new String[1];
            barCharts[0] = "Bar Chart";
        } else {
            barCharts = new String[2];
            int i = 0;
            barCharts[i++] = "Bar Chart";
            barCharts[i++] = "Small";
        }
        return barCharts;
    }

    void colorCanvasForBarChart(Graphics canvas, int width) {
        if (comparisonMode.equals(SINGLE_MODE)) {
            Color backGroundColor = Color.RED;
            canvas.setColor(backGroundColor);
            canvas.fillRect(100, 90, width - 200, 420);
        } else {
            canvas.setColor(Color.BLACK);
            canvas.fillRect(95, 95, 210, 210);
        }
    }

}
