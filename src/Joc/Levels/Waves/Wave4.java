package Joc.Levels.Waves;


import Joc.Entities.Enemies.Enemy;
import Joc.Entities.Enemies.Level1.Boss1_1;
import Joc.Entities.Enemies.Level1.Boss1_2;
import Joc.Entities.Enemies.Level1.Enemy1_1;
import Joc.Entities.Enemies.Level1.Enemy1_2;
import Joc.Entities.Enemies.Level2.Boss2_1;
import Joc.Entities.Enemies.Level2.Boss2_2;
import Joc.Entities.Enemies.Level2.Enemy2_1;
import Joc.Entities.Enemies.Level2.Enemy2_2;
import Joc.Entities.Enemies.Level3.Boss3_1;
import Joc.Entities.Enemies.Level3.Boss3_2;
import Joc.Entities.Enemies.Level3.Enemy3_1;
import Joc.Entities.Enemies.Level3.Enemy3_2;
import Joc.Levels.Wave;
import Joc.RefLink;

public class Wave4 extends Wave {
    public Wave4(RefLink refLink, int id) {
        super(refLink, id);
    }
    @Override
    public void InitLevel() {
        insertEnemy(64, 0, 1);
        insertEnemy( 256, 0, 1);
        insertEnemy( 448, 0, 1);
        insertEnemy( 768, 0, 1);
        insertEnemy( 960, 0, 1);
        insertEnemy( 1152, 0, 1);
        insertEnemy( 0, 384, 1);
        insertEnemy( 192, 384, 1);
        insertEnemy( 384, 384, 1);
        insertEnemy( 512, 448, 1);
        insertEnemy( 704, 448, 1);
        insertEnemy( 832, 384, 1);
        insertEnemy( 1024, 384, 1);
        insertEnemy( 1216, 384, 1);
        insertEnemy( 0, 128, 2);
        insertEnemy( 0, 256, 2);
        insertEnemy( 384, 128, 2);
        insertEnemy( 384, 256, 2);
        insertEnemy( 832, 128, 2);
        insertEnemy( 832, 256, 2);
        insertEnemy( 1216, 128, 2);
        insertEnemy( 1216, 256, 2);
        insertEnemy( 128, 128, 4);
        insertEnemy( 512, 128, 3);
        insertEnemy( 960, 128, 4);
    }
    private void insertEnemy(int x, int y, int type) {
        switch (id) {
            case 1:
                switch (type) {
                    case 1:
                        Enemy enemy = new Enemy1_1(refLink, x, y, 0.5f);
                        enemy.setHealth(30);
                        enemy.setDirection("none");
                        enemies.add(enemy);
                        break;
                    case 2:
                        Enemy enemy1 = new Enemy1_2(refLink, x, y, 0.5f);
                        enemy1.setHealth(30);
                        enemy1.setDirection("none");
                        enemies.add(enemy1);
                        break;
                    case 3:
                        Enemy enemy2 = new Boss1_1(refLink, x, y, 2.0f);
                        enemy2.setHealth(120);
                        enemy2.setDirection("none");
                        enemies.add(enemy2);
                        break;
                    case 4:
                        Enemy enemy3 = new Boss1_2(refLink, x, y, 1.5f);
                        enemy3.setHealth(120);
                        enemy3.setDirection("none");
                        enemies.add(enemy3);
                        break;
                }
                break;
            case 2:
                switch (type) {
                    case 1:
                        Enemy enemy = new Enemy2_1(refLink, x, y, 0.5f);
                        enemy.setHealth(40);
                        enemy.setDirection("none");
                        enemies.add(enemy);
                        break;
                    case 2:
                        Enemy enemy1 = new Enemy2_2(refLink, x, y, 0.5f);
                        enemy1.setHealth(40);
                        enemy1.setDirection("none");
                        enemies.add(enemy1);
                        break;
                    case 3:
                        Enemy enemy2 = new Boss2_1(refLink, x, y, 2.0f);
                        enemy2.setHealth(200);
                        enemy2.setDirection("none");
                        enemies.add(enemy2);
                        break;
                    case 4:
                        Enemy enemy3 = new Boss2_2(refLink, x, y, 1.5f);
                        enemy3.setHealth(200);
                        enemy3.setDirection("none");
                        enemies.add(enemy3);
                        break;
                }
                break;
            case 3:
                switch (type) {
                    case 1:
                        Enemy enemy = new Enemy3_1(refLink, x, y, 2.0f);
                        enemy.setHealth(50);
                        enemy.setDirection("none");
                        enemies.add(enemy);
                        break;
                    case 2:
                        Enemy enemy1 = new Enemy3_2(refLink, x, y, 2.0f);
                        enemy1.setHealth(50);
                        enemy1.setDirection("none");
                        enemies.add(enemy1);
                        break;
                    case 3:
                        Enemy enemy2 = new Boss3_1(refLink, x, y, 2.0f);
                        enemy2.setHealth(300);
                        enemy2.setDirection("none");
                        enemies.add(enemy2);
                        break;
                    case 4:
                        Enemy enemy3 = new Boss3_2(refLink, x, y, 1.5f);
                        enemy3.setHealth(300);
                        enemy3.setDirection("none");
                        enemies.add(enemy3);
                        break;
                }
                break;
        }
    }
}

