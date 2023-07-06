package Joc.States;

import Joc.RefLink;

import java.awt.*;

public abstract class State {
    private static State previousState  = null;
    private static State currentState   = null;
    protected RefLink refLink;

    public State(RefLink refLink) {this.refLink = refLink;}

    public static void SetState(State state) {
        previousState = currentState;
        currentState = state;
    }

    public static State GetState() {return currentState;}

    public abstract void Update();

    public abstract void Draw(Graphics g);
}
