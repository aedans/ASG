package game.gamestates.inclientgamestate.entities;

import game.sprites.Sprite;
import game.renderer.TexturedModel;
import org.lwjgl.util.vector.Vector2f;

import java.awt.geom.Point2D;

/**
 * Created by Aedan Smith on 7/4/2016.
 */

public abstract class Entity extends Sprite {

    public Entity(int textureID, int width, int height){
        super(textureID, width, height);
    }

    public Entity(int textureID, float x, float y, int width, int height){
        super(textureID, x, y, width, height);
    }

    public Entity(int textureID, Point2D.Float position, int width, int height){
        super(textureID, position, width, height);
    }

    public Entity(Point2D.Float onScreenPosition, TexturedModel texturedModel){
        super(onScreenPosition, texturedModel);
    }

    public int getGridX(){
        return (int) ((32+ getPixelPosition().getX())/64);
    }

    public int getGridY(){
        return (int) ((32+ getPixelPosition().getY())/64);
    }

}
