package game.gamestates.inclientgamestate.entities.projectiles;

import game.gamestates.inclientgamestate.entities.lights.Light;
import game.sprites.Textures;
import org.lwjgl.util.vector.Vector2f;

/**
 * Created by Aedan Smith on 7/7/2016.
 */

public class Fireball extends Projectile implements Light {

    public Fireball(Vector2f velocity, int x, int y) {
        super(Textures.fireballTextureID, x, y, 16, 16);
        this.xVel = velocity.getX()*1.1f;
        this.yVel = velocity.getY()*1.1f;
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
    public float getStrength() {
        return .7f;
    }

}
