package Joc.Entities.Projectiles;

import Joc.RefLink;
import Joc.Graphics.Assets;

public class Projectile_down1 extends Projectile {
    public static final int OfsetX = 50;
    public static final int OfsetY = 44;
    public static final int OfsetWidth = 24;

    public Projectile_down1(RefLink refLink, float x, float y, float scale) {
        super(refLink, x, y, Assets.projectile_down1.getWidth(), Assets.projectile_down1.getHeight(), scale, 1);
        setTexture(Assets.projectile_down1);
        initHitbox(50, 44, 24, 36);
        setSpeed(1.0f);
    }
}
