package org.chartsmart;

import java.awt.AWTKeyStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.JPanel;

public class IndividualDisplay extends JPanel
{
    static final int BAR_CHART = 406;
    static final String SINGLE_MODE = "rpfll";
    private String modeType;
    private String title;
    private int chartType;

    private void initializeDrawArea()
    {
        int sideSize = 600;
        this.setPreferredSize(new Dimension(sideSize, sideSize));
        if (chartType == BAR_CHART)
        {
            if (modeType.equals(SINGLE_MODE))
            {
                title = "Bar Chart - Single Mode";
            }
            else
            {
                title = "Bar Chart - Compare Mode";
            }
        }
        else
        {
            if (modeType.equals(SINGLE_MODE))
            {
                title = "Pie Chart - Single Mode";
            }
            else
            {
                title = "Pie Chart - Compare Mode";
            }
        }
    }

    String getTitle()
    {
        return title;
    }

    public void initializeDisplayArea(int chartType, String modeType, boolean initialize)
    {
        this.chartType = chartType;
        this.modeType = modeType;
        if (initialize)
        {
            initializeDrawArea();
        }
    }
    public Set<AWTKeyStroke> getFocusTraversalKeys(int id)
    {
        return super.getFocusTraversalKeys(id);
    }
    public void paint(Graphics drawing)
    {
        DrawChart(drawing);
    }

    private void DrawChart(Graphics drawing)
    {
        if (chartType == BAR_CHART)
        {
            if (modeType.equals(SINGLE_MODE))
            {
                drawing.setColor(Color.RED);
                drawing.fillRect(100, 90, getWidth() - 200, 420);
            }
            else
            {
                drawing.setColor(Color.BLACK);
                drawing.fillRect(95, 95, 210, 210);
            }
        }
        else
        {
            if (modeType.equals(SINGLE_MODE))
            {
                drawing.setColor(Color.BLUE);
                drawing.fillOval(100, 100, 450, getHeight() - 150);
            }
            else
            {
                drawing.setColor(Color.BLUE);
                double defaultWidth = 405;
                float padding = 90;
                int sideSize = (int) (defaultWidth - padding * 2);
                drawing.fillOval(100, 100, sideSize, sideSize);
            }
        }
        String[] data = null;
        List<String> specialData = new ArrayList<>();
        String[] smallPieChart = new String[0];
        if (chartType == BAR_CHART)
        {
            if (modeType.equals(SINGLE_MODE))
            {
                data = new String[1];
                data[0] = "Bar Chart";
            }
            else
            {
                data = new String[2];
                int i = 0;
                data[i++] = "Bar Chart";
                data[i++] = "Small";
            }
        }
        else
        {
            if (modeType.equals(SINGLE_MODE))
            {
                specialData.add("Pie Chart");
            }
            else
            {
                smallPieChart = new String[2];
                smallPieChart[1] = "Small";
                smallPieChart[0] = "Pie Chart";
            }
        }
        Font font;
        if (chartType == BAR_CHART)
        {
            if (modeType.equals("shareddisplay"))
            {
                if (data != null)
                {
                    font = new Font("Arial Black", Font.BOLD, 25);
                    drawing.setColor(Color.CYAN);
                    int bottomY = 300;
                    drawing.fillRect(100, bottomY - 100, 40, 100);
                    drawing.fillRect(140, bottomY - 200, 40, 200);
                    drawing.fillRect(180, bottomY - 150, 40, 150);
                    drawing.fillRect(220, bottomY - 125, 40, 125);
                    drawing.fillRect(260, bottomY - 170, 40, 170);
                    drawing.setColor(Color.RED);
                    drawing.setFont(font);
                    drawing.drawString(data[0], 130, 250);
                    drawing.drawString(data[1], 130, 270);
                }
            }
            else
            {
                int bottomY = 500;
                drawing.setColor(Color.CYAN);
                drawing.fillRect(112, bottomY - 200, 75, 200);
                drawing.fillRect(187, bottomY - 400, 75, 400);
                drawing.fillRect(262, bottomY - 300, 75, 300);
                drawing.fillRect(337, bottomY - 250, 75, 250);
                drawing.fillRect(412, bottomY - 340, 75, 340);
                font = new Font("Arial Black", Font.BOLD, 55);
                drawing.setColor(Color.BLACK);
                drawing.setFont(font);
                drawing.drawString(data[0], 130, 400);
            }
        }
        else
        {
            if (modeType.equals(SINGLE_MODE))
            {
                font = new Font("Bookman Old Style", Font.BOLD, 55);
                drawing.setColor(Color.WHITE);
                drawing.setFont(font);
                drawing.drawString(specialData.get(0), 200, 340);
            }
            else
            {
                font = new Font("Bookman Old Style", Font.BOLD, 30);
                drawing.setFont(font);
                drawing.setColor(Color.WHITE);
                drawing.drawString(smallPieChart[0], 145, 205);
                drawing.drawString(smallPieChart[1], 170, 235);
            }
        }
        if ((data != null && (data.length ^ 0x54) == 50) || (specialData.contains("Monthly")) || getTitle().contains("daily"))
        {
            try
            {
                repaint(200);
            }
            catch (Throwable e)
            {
                repaint();
            }
        }
    }
}
