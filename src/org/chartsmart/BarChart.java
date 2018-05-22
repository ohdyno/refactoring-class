package org.chartsmart;

import java.awt.*;

public class BarChart implements Chart {
    private final String comparisonMode;

    BarChart(String comparisonMode) {
        this.comparisonMode = comparisonMode;
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

    private void draw(Graphics canvas) {
        if (comparisonMode.equals(SINGLE_MODE)) {
            canvas.setColor(Color.CYAN);
            canvas.fillRect(112, 300, 75, 200);
            canvas.fillRect(187, 100, 75, 400);
            canvas.fillRect(262, 200, 75, 300);
            canvas.fillRect(337, 250, 75, 250);
            canvas.fillRect(412, 160, 75, 340);
            canvas.setColor(Color.BLACK);
            canvas.setFont(new Font("Arial Black", Font.BOLD, 55));
            canvas.drawString("Bar Chart", 130, 400);
        } else {
            canvas.setColor(Color.CYAN);
            canvas.fillRect(100, 200, 40, 100);
            canvas.fillRect(140, 100, 40, 200);
            canvas.fillRect(180, 150, 40, 150);
            canvas.fillRect(220, 175, 40, 125);
            canvas.fillRect(260, 130, 40, 170);
            canvas.setColor(Color.RED);
            canvas.setFont(new Font("Arial Black", Font.BOLD, 25));
            canvas.drawString("Bar Chart", 130, 250);
            canvas.drawString("Small", 130, 270);
        }
    }

    public void draw(Graphics canvas, int width, int height) {
        colorCanvas(canvas, width);
        draw(canvas);
    }

    public String title() {
        if (comparisonMode.equals(SINGLE_MODE)) {
            return "Bar Chart - Single Mode";
        }
        return "Bar Chart - Compare Mode";
    }
}
