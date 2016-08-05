package game.gamestates;

import game.renderer.data.RenderList;
import game.renderer.data.Renderable;

/**
 * Created by Aedan Smith on 7/6/2016.
 */

public abstract class GameState {

    /**
     * Function called to update the GameState logic.
     */
    public abstract void update();

    /**
     * Function called when the Game wants to render the GameState.
     */
    public abstract void render();

    /**
     * Returns the RenderList that contains the given Renderable.
     *
     * @param r: The Renderable to find.
     * @return RenderList: The containing Renderable.
     */
    public abstract RenderList<Renderable> findContainer(Renderable r);

}
