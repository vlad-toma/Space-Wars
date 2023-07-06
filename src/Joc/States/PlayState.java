package Joc.States;

import Joc.Levels.Level;
import Joc.Levels.Levels.Level1;
import Joc.Levels.Levels.Level2;
import Joc.Levels.Levels.Level3;
import Joc.Maps.Map;
import Joc.RefLink;

import java.awt.*;

import static Joc.Methods.Method.writeScore;


public class PlayState extends State{
    private Level level;
    private int id;
    private int score;

    public PlayState(RefLink refLink) {
        super(refLink);
        score = 0;
        LoadLevel(1);
    }

    @Override
    public void Update() {
        level.Update();
        if(level.isFinished()) {
            if(id == 3) {
//                id = 1;
//                refLink.SetMap(new Map(refLink, 1));
//                LoadLevel(1);
                writeScore(score / (101 - level.getNava().getHealth()));
                score = 0;
                refLink.GetGame().setState(new PlayState(refLink));
            }
            else {
                LoadLevel(++id);
            }
        }
        score++;
    }
    @Override
    public void Draw(Graphics g) {
        level.Draw(g);
    }

    public void LoadLevel(int idLevel) {
        switch (idLevel) {
            case 1:
                id = idLevel;
                refLink.SetMap(new Map(refLink, id));
                level = new Level1(refLink);
                break;
            case 2:
                id = idLevel;
                refLink.SetMap(new Map(refLink, id));
                level = new Level2(refLink);
                break;
            case 3:
                id = idLevel;
                refLink.SetMap(new Map(refLink, id));
                level = new Level3(refLink);
                break;
        }
    }
}
