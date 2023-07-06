package Joc.Entities;

import Joc.RefLink;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public abstract class Item {
    protected RefLink refLink;
    protected BufferedImage texture;
    protected int width;
    protected int height;
    protected float scale;
    protected float x;
    protected float y;
    protected int ofsetX;
    protected int ofsetY;
    protected Rectangle2D.Float hitbox;
    public Item(RefLink refLink, float x, float y, int width, int height, float scale) {
        this.refLink = refLink;
        this.x = x;
        this.y = y;
        this.scale = scale;
        this.width = (int) (width * scale);
        this.height = (int) (height * scale);
    }
    protected void initHitbox(int ofsetX, int ofsetY, int ofsetWidth, int ofsetHeight) {
        hitbox = new Rectangle2D.Float(x + ofsetX * scale, y + ofsetY * scale, ofsetWidth * scale, ofsetHeight * scale);
        this.ofsetX = (int) (ofsetX * scale);
        this.ofsetY = (int) (ofsetY * scale);
    }
    protected void drawHitbox(Graphics g) {
        g.setColor(Color.CYAN);
        g.drawRect((int) hitbox.x, (int) hitbox.y, (int) hitbox.width, (int) hitbox.height);
    }
    public abstract void Update();
    public abstract void Draw(Graphics g);

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public Rectangle2D.Float getHitbox() {
        return hitbox;
    }

    public void setTexture(BufferedImage texture) {
        this.texture = texture;
    }

    public void setX(float x) {
        hitbox.x = x + ofsetX;
    }

    public void setY(float y) {
        hitbox.y = y + ofsetY;
    }
}
