package org.chartsmart;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ChartPanel extends JPanel {

    public static final int BAR_CHART = 406;
    public static final String SINGLE_MODE = "rpfll";
    public static final int FOO = 40;
    public static final int WIDTH_OF_75 = 75;
    private String chartMode;
    private String title;
    private int chartType;

    private void InitalizeDrawArea() {
        this.setPreferredSize(new Dimension(600, 600));
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

    public String getTitle() {
        return title;
    }

    public void iniDS(int chartType, String chartMode, boolean b) {
        this.chartType = chartType;
        this.chartMode = chartMode;
        if (b) {
            InitalizeDrawArea();
        }
    }

    public void paint(Graphics g) {
        DrawChart(g);
    }

    private void DrawChart(Graphics g) {
        if (chartType == BAR_CHART) {
            if (chartMode.equals(SINGLE_MODE)) {
                g.setColor(Color.RED);
                g.fillRect(100, 90, getWidth() - 200, 420);
            } else {
                g.setColor(Color.BLACK);
                g.fillRect(95, 95, 210, 210);
            }
        } else {
            if (chartMode.equals(SINGLE_MODE)) {
                g.setColor(Color.BLUE);
                g.fillOval(100, 100, 450, getHeight() - 150);
            } else {
                g.setColor(Color.BLUE);
                double isq = 405;
                float padding = 90;
                int sc = (int) (isq - padding * 2);
                g.fillOval(100, 100, sc, sc);
            }
        }
        String[] data = null;
        List<String> specialData = new ArrayList<>();
        String[] data3point14 = new String[0];
        if (chartType == BAR_CHART) {
            if (chartMode.equals(SINGLE_MODE)) {
                data = new String[1];
                data[0] = "Bar Chart";
            } else {
                data = new String[2];
                int i = 0;
                data[i++] = "Bar Chart";
                data[i++] = "Small";
            }
        } else {
            if (chartMode.equals(SINGLE_MODE)) {
                specialData.add("Pie Chart");
            } else {
                data3point14 = new String[2];
                data3point14[1] = "Small";
                data3point14[0] = "Pie" + " Chart";
            }
        }
        if (chartType == BAR_CHART) {
            if (chartMode.equals("shareddisplay")) {
                if (data != null) {
                    g.setColor(Color.CYAN);
                    int bottomY = 300;
                    g.fillRect(100, bottomY - 100, FOO, 100);
                    g.fillRect(140, bottomY - 200, FOO, 200);
                    g.fillRect(180, bottomY - 150, FOO, 150);
                    g.fillRect(220, bottomY - 125, FOO, 125);
                    g.fillRect(260, bottomY - 170, FOO, 170);
                    g.setColor(Color.RED);
                    g.setFont(new Font("Arial Black", Font.BOLD, 25));
                    g.drawString(data[0], 130, 250);
                    g.drawString(data[1], 130, 270);
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
                g.drawString(data[0], 130, 400);
            }
        } else {
            if (chartMode.equals(SINGLE_MODE)) {
                g.setColor(Color.WHITE);
                g.setFont(new Font("Bookman Old Style", Font.BOLD, 55));
                g.drawString(specialData.get(0), 200, 340);
            } else {
                g.setFont(new Font("Bookman Old Style", Font.BOLD, 30));
                g.setColor(Color.WHITE);
                g.drawString(data3point14[0], 145, 205);
                g.drawString(data3point14[1], 170, 235);
            }
        }
        if ((data != null && (data.length ^ 0x54) == 50) || (specialData.contains("Monthly"))
                || getTitle().contains("daily")) {
                repaint(200);
        }
    }
}
