package org.chartsmart;

import java.awt.*;

public interface Chart {
    String SINGLE_MODE = "rpfll";

    void draw(Graphics canvas, int width, int height);

    String title();
}
