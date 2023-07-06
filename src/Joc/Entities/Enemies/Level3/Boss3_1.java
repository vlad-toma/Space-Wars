package Joc.Entities.Enemies.Level3;

import Joc.Entities.Enemies.Enemy;
import Joc.Entities.Projectiles.Projectile_down1;
import Joc.Graphics.Assets;
import Joc.RefLink;

import java.util.Random;

public class Boss3_1 extends Enemy {

    private long rand = new Random().nextInt(70) * 40000000L;

    public Boss3_1(RefLink refLink, float x, float y, float scale) {
        super(refLink, x, y, Assets.boss3_1.getWidth(), Assets.boss3_1.getHeight(), scale);
        setTexture(Assets.boss3_1);
        setHealth(50);
        setSpeed(0.0f);
        initHitbox(0, 0, 122, 101);
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
                projectile.setSpeed(9.0f);
                projectiles.add(projectile);
                projectile = new Projectile_down1(refLink, hitbox.x + hitbox.width - Projectile_down1.OfsetX - Projectile_down1.OfsetWidth, hitbox.y + hitbox.height - Projectile_down1.OfsetY, 1.0f);
                projectile.setSpeed(9.0f);
                projectiles.add(projectile);
                oldTime = currentTime;
                rand = new Random().nextInt(20) * 100000000L;
            }
        }

        super.Update();
    }
}
