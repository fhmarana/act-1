package com.gabriel.draw.model;

import com.gabriel.draw.service.RectangleRendererService;
import lombok.Data;
import com.gabriel.drawfx.model.Shape;
import java.awt.*;

@Data
public class Rectangle extends Shape {

    public Rectangle(Point start, Point end) {
        super(start);
        this.setEnd(end);
        this.setColor(Color.BLUE);
        this.setRendererService(new RectangleRendererService());
    }

    // Helper method to get the top-left corner of the rectangle
    public Point getTopLeft() {
        int x = Math.min(getLocation().x, getEnd().x);
        int y = Math.min(getLocation().y, getEnd().y);
        return new Point(x, y);
    }

    // Helper method to get width of the rectangle
    public int getWidth() {
        return Math.abs(getEnd().x - getLocation().x);
    }

    // Helper method to get height of the rectangle
    public int getHeight() {
        return Math.abs(getEnd().y - getLocation().y);
    }
}