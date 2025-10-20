package com.gabriel.draw.service;

import com.gabriel.draw.model.Rectangle;
import com.gabriel.drawfx.service.RendererService;
import com.gabriel.drawfx.model.Shape;
import java.awt.*;

public class RectangleRendererService implements RendererService {

    @Override
    public void render(Graphics g, Shape shape, boolean xor) {
        Rectangle rectangle = (Rectangle) shape;

        if (xor) {
            g.setXORMode(shape.getColor());
        } else {
            g.setPaintMode();
            g.setColor(shape.getColor());
        }

        Point topLeft = rectangle.getTopLeft();
        int width = rectangle.getWidth();
        int height = rectangle.getHeight();

        // Draw the rectangle outline
        g.drawRect(topLeft.x, topLeft.y, width, height);
    }
}