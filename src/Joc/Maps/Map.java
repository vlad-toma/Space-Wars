package Joc.Maps;

import Joc.RefLink;
import Joc.Tiles.Tile;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Map {
    private RefLink     refLink;
    private int         width;
    private int         height;
    private int[][]     tiles;

    public Map(RefLink refLink, int id) {
        this.refLink = refLink;
        LoadWorld(id);
    }

    public void Update() {

    }

    public void Draw(Graphics g) {
        for (int y = 0; y < refLink.GetGame().GetHeight() / (Tile.TILE_HEIGHT * Tile.scale); y++)
            for (int x = 0; x < refLink.GetGame().GetWidth() / (Tile.TILE_WIDTH * Tile.scale); x++)
                GetTile(y, x).Draw(g, (int) x * (Tile.TILE_HEIGHT * Tile.scale), (int) y * (Tile.TILE_WIDTH * Tile.scale));
    }

    public Tile GetTile(int x, int y) {
        if(x < 0 || y < 0 || y >= width || x >= height) {
            // return Tile.grassTile;
        }
        Tile t = Tile.tiles[tiles[x][y]];
        if(t == null) {
            return Tile.invisibleTile;
        }
        return t;
    }

    private void LoadWorld(int id) {
        width = 20;
        height = 13;
        tiles = new int[height][width];
        String path;
        switch(id) {
            case 1:
                path = "res/level 1/map1.txt";
                break;
            case 2:
                path = "res/level 2/map2.txt";
                break;
            default:
                path = "res/level 3/map3.txt";
                break;
        }
        File file = new File(path);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        for (int y = 0; y < height; y++) {
            String line = scanner.nextLine();
            String[] values = line.split(",");
            for (int x = 0; x < width; x++) {
                tiles[y][x] = Integer.parseInt(values[x]);
            }
        }
        scanner.close();
    }
}
