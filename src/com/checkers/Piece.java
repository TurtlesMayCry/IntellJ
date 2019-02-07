package com.checkers;

import javax.swing.JComponent;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;

public class Piece extends JComponent implements MouseListener {

    Ellipse2D.Double circle;
    public String type;
    public Color color;
    public int mouseX, mouseY;
    public int positionX, positionY;

    public Piece(int x, int y, String type) {
        this.type = type;
        this.circle = new Ellipse2D.Double();

        if(type == "White-normal") {
            color = Color.ORANGE;
            switch (y) {
                case 0:
                    circle.setFrame((x * 200) + 100 + 12.5, (y * 100) + 12.5, 75.0, 75.0);
                    break;
                case 1:
                    circle.setFrame((x * 200) + 12.5 ,  (y * 100) + 12.5, 75.0, 75.0);
                    break;
                case 2:
                    circle.setFrame((x * 200) + 100 + 12.5,  (y * 100) + 12.5, 75.0, 75.0);
                    break;
            }
        }
        else if(type == "Black-normal") {
            color = Color.PINK;
            switch (y) {
                case 0:
                    circle.setFrame((x * 200) + 12.5, 500 + 12.5, 75.0, 75.0);
                    break;
                case 1:
                    circle.setFrame( (x * 200) + 100 + 12.5, 600 + 12.5, 75.0, 75.0);
                    break;
                case 2:
                    circle.setFrame( (x * 200) + 12.5, 700 + 12.5, 75.0, 75.0 );
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
        g2.fill(this.circle);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int newX = e.getX();
        int newY = e.getY();
        if(this.circle.contains(new Point(newX, newY))) {
            System.out.println(newX);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
