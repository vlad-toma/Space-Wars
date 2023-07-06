package Joc;

import java.awt.*;
import java.awt.image.BufferStrategy;
import Joc.GameWindow.GameWindow;
import Joc.Input.KeyManager;
import Joc.Graphics.Assets;

import Joc.States.*;


public class Game implements Runnable{
    private GameWindow      wnd;
    private boolean         runState;
    private Thread          gameThread;
    private BufferStrategy  bs;
    private Graphics        g;
    private State           playState;
    private State           menuState;
    private State           settingsState;
    private State           aboutState;
    private KeyManager      keyManager;
    private RefLink         refLink;

    public Game(String title, int width, int height) {
        wnd = new GameWindow(title, width, height);
        runState    = false;
        keyManager  = new KeyManager();
    }

    private void Init() {
        wnd.BuildGameWindow();
        wnd.GetWindowFrame().addKeyListener(keyManager);
        Assets.Init();
        refLink         = new RefLink(this);
        playState       = new PlayState(refLink);
        menuState       = new MenuState(refLink);
        settingsState   = new SettingsState(refLink);
        aboutState      = new AboutState(refLink);
        State.SetState(playState);
    }

    public void run() {
        Init();

        long oldTime = System.nanoTime();
        long currentTime;

        final int framesPerSecond   = 60;
        final double timeFrame      = 1000000000 / framesPerSecond;

        while (runState) {
            currentTime = System.nanoTime();
            if ( (currentTime - oldTime) > timeFrame) {
                Update();
                Draw();
                oldTime = currentTime;
            }
        }
    }

    public synchronized void StartGame() {
        if (!runState) {
            runState    = true;
            gameThread  = new Thread(this);
            gameThread.start(); // lansează run ()
        }
        else {
            return;
        }
    }

    public synchronized void StopGame() {
        if (runState) {
            runState = false;
            try {
                gameThread.join();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        else {
            return;
        }
    }

    private void Update() {
        keyManager.Update();
        if (State.GetState() != null) {
            State.GetState().Update();
        }
    }

    private void Draw() {
        bs = wnd.GetCanvas().getBufferStrategy();
        if (bs == null) {
            try {
                wnd.GetCanvas().createBufferStrategy(3);
                return;
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        g = bs.getDrawGraphics();
        g.clearRect(0, 0, wnd.GetWindowWidth(), wnd.GetWindowHeight());
        if (State.GetState() != null) {
            State.GetState().Draw(g);
        }
        bs.show();
        g.dispose();
    }

    public int GetWidth() {
        return wnd.GetWindowWidth();
    }

    public int GetHeight() {
        return wnd.GetWindowHeight();
    }

    public KeyManager GetKeyManager() {
        return keyManager;
    }

    public void setState(State state) {
        State.SetState(state);
    }
}
