package Joc.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {
    private boolean[]   keys;
    public boolean      up;
    public boolean      down;
    public boolean      left;
    public boolean      right;

    public KeyManager() {
        keys = new boolean[256];
    }

    public void Update() {
        up      = keys[KeyEvent.VK_UP];
        down    = keys[KeyEvent.VK_DOWN];
        left    = keys[KeyEvent.VK_LEFT];
        right   = keys[KeyEvent.VK_RIGHT];
    }

    @Override
    public void keyPressed(KeyEvent e) {
        ///se retine in vectorul de flaguri ca o tasta a fost apasata.
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        ///se retine in vectorul de flaguri ca o tasta a fost eliberata.
        keys[e.getKeyCode()] = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
