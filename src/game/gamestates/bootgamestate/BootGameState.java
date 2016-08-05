package game.gamestates.bootgamestate;

import game.gamestates.GameState;
import game.renderer.Renderer;
import game.renderer.data.RenderList;
import game.renderer.data.Renderable;

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

    @Override
    public RenderList<Renderable> findContainer(Renderable sprite) {
        return null;
    }

}