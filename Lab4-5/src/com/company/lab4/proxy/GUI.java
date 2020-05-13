package com.company.lab4.proxy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class GUI extends JFrame{
    public JFrame frame;
    private JPanel panel;

    private Moveable moveable;

    public GUI(Moveable item){
        this.moveable = item;
        Dimension size = item.getSize();
        frame = new JFrame("KEK");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(size.width + 100, size.height + 100);
        frame.setVisible(true);
        frame.setLayout(null);
        panel = moveable.draw();
        frame.add(panel);

        panel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                panel.setLocation(panel.getX() + e.getX(), panel.getY() + e.getY());
            }
        });
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON3){
                    frame.add(moveable.draw());
                    frame.validate();
                    frame.repaint();
                }
            }
        });
    }

}
