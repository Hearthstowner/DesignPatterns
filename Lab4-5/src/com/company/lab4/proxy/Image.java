package com.company.lab4.proxy;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class Image implements Moveable {
    private BufferedImage image;
    private String filePath = "TestImage.png";
    private JPanel panel;

    @Override
    public JPanel draw() {
        try {
            image = ImageIO.read(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        panel = new JPanel();
        ImageIcon ic = new ImageIcon(image);
        JLabel label = new JLabel(ic);
        panel.add(label);
        return panel;
    }

    @Override
    public Dimension getSize(){
        try(ImageInputStream in = ImageIO.createImageInputStream(new File(filePath))){
            final Iterator<ImageReader> readers = ImageIO.getImageReaders(in);
            if (readers.hasNext()) {
                ImageReader reader = readers.next();
                try {
                    reader.setInput(in);
                    return new Dimension(reader.getWidth(0), reader.getHeight(0));
                } finally {
                    reader.dispose();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
