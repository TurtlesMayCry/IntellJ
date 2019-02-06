package com.checkers;

import java.awt.*;

public class Tile extends Rectangle {

    public static final int TILE_SIZE = Checkers.TILE_SIZE;
    public int positionX, positionY;
    public Color color;
    public Piece piece;

    public Tile(boolean light, int x, int y) {
        setSize(new Dimension(TILE_SIZE , TILE_SIZE));
        setLocation(x * TILE_SIZE, y * TILE_SIZE);

        if(light == true)
            color = Color.WHITE;
        else
            color = Color.BLACK;

        this.positionX = x;
        this.positionY = y;
    }

    public void paintTile(int x, int y, Graphics g) {
        g.setColor(color);
        g.fillRect(x * TILE_SIZE, y * TILE_SIZE, Checkers.TILE_SIZE, Checkers.TILE_SIZE);
    }

    public void setTile(Piece p) {
        this.piece = p;
        p.setPositionX(this.positionX);
        p.setPositionY(this.positionY);
    }

    public boolean hasPiece() {
        return piece != null;
    }
}
