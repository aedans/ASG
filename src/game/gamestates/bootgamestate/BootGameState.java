package game.gamestates.bootgamestate;

import game.gamestates.GameState;
import game.renderer.Renderer;

/**
 * Created by Aedan Smith on 7/6/2016.
 */

public class BootGameState extends GameState {

    @Override
    public void update() {

    }

    @Override
    public void render() {
        Renderer.prepare();
    }

}