package game.gamestates.inclientgamestate.guis;

import game.renderer.DisplayManager;

/**
 * Created by Aedan Smith on 7/30/2016.
 */

public class PlayerInventory extends Inventory {

    public PlayerInventory() {
        super(32, DisplayManager.yRes - 96, 5, 2);
    }

}
