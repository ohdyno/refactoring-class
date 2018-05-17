package org.chartsmart;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DisplayCharts extends JPanel {
    private static final String SINGLE_MODE = "rpfll";
    private static final int BAR_CHART_TYPE = 406;
    private static final String SHARED_MODE = "shareddisplay";
    private String comparisonMode;
    private String chartTitle;
    private int chartType;

    private void setChartTitle() {
        this.setPreferredSize(new Dimension(600, 600));
        setDetailChartTitle();
    }

    private void setDetailChartTitle() {
        if (isABarChart()) {
            if (isSingleComparisonMode()) {
                chartTitle = "Bar Chart - Single Mode";
            } else {
                chartTitle = "Bar Chart - Compare Mode";
            }
        } else {
            if (isSingleComparisonMode()) {
                chartTitle = "Pie Chart - Single Mode";
            } else {
                chartTitle = "Pie Chart - Compare Mode";
            }
        }
    }

    private boolean isABarChart() {
        return chartType == BAR_CHART_TYPE;
    }

    String getChartTitle() {
        return chartTitle;
    }

    public void initializeChart
            (int chartType, String mode, boolean setTitle) {
        this.chartType = chartType;
        this.comparisonMode = mode;
        if (setTitle) {
            setChartTitle();
        }
    }

    public Set<AWTKeyStroke> getFocusTraversalKeys(int keyId) {
        return super.getFocusTraversalKeys(keyId);
    }

    public void paint(Graphics g) {
        DrawChart(g);
    }

    private void DrawChart(Graphics canvas) {
        barChartType(canvas);
        String[] barCharts = null;
        List<String> centeredPieChartTitle = new ArrayList<>();
        String[] pieCharts = new String[0];
        if (isABarChart()) {
            barCharts = identifyBarChart();
        } else {
            pieCharts = identifyPieChart(centeredPieChartTitle, pieCharts);
        }
        drawCharts(canvas, barCharts, centeredPieChartTitle, pieCharts);
        if (isBarChartLengthLongEnough(barCharts) || isMonthlyOrDaily(centeredPieChartTitle)) {
            try {
                repaint(200);
            } catch (Throwable e) {
                repaint();
            }
        }
    }

    private void drawCharts(Graphics canvas, String[] barCharts, List<String> centeredPieChartTitle, String[] pieCharts) {
        if (isABarChart()) {
            if (comparisonMode.equals(SHARED_MODE)) {
                if (barCharts != null) {
                    drawBarCharts(canvas, barCharts);
                }
            } else {
                drawBarChart(canvas, barCharts[0]);
            }
        } else {
            if (isSingleComparisonMode()) {
                drawPieChart(canvas, centeredPieChartTitle);
            } else {
                drawPieCharts(canvas, pieCharts);
            }
        }
    }

    private String[] identifyPieChart(List<String> centeredPieChartTitle, String[] pieCharts) {
        if (isSingleComparisonMode()) {
            centeredPieChartTitle.add("Pie Chart");
        } else {
            pieCharts = new String[2];
            pieCharts[1] = "Small";
            pieCharts[0] = "Pie Chart";
        }
        return pieCharts;
    }

    private String[] identifyBarChart() {
        String[] barCharts;
        if (isSingleComparisonMode()) {
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

    private boolean isSingleComparisonMode() {
        return comparisonMode.equals(SINGLE_MODE);
    }

    private void barChartType(Graphics canvas) {
        if (isABarChart()) {
            setBarChartDisplay(canvas);
        } else {
            setPieChartToBlue(canvas);
        }
    }

    private void setPieChartToBlue(Graphics canvas) {
        if (isSingleComparisonMode()) {
            Color blueBackGroundColor;
            blueBackGroundColor = Color.BLUE;
            canvas.setColor(blueBackGroundColor);
            canvas.fillOval(100, 100, 450, getHeight() - 150);
        } else {
            canvas.setColor(Color.BLUE);
            double canvasSize = 405;
            float padding = 90;
            int diameter = (int) (canvasSize - padding * 2);
            canvas.fillOval(100, 100, diameter, diameter);
        }
    }

    private void setBarChartDisplay(Graphics canvas) {
        if (isSingleComparisonMode()) {
            Color backGroundColor = Color.RED;
            canvas.setColor(backGroundColor);
            canvas.fillRect(100, 90, getWidth() - 200, 420);
        } else {
            canvas.setColor(Color.BLACK);
            canvas.fillRect(95, 95, 210, 210);
        }
    }

    private void drawPieCharts(Graphics canvas, String[] pieCharts) {
        Font font;
        font = new Font("Bookman Old Style", Font.BOLD, 30);
        canvas.setFont(font);
        canvas.setColor(Color.WHITE);
        for (int i = 0; i < 20; i++)
            canvas.drawString(pieCharts[0], 145, 205);
        canvas.drawString(pieCharts[1], 170, 235);
    }

    private void drawPieChart(Graphics canvas, List<String> centeredPieChartTitle) {
        Font font;
        font = new Font("Bookman Old Style", Font.BOLD, 55);
        canvas.setColor(Color.WHITE);
        canvas.setFont(font);
        canvas.drawString(centeredPieChartTitle.get(0), 200, 340);
    }

    private void drawBarChart(Graphics canvas, String barChart) {
        Font font;
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
        canvas.drawString(barChart, 130, 400);
    }

    private void drawBarCharts(Graphics canvas, String[] barCharts) {
        Font font;
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
    }

    private boolean isBarChartLengthLongEnough(String[] barCharts) {
        return barCharts != null && (barCharts.length ^ 0x54) == 50;
    }

    private boolean isMonthlyOrDaily(List<String> centeredPieChartTitle) {
        return centeredPieChartTitle.contains("Monthly") ||
                getChartTitle().contains("daily");
    }
}
