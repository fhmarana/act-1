package com.gabriel.draw.service;

import com.gabriel.draw.model.Ellipse;
import com.gabriel.drawfx.service.RendererService;
import com.gabriel.drawfx.model.Shape;
import java.awt.*;

public class EllipseRendererService implements RendererService {

    @Override
    public void render(Graphics g, Shape shape, boolean xor) {
        Ellipse ellipse = (Ellipse) shape;

        if (xor) {
            g.setXORMode(shape.getColor());
        } else {
            g.setPaintMode();
            g.setColor(shape.getColor());
        }

        Point topLeft = ellipse.getTopLeft();
        int width = ellipse.getWidth();
        int height = ellipse.getHeight();

        // Draw the ellipse outline
        g.drawOval(topLeft.x, topLeft.y, width, height);
    }
}