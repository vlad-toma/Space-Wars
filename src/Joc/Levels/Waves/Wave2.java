package Joc.Levels.Waves;


import Joc.Entities.Enemies.Enemy;
import Joc.Entities.Enemies.Level1.Enemy1_2;
import Joc.Entities.Enemies.Level2.Enemy2_2;
import Joc.Entities.Enemies.Level3.Enemy3_2;
import Joc.Levels.Wave;
import Joc.RefLink;

public class Wave2 extends Wave {
    public Wave2(RefLink refLink, int id) {
        super(refLink, id);
    }
    @Override
    public void InitLevel() {
        insertEnemy(0, 64);
        insertEnemy(64, 0);
        insertEnemy(128, 64);
        insertEnemy(192, 128);
        insertEnemy(256, 192);
        insertEnemy(320, 128);
        insertEnemy(384, 64);
        insertEnemy(448, 0);
        insertEnemy(512, 64);
        insertEnemy(576, 128);
        insertEnemy(640, 128);
        insertEnemy(640 + 64, 64);
        insertEnemy(640 + 128, 0);
        insertEnemy(640 + 192, 64);
        insertEnemy(640 + 256, 128);
        insertEnemy(640 + 320, 192);
        insertEnemy(640 + 384, 128);
        insertEnemy(640 + 448, 64);
        insertEnemy(640 + 512, 0);
        insertEnemy(640 + 576, 64);
    }

    private void insertEnemy(int x, int y) {
        switch (id) {
            case 1:
                Enemy enemy;
                enemy = new Enemy1_2(refLink, x, y, 0.5f);
                enemy.setHealth(30);
                enemy.setDirection("down");
                enemies.add(enemy);
                break;
            case 2:
                Enemy enemy1;
                enemy1 = new Enemy2_2(refLink, x, y, 0.5f);
                enemy1.setHealth(40);
                enemy1.setDirection("down");
                enemies.add(enemy1);
                break;
            case 3:
                Enemy enemy2;
                enemy2 = new Enemy3_2(refLink, x, y, 2.0f);
                enemy2.setHealth(50);
                enemy2.setDirection("down");
                enemies.add(enemy2);
                break;
        }
    }
}

