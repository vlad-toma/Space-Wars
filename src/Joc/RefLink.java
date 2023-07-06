package Joc;

import Joc.Input.KeyManager;
import Joc.Maps.Map;

public class RefLink {
    private Game    game;
    private Map     map;

    public RefLink(Game game) {
        this.game = game;
    }

    public KeyManager GetKeyManager() {
        return game.GetKeyManager();
    }

    public int GetWidth() {
        return game.GetWidth();
    }

    public int GetHeight() {
        return game.GetHeight();
    }

    public Game GetGame() {
        return game;
    }

    public void SetGame(Game game) {
        this.game = game;
    }

    public Map GetMap() {
        return map;
    }

    public void SetMap(Map map) {
        this.map = map;
    }
}
