package Joc.Levels.Waves;

import Joc.Entities.Enemies.Enemy;
import Joc.Entities.Enemies.Level1.Enemy1_1;
import Joc.Entities.Enemies.Level2.Enemy2_1;
import Joc.Entities.Enemies.Level3.Enemy3_1;
import Joc.Levels.Wave;
import Joc.RefLink;

public class Wave1 extends Wave {
    public Wave1(RefLink refLink, int id) {
        super(refLink, id);
    }
    @Override
    public void InitLevel() {
        Enemy enemy;
        for(int i = 0; i < 19; i += 2 ) {
            insertEnemy(64 * i, 10);
        }
        for(int i = 0; i < 19; i += 2) {
            insertEnemy(64 * i, 110);
        }
        for(int i = 0; i < 19; i += 2) {
            insertEnemy(64 * i, 210);
        }
    }
    private void insertEnemy(int x, int y) {
        switch (id) {
            case 1:
                Enemy enemy;
                enemy = new Enemy1_1(refLink, x, y, 0.5f);
                enemy.setHealth(30);
                enemy.setDirection("right");
                enemies.add(enemy);
                break;
            case 2:
                Enemy enemy1;
                enemy1 = new Enemy2_1(refLink, x, y, 0.5f);
                enemy1.setHealth(40);
                enemy1.setDirection("right");
                enemies.add(enemy1);
                break;
            case 3:
                Enemy enemy2;
                enemy2 = new Enemy3_1(refLink, x, y, 2.0f);
                enemy2.setHealth(50);
                enemy2.setDirection("right");
                enemies.add(enemy2);
                break;
        }
    }
}
