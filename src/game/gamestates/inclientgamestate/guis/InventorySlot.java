package game.gamestates.inclientgamestate.guis;

import game.gui.ConstRender;
import game.renderer.Position;
import game.sprites.Textures;

/**
 * Created by Aedan Smith on 7/30/2016.
 */

@ConstRender
public class InventorySlot extends game.gui.GUI {

    public InventorySlot(int x, int y, int width, int height) {
        super(new Position(x, y), Textures.inventorySlotTexture, width, height);
    }

    @Override
    public void onPressed() {

    }

    @Override
    protected void onClick() {

    }

    @Override
    public void update() {

    }

}
