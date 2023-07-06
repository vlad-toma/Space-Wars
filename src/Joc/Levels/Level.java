package Joc.Levels;

import Joc.Entities.Enemies.Enemy;
import Joc.Entities.Nava;
import Joc.Maps.Map;
import Joc.RefLink;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static Joc.Methods.Method.hitboxCollision;

public abstract class Level {
    protected RefLink refLink;
    protected Nava nava;
    protected Map map;
    protected ArrayList<Wave> waves = new ArrayList<>();
    protected int currentWave;
    protected boolean finished;
    protected BufferedImage background;
    public Level(RefLink refLink, int mapID) {
        this.refLink = refLink;
        finished = false;
        nava = Nava.GetInstance(refLink, 600, 700, 0.9f);
        switch (mapID) {
            case 2:
                map = new Map(refLink, 2);
                break;
            case 1:

            default:
                map = new Map(refLink, 1);
        }
        InitLevel();
    }
    public abstract void InitLevel();
    public void Update() {
        map.Update();
        nava.Update();
        waves.get(currentWave).Update();
        // coliziuni projectile - nava
        for(int i = 0; i < waves.get(currentWave).enemies.size(); i++)
            for(int j = 0; j < waves.get(currentWave).enemies.get(i).getProjectiles().size(); j++)
                if(hitboxCollision(waves.get(currentWave).enemies.get(i).getProjectiles().get(j).getHitbox(), nava.getHitbox())) {
                    waves.get(currentWave).enemies.get(i).getProjectiles().remove(j);
                    nava.setHealth(nava.getHealth() - 10);
                    j--;
                }
        // coliziuni projectile - enemy
        for(int i = 0; i < waves.get(currentWave).enemies.size(); i++)
            for(int j = 0; j < nava.getProjectiles().size(); j++)
                if(waves.get(currentWave).enemies.get(i).isAlive())
                    if(hitboxCollision(nava.getProjectiles().get(j).getHitbox(), waves.get(currentWave).enemies.get(i).getHitbox())) {
                        waves.get(currentWave).enemies.get(i).setHealth(waves.get(currentWave).enemies.get(i).getHealth() - 10);
                        nava.getProjectiles().remove(j);
                        j--;
                    }
        // coliziuni nava - enemy
        for(int i = 0; i < waves.get(currentWave).enemies.size(); i++)
            if(hitboxCollision(nava.getHitbox(), waves.get(currentWave).enemies.get(i).getHitbox())) {
                waveReset();
            }

        if(nava.getHealth() <= 0) {
            levelReset();
        }

        if(waves.get(currentWave).isFinished()) {
            nava.Reset();
            currentWave++;
            if(currentWave < waves.size())
                waves.get(currentWave).Reset();
        }
        if(currentWave == waves.size()) {
            finished = true;
        }
    }

    public void Draw(Graphics g) {
        g.drawImage(background, 0, 0, refLink.GetGame().GetWidth(), refLink.GetGame().GetHeight(), null);
        map.Draw(g);
        nava.Draw(g);
        for(Enemy e : waves.get(currentWave).enemies)
            e.Draw(g);
        Font font = new Font("Calibri", Font.BOLD, 20);
        g.setColor(Color.red);
        g.setFont(font);
        g.drawString("Health : " + nava.getHealth(), 0, 40);

    }

    private void waveReset() {
        waves.get(currentWave).Reset();
        nava.Reset();
    }

    private void levelReset() {
        for(Wave wave: waves)
            wave.Reset();
        nava.Reset();
        currentWave = 0;
    }

    public boolean isFinished() {
        return finished;
    }

    public Nava getNava() {
        return nava;
    }
}
