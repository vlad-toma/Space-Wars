package Joc.Entities.Projectiles;

import Joc.Entities.Item;
import Joc.RefLink;

import java.awt.*;

public abstract class Projectile extends Item {
    protected int direction;
    protected boolean active = true;
    protected float speed;

    public Projectile(RefLink refLink, float x, float y, int width, int height, float scale, int direction) {
        super(refLink, x, y, width, height, scale);
        this.direction = direction;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    @Override
    public void Update() {
        if(hitbox.y >= refLink.GetHeight())
            active = false;
        if(hitbox.y <= 0)
            active = false;
        hitbox.y += speed * direction;
    }

    @Override
    public void Draw(Graphics g) {
        g.drawImage(texture, (int) (hitbox.x - ofsetX), (int) (hitbox.y - ofsetY), width, height, null);
        //drawHitbox(g);
        g.setColor(Color.red);
        //g.drawRect((int) (hitbox.x - ofsetX), (int) (hitbox.y - ofsetY), width, height);
    }

}
