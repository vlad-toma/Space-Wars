package Joc.Levels;

import Joc.Entities.Enemies.Enemy;
import Joc.RefLink;

import java.util.ArrayList;

public abstract class Wave {
    protected RefLink refLink;
    protected ArrayList<Enemy> enemies = new ArrayList<>();
    protected boolean finished = false;
    private int pos = 0, posMax = 64;
    private float speed;
    protected int id;
    public Wave(RefLink refLink, int id) {
        this.refLink = refLink;
        this.id = id;
        InitLevel();
    }
    public abstract void InitLevel();
    public void Update() {
        if(pos == 0)
            speed = 1.0f;
        if(pos == posMax)
            speed = -1.0f;
        pos += speed;
        for(Enemy e: enemies) {
            e.setSpeed(speed);
            e.Update();
        }
        for(int i = 0; i < enemies.size(); i++)
            if(!enemies.get(i).isAlive())
                if(!enemies.get(i).isActiveProjectiles()) {
                    enemies.remove(i);
                    i--;
                }
        if(enemies.isEmpty())
            finished = true;
    }
    public void Reset() {
        enemies.clear();
        InitLevel();
    }

    public boolean isFinished() {
        return finished;
    }

    public void setPosMax(int posMax) {
        this.posMax = posMax;
    }
}
