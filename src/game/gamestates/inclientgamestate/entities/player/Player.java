package game.gamestates.inclientgamestate.entities.player;

import game.Game;
import game.gamestates.inclientgamestate.entities.MoveableEntity;
import game.gamestates.inclientgamestate.entities.player.controller.Controller;
import game.gamestates.inclientgamestate.entities.projectiles.Fireball;
import game.gamestates.inclientgamestate.entities.structures.Base;
import game.gamestates.inclientgamestate.entities.terrain.Mud;
import game.gamestates.inclientgamestate.entities.terrain.Tile;
import game.gamestates.inclientgamestate.entities.terrain.Water;
import game.renderer.math.Position;
import game.renderer.textures.Textures;

/**
 * Created by Aedan Smith on 7/6/2016.
 */

@SuppressWarnings("Duplicates")
public class Player extends MoveableEntity {

    public float speed = .9f;
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

        if (Game.inClientGameState.world.getTileMap().getTileAt(getGridX(), getGridY()).getClass() == Mud.class
                || Game.inClientGameState.world.getTileMap().getTileAt(getGridX(), getGridY()).getClass() == Water.class)
            this.speed = .65f;
        else
            this.speed = .9f;

        if (controller.wantsToMoveLeft() && canMoveLeft())
            this.xVel = -speed;
        if (controller.wantsToMoveRight() && canMoveRight())
            this.xVel = speed;
        if (controller.wantsToMoveUp() && canMoveUp())
            this.yVel = speed;
        if (controller.wantsToMoveDown() && canMoveDown())
            this.yVel = -speed;

        if (controller.wantsToShoot() && canShoot()) {
            Game.inClientGameState.world.add(new Fireball(controller.getShotDirection(), getPosition().deepClone()));
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
        return !Game.inClientGameState.world.getTileMap().getTileAt(
                (int) (getPosition().getPixelX() / Tile.size),
                (int) ((Tile.size/2 + getPosition().getPixelY()) / Tile.size)
        ).isGroundCollidable();
    }

    public boolean canMoveRight() {
        if (getPosition().getPixelX() + Tile.size >= Game.inClientGameState.world.getPixelWidth())
            return false;
        return !Game.inClientGameState.world.getTileMap().getTileAt(
                (int) (getPosition().getPixelX() / Tile.size) + 1,
                (int) ((Tile.size/2 + getPosition().getPixelY()) / Tile.size)
        ).isGroundCollidable();
    }

    public boolean canMoveUp() {
        if (getPosition().getPixelY() + Tile.size >= Game.inClientGameState.world.getPixelHeight())
            return false;
        return !Game.inClientGameState.world.getTileMap().getTileAt(
                (int) ((Tile.size/2 + getPosition().getPixelX()) / Tile.size),
                (int) ((getPosition().getPixelY()) / Tile.size) + 1
        ).isGroundCollidable();
    }

    public boolean canMoveDown() {
        if (getPosition().getPixelY() <= 0)
            return false;
        return !Game.inClientGameState.world.getTileMap().getTileAt(
                (int) ((Tile.size/2 + getPosition().getPixelX()) / Tile.size),
                (int) ((getPosition().getPixelY()) / Tile.size)
        ).isGroundCollidable();
    }

    @Override
    public void onRender() {

    }

    @Override
    public void onDestruction() {

    }

    public Base getOpponentBase() {
        return red ? Game.inClientGameState.blueBase : Game.inClientGameState.redBase;
    }

    public Controller getController() {
        return controller;
    }

}
