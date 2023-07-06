package Joc.Tiles;

import Joc.Graphics.Assets;

public class InvisibleTile extends Tile {
    public InvisibleTile(int id, boolean isSolid) {
        super(Assets.invisible, id, isSolid);
    }
}
