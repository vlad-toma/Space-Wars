package Joc.Entities;

import Joc.Entities.Projectiles.Projectile_up1;
import Joc.Graphics.Assets;
import Joc.RefLink;

import java.awt.*;
import java.util.ArrayList;

import static Joc.Methods.Method.tileIsAvailable;

public class Nava extends Character {
    private static Nava instance;
    private Projectile_up1 projectile;
    private ArrayList<Projectile_up1> projectiles = new ArrayList<>();
    private long oldTime = 0;
    private long currentTime;

    private Nava(RefLink refLink, float x, float y, float scale) {
        super(refLink, x, y, Assets.nava1.getWidth(), Assets.nava1.getHeight(), scale);
        setTexture(Assets.nava1);
        setHealth(100);
        setSpeed(6.0f);
        initHitbox(1, 20, 126, 88);

    }

    public static Nava GetInstance(RefLink refLink, float x, float y, float scale) {
        if(instance == null)
            instance = new Nava(refLink, x, y, scale);
        return instance;
    }

    @Override
    public void Update() {
        GetInput();
        // ANIMATII STANGA-DREAPTA
        // if(refLink.GetKeyManager().left == true)
        // image = Assets.heroLeft;
        for(Projectile_up1 p : projectiles)
            if(p.isActive())
                p.Update();

        currentTime = System.nanoTime();
        if ( (currentTime - oldTime) > 100000000) {
            projectile = new Projectile_up1(refLink, hitbox.x + hitbox.width / 2 - 0.4f * Assets.projectile_up1.getWidth() / 2, hitbox.y - 0.4f * Assets.projectile_up1.getHeight(), 0.4f);
            projectile.setSpeed(15.0f);
            projectiles.add(projectile);
            oldTime = currentTime;
        }
    }

    private void GetInput() {
        if (!refLink.GetKeyManager().left && !refLink.GetKeyManager().right
                && !refLink.GetKeyManager().up && !refLink.GetKeyManager().down)
            return;

        xMove = 0;
        yMove = 0;

        if(refLink.GetKeyManager().up && !refLink.GetKeyManager().down)
            yMove = -speed;
        else if(refLink.GetKeyManager().down && !refLink.GetKeyManager().up)
            yMove = speed;
        if(refLink.GetKeyManager().left && !refLink.GetKeyManager().right)
            xMove = -speed;
        else if(refLink.GetKeyManager().right && !refLink.GetKeyManager().left)
            xMove = speed;

        if(tileIsAvailable(hitbox.x + xMove, hitbox.y + yMove, (int) hitbox.width, (int) hitbox.height, refLink)) {
            hitbox.x += xMove;
            hitbox.y += yMove;
        }
    }

    @Override
    public void Draw(Graphics g) {
        g.drawImage(texture, (int) (hitbox.x - ofsetX), (int) (hitbox.y - ofsetY), width, height, null);
        //drawHitbox(g);
        g.setColor(Color.red);
        //g.drawRect((int) (hitbox.x - ofsetX), (int) (hitbox.y - ofsetY), width, height);
        for (Projectile_up1 p : projectiles)
            if (p.isActive())
                p.Draw(g);
    }

    public ArrayList<Projectile_up1> getProjectiles() {return projectiles;}

    public void setProjectiles(ArrayList<Projectile_up1> projectiles) {this.projectiles = projectiles;}

    public void Reset() {
        projectiles.clear();
        health = 100;
        setX(600);
        setY(700);
    }
}
