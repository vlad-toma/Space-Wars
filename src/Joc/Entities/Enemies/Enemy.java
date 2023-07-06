package Joc.Entities.Enemies;

import Joc.Entities.Character;
import Joc.Entities.Projectiles.Projectile_down1;
import Joc.RefLink;

import java.awt.*;
import java.util.ArrayList;
public abstract class Enemy extends Character {
    protected Projectile_down1 projectile;
    protected ArrayList<Projectile_down1> projectiles = new ArrayList<>();
    protected long oldTime = 0;
    protected long currentTime;

    protected boolean activeProjectiles = true;
    public Enemy(RefLink refLink, float x, float y, int width, int height, float scale) {
        super(refLink, x, y, width, height, scale);
    }

    public ArrayList<Projectile_down1> getProjectiles() {return projectiles;}

    public void setProjectiles(ArrayList<Projectile_down1> projectiles) {this.projectiles = projectiles;}

    public boolean isActiveProjectiles() {
        return activeProjectiles;
    }

    public void Update() {
        for(int i = 0; i < projectiles.size(); i++)
            if(!projectiles.get(i).isActive()) {
                projectiles.remove(i);
                i--;
            }

        if(health <= 0)
            alive = false;
        if(projectiles.isEmpty())
            activeProjectiles = false;
        else
            activeProjectiles = true;
    }

    public void Draw(Graphics g) {
        if(alive) {
            g.drawImage(texture, (int) (hitbox.x - ofsetX), (int) (hitbox.y - ofsetY), width, height, null);
            //drawHitbox(g);
            //g.setColor(Color.red);
            //g.drawRect((int) (hitbox.x - ofsetX), (int) (hitbox.y - ofsetY), width, height);
        }
        for (Projectile_down1 p : projectiles)
            if (p.isActive())
                p.Draw(g);
    }

    public void setDirection(String string) {
        switch (string) {
            case "down":
                xMove = 0;
                yMove = 1;
                break;
            case "right":
                xMove = 1;
                yMove = 0;
                break;
            default:
                xMove = 0;
                yMove = 0;
        }
    }
}
