package game.gamestates.inclientgamestate.entities.player;

import game.Game;
import game.gamestates.inclientgamestate.entities.MoveableEntity;
import game.renderer.math.Position;
import game.renderer.textures.Textures;
import game.gamestates.inclientgamestate.entities.structures.Base;
import game.gamestates.inclientgamestate.entities.player.controller.Controller;
import game.gamestates.inclientgamestate.entities.projectiles.Fireball;
import game.gamestates.inclientgamestate.entities.terrain.Mud;
import game.gamestates.inclientgamestate.entities.terrain.Water;
import org.lwjgl.input.Keyboard;

/**
 * Created by Aedan Smith on 7/6/2016.
 */

@SuppressWarnings("Duplicates")
public class Player extends MoveableEntity {

    public float speed = .65f;
    public boolean red;
    private int lastShot = 0;
    private Controller controller;

    public Player(Controller controller, boolean red, int x, int y) {
        super(new Position(x, y), red ? Textures.redPlayerTextureID : Textures.bluePlayerTextureID, 64, 64);
        this.red = red;
        this.controller = controller;
    }

    @Override
    public void update() {
        this.controller.update();
        this.xVel = 0;
        this.yVel = 0;
        lastShot++;

        if (Game.inClientGameState.map.getTileAt(getGridX(), getGridY()).getClass() == Mud.class || Game.inClientGameState.map.getTileAt(getGridX(), getGridY()).getClass() == Water.class)
            this.speed = .48f;
        else
            this.speed = .65f;

        if (controller.wantsToMoveLeft() && canMoveLeft())
            this.xVel = -speed;
        if (controller.wantsToMoveRight() && canMoveRight())
            this.xVel = speed;
        if (controller.wantsToMoveUp() && canMoveUp())
            this.yVel = speed;
        if (controller.wantsToMoveDown() && canMoveDown())
            this.yVel = -speed;

        if (controller.wantsToShoot() && canShoot()) {
            Game.inClientGameState.sprites.add(new Fireball(controller.getShotDirection(), getPosition().deepClone()));
            lastShot = 0;
        }

        if (xVel != 0 && yVel != 0) {
            xVel /= 1.5;
            yVel /= 1.5;
        }

        translate();
    }

    private boolean canShoot() {
        return lastShot > 15;
    }

    public boolean canMoveLeft() {
        if (getPosition().getPixelX() <= 0)
            return false;
        return !Game.inClientGameState.map.getTileAt((getPosition().getPixelX() / 64), (32 + getPosition().getPixelY()) / 64).isGroundCollidable();
    }

    public boolean canMoveRight() {
        if (getPosition().getPixelX() + 64 >= Game.inClientGameState.map.getPixelWidth())
            return false;
        return !Game.inClientGameState.map.getTileAt((getPosition().getPixelX() / 64) + 1, (32 + getPosition().getPixelY()) / 64).isGroundCollidable();
    }

    public boolean canMoveUp() {
        if (getPosition().getPixelY() + 64 >= Game.inClientGameState.map.getPixelHeight())
            return false;
        return !Game.inClientGameState.map.getTileAt((32 + getPosition().getPixelX()) / 64, ((getPosition().getPixelY()) / 64) + 1).isGroundCollidable();
    }

    public boolean canMoveDown() {
        if (getPosition().getPixelY() <= 0)
            return false;
        return !Game.inClientGameState.map.getTileAt((32 + getPosition().getPixelX()) / 64, ((getPosition().getPixelY()) / 64)).isGroundCollidable();
    }

    @Override
    public void onRender() {

    }

    @Override
    protected void onDestruction() {

    }

    public Base getOpponentBase() {
        return red ? Game.inClientGameState.blueBase : Game.inClientGameState.redBase;
    }

    public Controller getController() {
        return controller;
    }

}
