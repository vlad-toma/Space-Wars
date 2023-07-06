package Joc.Levels.Waves;


import Joc.Entities.Enemies.Enemy;
import Joc.Entities.Enemies.Level1.Enemy1_1;
import Joc.Entities.Enemies.Level1.Enemy1_2;
import Joc.Entities.Enemies.Level2.Enemy2_1;
import Joc.Entities.Enemies.Level2.Enemy2_2;
import Joc.Entities.Enemies.Level3.Enemy3_1;
import Joc.Entities.Enemies.Level3.Enemy3_2;
import Joc.Levels.Wave;
import Joc.RefLink;

public class Wave3 extends Wave {
    public Wave3(RefLink refLink, int id) {
        super(refLink, id);
    }
    @Override
    public void InitLevel() {
        insertEnemy(128, 128);
        insertEnemy(64, 192);
        insertEnemy(0, 256);
        insertEnemy(192, 192);
        insertEnemy(256, 256);
        insertEnemy(64, 320);
        insertEnemy(192, 320);
        insertEnemy(128, 384);
        insertEnemy(128 + 15*64, 128);
        insertEnemy(64 + 15*64, 192);
        insertEnemy(15*64, 256);
        insertEnemy(192 + 15 * 64, 192);
        insertEnemy(256 + 15*64, 256);
        insertEnemy(64 + 15*64, 320);
        insertEnemy(192 + 15*64, 320);
        insertEnemy(128 + 15*64, 384);
        insertEnemy(512, 0);
        insertEnemy(576, 0);
        insertEnemy(640, 0);
        insertEnemy(704, 0);
        insertEnemy(448, 64);
        insertEnemy(384, 128);
        insertEnemy(384, 192);
        insertEnemy(384, 256);
        insertEnemy(384, 320);
        insertEnemy(448, 384);
        insertEnemy(512, 448);
        insertEnemy(576, 448);
        insertEnemy(640, 448);
        insertEnemy(704, 448);
        insertEnemy(768, 64);
        insertEnemy(832, 128);
        insertEnemy(832, 192);
        insertEnemy(832, 256);
        insertEnemy(832, 320);
        insertEnemy(768, 384);
        insertEnemy(512, 192,0);
        insertEnemy(576, 256,0);
        insertEnemy(640, 256,0);
        insertEnemy(704, 192,0);
    }

    private void insertEnemy(int x, int y) {
        switch (id) {
            case 1:
                Enemy enemy;
                enemy = new Enemy1_1(refLink, x, y, 0.5f);
                enemy.setHealth(30);
                enemy.setDirection("none");
                enemies.add(enemy);
                break;
            case 2:
                Enemy enemy1;
                enemy1 = new Enemy2_1(refLink, x, y, 0.5f);
                enemy1.setHealth(40);
                enemy1.setDirection("none");
                enemies.add(enemy1);
                break;
            case 3:
                Enemy enemy2;
                enemy2 = new Enemy3_1(refLink, x, y, 2.0f);
                enemy2.setHealth(50);
                enemy2.setDirection("none");
                enemies.add(enemy2);
                break;
        }
    }
    private void insertEnemy(int x, int y, int i) {
        switch (id) {
            case 1:
                Enemy enemy;
                enemy = new Enemy1_2(refLink, x, y, 0.5f);
                enemy.setHealth(30);
                enemy.setDirection("none");
                enemies.add(enemy);
                break;
            case 2:
                Enemy enemy1;
                enemy1 = new Enemy2_2(refLink, x, y, 0.5f);
                enemy1.setHealth(40);
                enemy1.setDirection("none");
                enemies.add(enemy1);
                break;
            case 3:
                Enemy enemy2;
                enemy2 = new Enemy3_2(refLink, x, y, 2.0f);
                enemy2.setHealth(50);
                enemy2.setDirection("none");
                enemies.add(enemy2);
                break;
        }
    }
}

