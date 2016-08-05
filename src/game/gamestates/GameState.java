package game.gamestates;

import game.renderer.data.RenderList;
import game.renderer.data.Renderable;

/**
 * Created by Aedan Smith on 7/6/2016.
 */

public abstract class GameState {

    public abstract void update();

    public abstract void render();

    public abstract RenderList<Renderable> findContainer(Renderable sprite);

}
