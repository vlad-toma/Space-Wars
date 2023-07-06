package Joc.Tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {
    private static final int NO_TILES   = 6;
    public static Tile[] tiles          = new Tile[NO_TILES];
    public static Tile invisibleTile    = new InvisibleTile(0, false);
    public static Tile rock1    = new Rock1(1, false);
    public static Tile rock2    = new Rock2(2, false);
    public static Tile planeta1    = new Planeta1(3, false);
    public static Tile planeta2    = new Planeta2(4, false);
    public static Tile planeta3    = new Planeta3(5, false);
    public static final int TILE_WIDTH      = 32;
    public static final int TILE_HEIGHT     = 32;
    protected BufferedImage img;
    protected final int id;
    private boolean solid = false;
    public static int scale = 2;

    public Tile(BufferedImage img, int id, boolean isSolid) {
        this.img = img;
        this.id = id;
        tiles[id] = this;
        solid = isSolid;
    }

    public void Update() {

    }

    public void Draw(Graphics g, int x, int y) {
        g.drawImage(img, x, y, TILE_WIDTH * scale, TILE_HEIGHT * scale, null);
    }

    public boolean IsSolid() {return solid;}

    public int GetID() {return id;}
}
