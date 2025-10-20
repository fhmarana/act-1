package com.gabriel.draw;

import com.gabriel.draw.controller.DrawingWindowController;
import com.gabriel.draw.service.DrawingAppService;
import com.gabriel.draw.controller.DrawingController;
import com.gabriel.draw.view.DrawingView;
import com.gabriel.draw.view.DrawingFrame;
import com.gabriel.drawfx.model.Drawing;
import com.gabriel.drawfx.service.AppService;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        AppService appService = new DrawingAppService();
        DrawingFrame drawingFrame = new DrawingFrame(appService);
        drawingFrame.setVisible(true);
        drawingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        drawingFrame.setSize(500,500);
    }
}