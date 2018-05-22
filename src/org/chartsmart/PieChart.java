package org.chartsmart;

import java.awt.*;

class PieChart implements Chart {
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

    private void draw(Graphics canvas) {
        canvas.setColor(Color.WHITE);
        if (comparisonMode.equals(SINGLE_MODE)) {
            canvas.setFont(new Font("Bookman Old Style", Font.BOLD, 55));
            canvas.drawString("Pie Chart", 200, 340);
        } else {
            canvas.setFont(new Font("Bookman Old Style", Font.BOLD, 30));
            canvas.drawString("Pie Chart", 145, 205);
            canvas.drawString("Small", 170, 235);
        }
    }

    public void draw(Graphics canvas, int width, int height) {
        colorCanvas(canvas, height);
        draw(canvas);
    }

    public String title() {
        if (comparisonMode.equals(SINGLE_MODE)) {
            return "Pie Chart - Single Mode";
        }
        return "Pie Chart - Compare Mode";
    }
}
