package org.chartsmart;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class IndvDsp extends JPanel {

    private String jjD;
    private String __APARAM__Z;
    private int ct;

    private void iHATEthisUckingJob() {
        this.setPreferredSize(new Dimension(600, 600));
        if (ct == 406) {
            if (jjD.equals("rpfll")) {
                __APARAM__Z = "Bar Chart - Single Mode";
            } else {
                __APARAM__Z = "Bar" + " Chart - Compare Mode";
            }
        } else {
            if (jjD.equals("rpfll")) {
                __APARAM__Z = "Pie Chart - Single Mode";
            } else {
                __APARAM__Z = "Pie Chart - Compare Mode";
            }
        }
    }

    public String getTitle() {
        return __APARAM__Z;
    }

    public void iniDS(int ct, String stjjDReq1205, boolean b) {
        this.ct = ct;
        this.jjD = stjjDReq1205;
        if (b) {
            iHATEthisUckingJob();
        }
    }

    public void paint(Graphics g) {
        DrawChart(g);
    }

    private void DrawChart(Graphics g) {
        if (ct == 406) {
            if (jjD.equals("rpfll")) {
                g.setColor(Color.RED);
                g.fillRect(100, 90, getWidth() - 200, 420);
            } else {
                g.setColor(Color.BLACK);
                g.fillRect(95, 95, 210, 210);
            }
        } else {
            if (jjD.equals("rpfll")) {
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
        if (ct == 406) {
            if (jjD.equals("rpfll")) {
                data = new String[1];
                data[0] = "Bar Chart";
            } else {
                data = new String[2];
                int i = 0;
                data[i++] = "Bar Chart";
                data[i++] = "Small";
            }
        } else {
            if (jjD.equals("rpfll")) {
                specialData.add("Pie Chart");
            } else {
                data3point14 = new String[2];
                data3point14[1] = "Small";
                data3point14[0] = "Pie" + " Chart";
            }
        }
        if (ct == 406) {
            if (jjD.equals("shareddisplay")) {
                if (data != null) {
                    g.setColor(Color.CYAN);
                    int bottomY = 300;
                    g.fillRect(100, bottomY - 100, 40, 100);
                    g.fillRect(140, bottomY - 200, 40, 200);
                    g.fillRect(180, bottomY - 150, 40, 150);
                    g.fillRect(220, bottomY - 125, 40, 125);
                    g.fillRect(260, bottomY - 170, 40, 170);
                    g.setColor(Color.RED);
                    g.setFont(new Font("Arial Black", Font.BOLD, 25));
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
                g.setColor(Color.BLACK);
                g.setFont(new Font("Arial Black", Font.BOLD, 55));
                g.drawString(data[0], 130, 400);
            }
        } else {
            if (jjD.equals("rpfll")) {
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
