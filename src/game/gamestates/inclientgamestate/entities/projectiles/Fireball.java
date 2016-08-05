package game.gamestates.inclientgamestate.entities.projectiles;

import game.gamestates.inclientgamestate.entities.lights.Light;
import game.renderer.math.Position;
import game.renderer.textures.Textures;
import org.lwjgl.util.vector.Vector2f;

/**
 * Created by Aedan Smith on 7/7/2016.
 */

public class Fireball extends Projectile implements Light {

    public Fireball(Vector2f velocity, Position position) {
        super(position, Textures.fireballTextureID, 16, 16);
        this.xVel = velocity.getX() * 1.5f;
        this.yVel = velocity.getY() * 1.5f;
        this.isLight = true;
    }

    @Override
    public void update() {
        super.doCollisions();
        translate();
    }

    @Override
    public void onRender() {

    }

    @Override
    public void onDestruction() {

    }

    @Override
    public float getStrength() {
        return .75f;
    }

}
