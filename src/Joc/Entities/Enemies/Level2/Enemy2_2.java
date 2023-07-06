package Joc.Entities.Enemies.Level2;

import Joc.Entities.Enemies.Enemy;
import Joc.Entities.Projectiles.Projectile_down1;
import Joc.Graphics.Assets;
import Joc.RefLink;

import java.util.Random;

public class Enemy2_2 extends Enemy {
    private long rand = new Random().nextInt(140) * 90000000L;

    public Enemy2_2(RefLink refLink, float x, float y, float scale) {
        super(refLink, x, y, Assets.enemy2_2.getWidth(), Assets.enemy2_2.getHeight(), scale);
        setTexture(Assets.enemy2_2);
        setHealth(50);
        setSpeed(0.0f);
        initHitbox(9, 0, 110, 128);
        oldTime = System.nanoTime();
    }

    @Override
    public void Update() {
        Move();

        for(Projectile_down1 p : projectiles)
            if(p.isActive())
                p.Update();
        if(alive) {
            currentTime = System.nanoTime();
            if ((currentTime - oldTime) > rand) {
                projectile = new Projectile_down1(refLink, hitbox.x + hitbox.width / 2 - 0.5f * Assets.projectile_down1.getWidth() / 2, hitbox.y + hitbox.height, 0.5f);
                projectile.setSpeed(4.0f);
                projectiles.add(projectile);
                oldTime = currentTime;
                rand = new Random().nextInt(20) * 600000000L;
            }
        }

        super.Update();
    }
    public boolean isActiveProjectiles() {
        return activeProjectiles;
    }
}

