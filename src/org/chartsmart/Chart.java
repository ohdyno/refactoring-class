package org.chartsmart;

import java.awt.*;

public interface Chart {
    void draw(Graphics canvas, int width, int height);

    String title();
}
