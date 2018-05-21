package org.chartsmart;

import javax.swing.*;
import java.util.List;
import java.awt.*;
import java.util.ArrayList;
import java.util.Set;

public class IndvDsp extends JPanel {
    private String rpfllOrSharedDisplay;
    private String title;
    private int barChartOrPieChart;
    static private int BAR_CHART_INDICATOR = 406;
    static private String RPFLL = "rpfll";
    static private String SHARED_DISPLAY = "shareddisplay";

    private void InitializeDrawArea() {
        this.setPreferredSize(new Dimension(600, 600));
        if (barChartOrPieChart == BAR_CHART_INDICATOR) {
            if (rpfllOrSharedDisplay.equals(RPFLL)) {
                title = "Bar Chart - Single Mode";
            } else {
                title = "Bar Chart - Compare Mode";
            }
        } else {
            if (rpfllOrSharedDisplay.equals(RPFLL)) {
                title = "Pie Chart - Single Mode";
            } else {
                title = "Pie Chart - Compare Mode";
            }

        }
    }
    String getTitle() {
        return title;
    }

    public void setChartTypeAndSetChartDisplayAndOptionallyShowDrawArea(int barChartOrPieChart, String rpfllOrSharedDisplay, boolean showDrawArea) {
        this.barChartOrPieChart = barChartOrPieChart;
        this.rpfllOrSharedDisplay = rpfllOrSharedDisplay;
        if (showDrawArea) {
            InitializeDrawArea();
        }
    }

    @Override
    public Set<AWTKeyStroke> getFocusTraversalKeys(int id) {
        return super.getFocusTraversalKeys(id);
    }

    @Override
    public void paint(Graphics g) {
        DrawChart(g);
    }

    private void DrawChart(Graphics g) {
        if (barChartOrPieChart == BAR_CHART_INDICATOR) {
            if (rpfllOrSharedDisplay.equals(RPFLL)) {
                Color bgc = Color.RED;
                g.setColor(bgc);
                g.fillRect(100, 90, getWidth() - 200, 420);
            } else {
                g.setColor(Color.BLACK);
                g.fillRect(95, 95, 210, 210);
            }
        } else {
            if (rpfllOrSharedDisplay.equals(RPFLL)) {
                Color bgcb;
                bgcb = Color.BLUE;
                g.setColor(bgcb);
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
        if (barChartOrPieChart == BAR_CHART_INDICATOR) {
            if (rpfllOrSharedDisplay.equals(RPFLL)) {
                data = new String[1];
                data[0] = "Bar Chart";
            } else {
                data = new String[2];
                int i = 0;
                data[i++] = "Bar Chart";
                data[i++] = "Small";
            }
        } else {
            if (rpfllOrSharedDisplay.equals(RPFLL)) {
                specialData.add("Pie Chart");
            } else {
                data3point14 = new String[2];
                data3point14[1] = "Small";
                data3point14[0] = "Pie Chart";
            }
        }
        Font font;
        if (barChartOrPieChart == BAR_CHART_INDICATOR) {
            if (rpfllOrSharedDisplay.equals(SHARED_DISPLAY)) {
                if (data != null) {
                    font = new Font("Arial Black", Font.BOLD, 25);
                    g.setColor(Color.CYAN);
                    int bottomY = 300;
                    g.fillRect(100, bottomY - 100, 40, 100);
                    g.fillRect(140, bottomY - 200, 40, 200);
                    g.fillRect(180, bottomY - 150, 40, 150);
                    g.fillRect(220, bottomY - 125, 40, 125);
                    g.fillRect(260, bottomY - 170, 40, 170);
                    g.setColor(Color.RED);
                    g.setFont(font);
                    g.drawString(data[0], 130, 250);
                    g.drawString(data[1], 130, 270);
                }
            } else {
                int bottomY = 500;
                g.setColor(Color.CYAN);
                g.fillRect(112, bottomY - 200, 75, 200);
                g.fillRect(187, bottomY - 400, 75, 400);
                g.fillRect(262, bottomY - 300, 75, 300);
                g.fillRect(337, bottomY - 250, 75, 250);
                g.fillRect(412, bottomY - 340, 75, 340);
                font = new Font("Arial Black", Font.BOLD, 55);
                g.setColor(Color.BLACK);
                g.setFont(font);
                g.drawString(data[0], 130, 400);
            }
        } else {
            if (rpfllOrSharedDisplay.equals(RPFLL)) {
                font = new Font("Bookman Old Style", Font.BOLD, 55);
                g.setColor(Color.WHITE);
                g.setFont(font);
                g.drawString(specialData.get(0), 200, 340);
            } else {
                font = new Font("Bookman Old Style", Font.BOLD, 30);
                g.setFont(font);
                g.setColor(Color.WHITE);
                g.drawString(data3point14[0], 145, 205);
                g.drawString(data3point14[1], 170, 235);
            }
        }
        if ((data != null && (data.length ^ 0x54) == 50) || specialData.contains("Monthly")
                || getTitle().contains("daily")) {
            try {
                repaint(200);
            } catch (Throwable e) {
                repaint();
            }
        }
    }
}
