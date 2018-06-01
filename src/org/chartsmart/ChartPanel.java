package org.chartsmart;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ChartPanel extends JPanel {

    private static final int BAR_CHART = 406;
    private static final String SINGLE_MODE = "rpfll";
    private static final int BAR_WIDTH = 40;
    private static final int WIDTH_OF_75 = 75;
    private String chartMode;
    private String title;
    private int chartType;

    private void initalizeDrawArea() {
        int width = 600;
        int height = 600;
        this.setPreferredSize(new Dimension(width, height));
        if (chartType == BAR_CHART) {
            if (chartMode.equals(SINGLE_MODE)) {
                title = "Bar Chart - Single Mode";
            } else {
                title = "Bar Chart - Compare Mode";
            }
        } else {
            if (chartMode.equals(SINGLE_MODE)) {
                title = "Pie Chart - Single Mode";
            } else {
                title = "Pie Chart - Compare Mode";
            }
        }
    }

    String getTitle() {
        return title;
    }

    public void initializeDrawingSurface(int chartType, String chartMode, boolean isUninitialized) {
        this.chartType = chartType;
        this.chartMode = chartMode;
        if (isUninitialized) {
            initalizeDrawArea();
        }
    }

    public void paint(Graphics g) {
        drawChart(g);
    }

    private void drawChart(Graphics g) {
        if (chartType == BAR_CHART) {
            if (chartMode.equals(SINGLE_MODE)) {
                g.setColor(Color.RED);
                g.fillRect(100, 90, getWidth() - 200, 420);
            } else {
                g.setColor(Color.BLACK);
                g.fillRect(95, 95, 210, 210);
            }
        } else {
            int x = 100;
            int y = 100;
            int width = 450;
            if (chartMode.equals(SINGLE_MODE)) {
                g.setColor(Color.BLUE);
                g.fillOval(x, y, width, getHeight() - 150);
            } else {
                g.setColor(Color.BLUE);
                g.fillOval(x, y, 225, 225);
            }
        }
        String[] barChartText = null;
        List<String> specialData = new ArrayList<>();
        String[] pieChartText = new String[0];
        String SMALL = "Small";
        if (chartType == BAR_CHART) {
            if (chartMode.equals(SINGLE_MODE)) {
                barChartText = new String[1];
                barChartText[0] = "Bar Chart";
            } else {
                barChartText = new String[2];
                barChartText[0] = "Bar Chart";
                barChartText[1] = SMALL;
            }
        } else {
            if (chartMode.equals(SINGLE_MODE)) {
                specialData.add("Pie Chart");
            } else {
                pieChartText = new String[2];
                pieChartText[0] = "Pie Chart";
                pieChartText[1] = SMALL;
            }
        }
        if (chartType == BAR_CHART) {
            if (chartMode.equals("shareddisplay")) {
                if (barChartText != null) {
                    g.setColor(Color.CYAN);
                    int bottomY = 300;
                    g.fillRect(100, bottomY - 100, BAR_WIDTH, 100);
                    g.fillRect(140, bottomY - 200, BAR_WIDTH, 200);
                    g.fillRect(180, bottomY - 150, BAR_WIDTH, 150);
                    g.fillRect(220, bottomY - 125, BAR_WIDTH, 125);
                    g.fillRect(260, bottomY - 170, BAR_WIDTH, 170);
                    g.setColor(Color.RED);
                    g.setFont(new Font("Arial Black", Font.BOLD, 25));
                    g.drawString(barChartText[0], 130, 250);
                    g.drawString(barChartText[1], 130, 270);
                }
            } else {
                int bottomY = 500;
                g.setColor(Color.CYAN);
                g.fillRect(112, bottomY - 200, WIDTH_OF_75, 200);
                g.fillRect(187, bottomY - 400, WIDTH_OF_75, 400);
                g.fillRect(262, bottomY - 300, WIDTH_OF_75, 300);
                g.fillRect(337, bottomY - 250, WIDTH_OF_75, 250);
                g.fillRect(412, bottomY - 340, WIDTH_OF_75, 340);
                g.setColor(Color.BLACK);
                g.setFont(new Font("Arial Black", Font.BOLD, 55));
                g.drawString(barChartText[0], 130, 400);
            }
        } else {
            if (chartMode.equals(SINGLE_MODE)) {
                g.setColor(Color.WHITE);
                g.setFont(new Font("Bookman Old Style", Font.BOLD, 55));
                g.drawString(specialData.get(0), 200, 340);
            } else {
                g.setFont(new Font("Bookman Old Style", Font.BOLD, 30));
                g.setColor(Color.WHITE);
                g.drawString(pieChartText[0], 145, 205);
                g.drawString(pieChartText[1], 170, 235);
            }
        }
        boolean chartTextFits = barChartText != null && ((barChartText.length ^ 0x54) == 50);
        boolean monthlyOrDaily = specialData.contains("Monthly") || getTitle().contains("daily");
        if (chartTextFits || monthlyOrDaily) {
                repaint(200);
        }
    }
}
