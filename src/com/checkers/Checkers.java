package com.checkers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;

public class Checkers extends JPanel {

    public static final int TILE_SIZE = 100, WIDTH = 8, HEIGHT = 8;
    private JFrame frame;
    private ArrayList<Tile> tiles;
    private ArrayList<Piece> pieces, otherPieces;

    public Checkers() {
        super();
        init();
        frame.setTitle("Checkers");
        setPreferredSize(new Dimension(WIDTH * 100, HEIGHT * 100 + 25));
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);

        for(int y = 0; y < 3; y++) {
            for(int x = 0; x < 4; x++) {
                otherPieces.add(new Piece(x, y, "Black-normal"));
                pieces.add(new Piece(x, y, "White-normal"));
            }
        }

        for(int i = 0; i < pieces.size(); i++) {
            addMouseListener(pieces.get(i));
        }

        Iterator playerIter = pieces.iterator();
        Iterator compIter = otherPieces.iterator();
        for(int col = 0; col < WIDTH; col++) {
            for(int row = 0; row < HEIGHT; row++) {
                Tile aTile = new Tile((row + col) % 2 == 0, row, col);
                if(aTile.color == Color.BLACK && playerIter.hasNext() && col < 3) {
                    Piece aPiece = (Piece) playerIter.next();
                    aTile.setTile(aPiece);
                }
                if(aTile.color == Color.BLACK && compIter.hasNext() && col > 4) {
                    Piece aPiece = (Piece) compIter.next();
                    aTile.setTile(aPiece);
                }
                tiles.add(aTile);
            }
        }
    }

    public void init() {
        frame = new JFrame();
        tiles = new ArrayList<>();
        pieces = new ArrayList<>();
        otherPieces = new ArrayList<>();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Iterator iterator = tiles.iterator();
        for(int row = 0; row < WIDTH; row++) {
            for(int col = 0; col < HEIGHT; col++) {
                if(iterator.hasNext()) {
                    Tile test = (Tile) iterator.next();
                    System.out.println(test.hasPiece());
                    test.paintTile(row, col, g);
                }
            }
        }

        for(int a = 0; a < 12; a++) {
            otherPieces.get(a).paintPiece(g);
            pieces.get(a).paintPiece(g);
        }
    }

    public static void main(String args[]) {
        Checkers ch = new Checkers();
    }
}
