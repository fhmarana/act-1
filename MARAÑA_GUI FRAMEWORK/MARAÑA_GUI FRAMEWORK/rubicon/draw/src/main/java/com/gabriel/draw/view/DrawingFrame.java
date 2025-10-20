package com.gabriel.draw.view;

import com.gabriel.draw.controller.DrawingWindowController;
import com.gabriel.drawfx.ShapeMode;
import com.gabriel.drawfx.service.AppService;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public final class DrawingFrame extends JFrame {
    private static final String WINDOW_TITLE = "Rubicon Drawing Application";

    public DrawingFrame(AppService appService) {
        DrawingWindowController drawingWindowController = new DrawingWindowController(appService);
        this.addWindowListener(drawingWindowController);
        this.addWindowFocusListener(drawingWindowController);
        this.addWindowStateListener(drawingWindowController);

        // Create the main drawing view
        DrawingView drawingView = new DrawingView(appService);

        // Create menu bar with the setShapeMode calls
        JMenuBar menuBar = createMenuBar(appService);

        // Layout the frame
        this.setTitle(WINDOW_TITLE);
        this.setJMenuBar(menuBar);
        this.getContentPane().add(drawingView);
    }

    private JMenuBar createMenuBar(AppService appService) {
        JMenuBar menuBar = new JMenuBar();

        // Shapes menu
        JMenu shapesMenu = new JMenu("Shapes");
        shapesMenu.setMnemonic(KeyEvent.VK_S);

        // Create button group for mutual exclusion
        ButtonGroup shapeGroup = new ButtonGroup();

        JRadioButtonMenuItem lineItem = new JRadioButtonMenuItem("Line");
        lineItem.setSelected(true); // Default selection
        lineItem.addActionListener(e -> {
            appService.setShapeMode(ShapeMode.Line);
            System.out.println("Shape mode changed to: Line");
        });
        lineItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, KeyEvent.CTRL_DOWN_MASK));
        lineItem.setMnemonic(KeyEvent.VK_L);
        shapeGroup.add(lineItem);
        shapesMenu.add(lineItem);

        JRadioButtonMenuItem rectangleItem = new JRadioButtonMenuItem("Rectangle");
        rectangleItem.addActionListener(e -> {
            appService.setShapeMode(ShapeMode.Rectangle);
            System.out.println("Shape mode changed to: Rectangle");
        });
        rectangleItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, KeyEvent.CTRL_DOWN_MASK));
        rectangleItem.setMnemonic(KeyEvent.VK_R);
        shapeGroup.add(rectangleItem);
        shapesMenu.add(rectangleItem);

        JRadioButtonMenuItem ellipseItem = new JRadioButtonMenuItem("Ellipse");
        ellipseItem.addActionListener(e -> {
            appService.setShapeMode(ShapeMode.Ellipse);
            System.out.println("Shape mode changed to: Ellipse");
        });
        ellipseItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_DOWN_MASK));
        ellipseItem.setMnemonic(KeyEvent.VK_E);
        shapeGroup.add(ellipseItem);
        shapesMenu.add(ellipseItem);

        shapesMenu.addSeparator();

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_DOWN_MASK));
        exitItem.addActionListener(e -> System.exit(0));
        shapesMenu.add(exitItem);

        menuBar.add(shapesMenu);
        return menuBar;  }
}