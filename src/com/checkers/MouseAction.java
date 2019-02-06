package com.checkers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseAction implements MouseListener {

    Piece piece;

    public MouseAction() {

    }

    public void displaySelection() {
        System.out.println(piece);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        piece = (Piece) e.getSource();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        displaySelection();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
