package Joc.Entities;

import Joc.RefLink;

public abstract class Character extends Item {
    protected int health;
    protected boolean alive = true;
    protected float speed;
    protected float xMove;
    protected float yMove;

    public Character(RefLink refLink, float x, float y, int width, int height, float scale) {
        super(refLink, x, y, width, height, scale);
        speed = 0.0f;
        xMove = 0;
        yMove = 0;
    }

    public abstract void Update();
    public void Move() {
        hitbox.x += speed * xMove;
        hitbox.y += speed * yMove;
    }

    public boolean isAlive() {return alive;}

    public int getHealth() {return health;}

    public void setHealth(int health) {this.health = health;}

    public void setSpeed(float speed) {this.speed = speed;}
}
