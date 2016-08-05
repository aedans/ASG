package game.gamestates.mainmenugamestate;

import game.renderer.data.RenderList;
import game.renderer.data.Renderable;
import game.sprites.EntityList;
import game.renderer.Renderer;
import game.gamestates.GameState;

/**
 * Created by Aedan Smith on 7/6/2016.
 */

public class MainMenuGameState extends GameState {

    public MainMenuGameState() {

    }

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
