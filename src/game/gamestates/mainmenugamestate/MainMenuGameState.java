package game.gamestates.mainmenugamestate;

import game.sprites.SpriteList;
import game.renderer.Renderer;
import game.gamestates.GameState;

/**
 * Created by Aedan Smith on 7/6/2016.
 */

public class MainMenuGameState extends GameState {

    public SpriteList spriteList = new SpriteList();

    public MainMenuGameState() {

    }

    @Override
    public void update() {
        spriteList.update();
    }

    @Override
    public void render() {
        Renderer.prepare();
        Renderer.render(spriteList, Renderer.Shader.LIGHT);
    }

}
