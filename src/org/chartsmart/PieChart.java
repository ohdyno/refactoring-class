package org.chartsmart;

import java.awt.*;

class PieChart implements Chart {
    private static final String SINGLE_MODE = "rpfll";
    private final String comparisonMode;

    PieChart(String comparisonMode) {
        this.comparisonMode = comparisonMode;
    }

    private void colorCanvasForPieChart(Graphics canvas, int height) {
        if (comparisonMode.equals(SINGLE_MODE)) {
            Color blueBackGroundColor;
            blueBackGroundColor = Color.BLUE;
            canvas.setColor(blueBackGroundColor);
            canvas.fillOval(100, 100, 450, height - 150);
        } else {
            canvas.setColor(Color.BLUE);
            double canvasSize = 405;
            float padding = 90;
            int diameter = (int) (canvasSize - padding * 2);
            canvas.fillOval(100, 100, diameter, diameter);
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

    private void draw(Graphics canvas, String[] pieCharts) {
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

    public void draw(Graphics canvas, int width, int height) {
        colorCanvasForPieChart(canvas, height);

        String[] pieCharts = createPieChartTitle();

        draw(canvas, pieCharts);
    }

    public String title() {
        if (comparisonMode.equals(SINGLE_MODE)) {
            return "Pie Chart - Single Mode";
        } else {
            return "Pie Chart - Compare Mode";
        }
    }
}
