package com.checkers;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;

public class Piece extends Ellipse2D.Double implements MouseListener {

    public String type;
    public Color color;
    public int mouseX, mouseY;
    public int positionX, positionY;

    public Piece(int x, int y, String type) {
        this.type = type;
        if(type == "White-normal") {
            color = Color.ORANGE;
            switch (y) {
                case 0:
                    setFrame((x * 200) + 100 + 12.5, (y * 100) + 12.5, 75.0, 75.0);
                    break;
                case 1:
                    setFrame((x * 200) + 12.5 ,  (y * 100) + 12.5, 75.0, 75.0);
                    break;
                case 2:
                    setFrame((x * 200) + 100 + 12.5,  (y * 100) + 12.5, 75.0, 75.0);
                    break;
            }
        }
        else if(type == "Black-normal") {
            color = Color.PINK;
            switch (y) {
                case 0:
                    setFrame((x * 200) + 12.5, 500 + 12.5, 75.0, 75.0);
                    break;
                case 1:
                    setFrame( (x * 200) + 100 + 12.5, 600 + 12.5, 75.0, 75.0);
                    break;
                case 2:
                    setFrame( (x * 200) + 12.5, 700 + 12.5, 75.0, 75.0 );
                    break;
            }
        }
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    @Override
    public String toString() {
        return this.getPositionX() + ", " + this.getPositionY();
    }

    public void paintPiece(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(color);
        g2.fill(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.mouseX = e.getX();
        this.mouseY = e.getY();
        System.out.println(mouseX + ", " + mouseY);
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Piece testing = (Piece) e.getSource();
        System.out.println(testing);
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
