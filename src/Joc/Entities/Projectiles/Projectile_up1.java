package Joc.Entities.Projectiles;

import Joc.RefLink;
import Joc.Graphics.Assets;

public class Projectile_up1 extends Projectile {

    public Projectile_up1(RefLink refLink, float x, float y, float scale) {
        super(refLink, x, y, Assets.projectile_up1.getWidth(), Assets.projectile_up1.getHeight(), scale, -1);
        setTexture(Assets.projectile_up1);
        initHitbox(57, 51, 15, 30);
        setSpeed(1.0f);
    }
}
