package game.gamestates.inclientgamestate.entities;

import game.renderer.DisplayManager;
import game.renderer.math.Position;
import game.renderer.textures.TexturedModel;

/**
 * Created by Aedan Smith on 7/7/2016.
 */

public abstract class MoveableEntity extends Entity {

    public float xVel, yVel;
    private long lastTranslated = System.currentTimeMillis();

    public MoveableEntity(Position position, int texture, int width, int height) {
        super(position, texture, width, height);
    }

    public MoveableEntity(Position position, TexturedModel texturedModel) {
        super(position, texturedModel);
    }

    public void translate() {
        float m = (float) (System.currentTimeMillis() - lastTranslated) / 1000;
        getPosition().translate(
                xVel * m * (float) DisplayManager.targetResYRatio,
                yVel * m * (float) DisplayManager.targetResXRatio
        );
        this.lastTranslated = System.currentTimeMillis();
    }

}
