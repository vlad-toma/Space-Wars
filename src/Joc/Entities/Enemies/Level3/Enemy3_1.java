package Joc.Entities.Enemies.Level3;

import Joc.Entities.Enemies.Enemy;
import Joc.Entities.Projectiles.Projectile_down1;
import Joc.Graphics.Assets;
import Joc.RefLink;

import java.util.Random;

public class Enemy3_1 extends Enemy {
    private long rand = new Random().nextInt(140) * 80000000L;

    public Enemy3_1(RefLink refLink, float x, float y, float scale) {
        super(refLink, x, y, Assets.enemy3_1.getWidth(), Assets.enemy3_1.getHeight(), scale);
        setTexture(Assets.enemy3_1);
        setHealth(50);
        setSpeed(0.0f);
        initHitbox(1, 1, 30, 30);
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
                projectile.setSpeed(5.0f);
                projectiles.add(projectile);
                oldTime = currentTime;
                rand = new Random().nextInt(20) * 400000000L;
            }
        }

        super.Update();
    }
}
