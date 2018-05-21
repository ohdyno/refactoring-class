package org.chartsmart;

import java.awt.*;

public class BarChart implements Chart {

    private final String comparisonMode;
    private static final String SINGLE_MODE = "rpfll";

    BarChart(String comparisonMode) {
        this.comparisonMode = comparisonMode;
    }

    private void draw(Graphics canvas) {
        String[] barCharts = createTitleForBarChart();
        if (comparisonMode.equals(SINGLE_MODE)) {
            int bottomY = 500;
            canvas.setColor(Color.CYAN);
            canvas.fillRect(112, bottomY - 200, 75, 200);
            canvas.fillRect(187, bottomY - 400, 75, 400);
            canvas.fillRect(262, bottomY - 300, 75, 300);
            canvas.fillRect(337, bottomY - 250, 75, 250);
            canvas.fillRect(412, bottomY - 340, 75, 340);
            canvas.setColor(Color.BLACK);
            canvas.setFont(new Font("Arial Black", Font.BOLD, 55));
            canvas.drawString(barCharts[0], 130, 400);
        } else {
            int bottomY = 300;
            canvas.setColor(Color.CYAN);
            canvas.fillRect(100, bottomY - 100, 40, 100);
            canvas.fillRect(140, bottomY - 200, 40, 200);
            canvas.fillRect(180, bottomY - 150, 40, 150);
            canvas.fillRect(220, bottomY - 125, 40, 125);
            canvas.fillRect(260, bottomY - 170, 40, 170);
            canvas.setColor(Color.RED);
            canvas.setFont(new Font("Arial Black", Font.BOLD, 25));
            canvas.drawString(barCharts[0], 130, 250);
            canvas.drawString(barCharts[1], 130, 270);
        }
    }

    private String[] createTitleForBarChart() {
        String[] barCharts = new String[2];
        barCharts[0] = "Bar Chart";
        if (!comparisonMode.equals(SINGLE_MODE)) {
            barCharts[1] = "Small";
        }
        return barCharts;
    }

    private void colorCanvas(Graphics canvas, int width) {
        if (comparisonMode.equals(SINGLE_MODE)) {
            canvas.setColor(Color.RED);
            canvas.fillRect(100, 90, width - 200, 420);
        } else {
            canvas.setColor(Color.BLACK);
            canvas.fillRect(95, 95, 210, 210);
        }
    }

    @Override
    public void draw(Graphics canvas, int width, int height) {
        colorCanvas(canvas, width);
        draw(canvas);
    }

    @Override
    public String title() {
        if (comparisonMode.equals(SINGLE_MODE)) {
            return "Bar Chart - Single Mode";
        } else {
            return "Bar Chart - Compare Mode";
        }
    }
}
