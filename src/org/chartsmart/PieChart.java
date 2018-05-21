package org.chartsmart;

import java.awt.*;

class PieChart implements Chart {
    private static final String SINGLE_MODE = "rpfll";
    private final String comparisonMode;

    PieChart(String comparisonMode) {
        this.comparisonMode = comparisonMode;
    }

    private void colorCanvas(Graphics canvas, int height) {
        if (comparisonMode.equals(SINGLE_MODE)) {
            canvas.setColor(Color.BLUE);
            canvas.fillOval(100, 100, 450, height - 150);
        } else {
            canvas.setColor(Color.BLUE);
            canvas.fillOval(100, 100, 225, 225);
        }
    }

    private String[] createPieChartTitle() {
        String[] pieCharts = new String[2];
        pieCharts[0] = "Pie Chart";
        if (!comparisonMode.equals(SINGLE_MODE)) {
            pieCharts[1] = "Small";
        }
        return pieCharts;
    }

    private void draw(Graphics canvas) {
        String[] pieCharts = createPieChartTitle();
        if (comparisonMode.equals(SINGLE_MODE)) {
            canvas.setColor(Color.WHITE);
            canvas.setFont(new Font("Bookman Old Style", Font.BOLD, 55));
            canvas.drawString(pieCharts[0], 200, 340);
        } else {
            canvas.setFont(new Font("Bookman Old Style", Font.BOLD, 30));
            canvas.setColor(Color.WHITE);
            canvas.drawString(pieCharts[0], 145, 205);
            canvas.drawString(pieCharts[1], 170, 235);
        }
    }

    public void draw(Graphics canvas, int width, int height) {
        colorCanvas(canvas, height);
        draw(canvas);
    }

    public String title() {
        if (comparisonMode.equals(SINGLE_MODE)) {
            return "Pie Chart - Single Mode";
        } else {
            return "Pie Chart - Compare Mode";
        }
    }
}
