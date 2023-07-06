package Joc.Entities.Enemies.Level1;

import Joc.Entities.Enemies.Enemy;
import Joc.Entities.Projectiles.Projectile_down1;
import Joc.Graphics.Assets;
import Joc.RefLink;

import java.util.Random;

public class Boss1_1 extends Enemy {

    private long rand = new Random().nextInt(70) * 90000000L;


    public Boss1_1(RefLink refLink, float x, float y, float scale) {
        super(refLink, x, y, Assets.boss1_1.getWidth(), Assets.boss1_1.getHeight(), scale);
        setTexture(Assets.boss1_1);
        setHealth(50);
        setSpeed(0.0f);
        initHitbox(1, 5, 118, 126);
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
                projectile = new Projectile_down1(refLink, hitbox.x - Projectile_down1.OfsetX, hitbox.y + hitbox.height - Projectile_down1.OfsetY, 1.0f);
                projectile.setSpeed(5.0f);
                projectiles.add(projectile);
                projectile = new Projectile_down1(refLink, hitbox.x + hitbox.width - Projectile_down1.OfsetX - Projectile_down1.OfsetWidth, hitbox.y + hitbox.height - Projectile_down1.OfsetY, 1.0f);
                projectile.setSpeed(5.0f);
                projectiles.add(projectile);
                oldTime = currentTime;
                rand = new Random().nextInt(20) * 300000000L;
            }
        }

        super.Update();
    }
}
