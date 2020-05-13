package com.company.lab4.proxy;

import javax.swing.*;
import java.awt.*;

public class Box implements Moveable {
    private Moveable item;
    private JPanel panel;
    private int count;

    public Box() {
        this.item = new Image();
        count = 0;
    }

    @Override
    public Dimension getSize(){
        return item.getSize();
    }

    @Override
    public JPanel draw() {
        if(count < 1) {
            panel = new JPanel();
            panel.setBounds(item.getSize().width / 2, item.getSize().height, item.getSize().width, item.getSize().height);
            panel.setBackground(Color.GRAY);
            count++;
        }else if(count == 1){
            panel.add(item.draw());
            panel.setBackground(new Color(238,238,238));
        }
        return panel;
    }


}

