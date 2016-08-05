package game.gamestates.inclientgamestate.entities.player.controller;

import game.gamestates.inclientgamestate.ai.AI;
import org.lwjgl.util.vector.Vector2f;

/**
 * Created by Aedan Smith on 7/7/2016.
 */

public class AIController implements Controller {

    private AI ai = new AI();
    private int bestAction;
    @SuppressWarnings("FieldCanBeLocal")
    private int playerID;

    public AIController(int playerID) {
        this.playerID = playerID;
    }

    @Override
    public void update() {
        try {
            bestAction = ai.getBestAction();
        } catch (Exception e) {
            e.printStackTrace();
            bestAction = 0;
        }
    }

    @Override
    public boolean wantsToMoveUp() {
        return bestAction == 1 || bestAction == 5 || bestAction == 8;
    }

    @Override
    public boolean wantsToMoveDown() {
        return bestAction == 2 || bestAction == 6 || bestAction == 7;
    }

    @Override
    public boolean wantsToMoveLeft() {
        return bestAction == 3 || bestAction == 7 || bestAction == 8;
    }

    @Override
    public boolean wantsToMoveRight() {
        return bestAction == 4 || bestAction == 5 || bestAction == 6;
    }

    @Override
    public boolean wantsToShoot() {
        return false;
    }

    @Override
    public Vector2f getShotDirection() {
        return new Vector2f(0, 0);
    }

    public AI getAI() {
        return ai;
    }

}