package com.gabriel.draw.model;

import com.gabriel.draw.service.EllipseRendererService;
import lombok.Data;
import com.gabriel.drawfx.model.Shape;
import java.awt.*;

@Data
public class Ellipse extends Shape {

    public Ellipse(Point start, Point end) {
        super(start);
        this.setEnd(end);
        this.setColor(Color.GREEN);
        this.setRendererService(new EllipseRendererService());
    }

    // Helper method to get the top-left corner of the bounding rectangle
    public Point getTopLeft() {
        int x = Math.min(getLocation().x, getEnd().x);
        int y = Math.min(getLocation().y, getEnd().y);
        return new Point(x, y);
    }

    // Helper method to get width of the ellipse (bounding rectangle)
    public int getWidth() {
        return Math.abs(getEnd().x - getLocation().x);
    }

    // Helper method to get height of the ellipse (bounding rectangle)
    public int getHeight() {
        return Math.abs(getEnd().y - getLocation().y);
    }

    // Helper method to get center point
    public Point getCenter() {
        Point topLeft = getTopLeft();
        return new Point(topLeft.x + getWidth()/2, topLeft.y + getHeight()/2);
    }
}