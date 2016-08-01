package game.gamestates.inclientgamestate.guis;

import game.gui.OverlaidSprite;
import game.item.ItemStack;
import game.sprites.Textures;

/**
 * Created by Aedan Smith on 7/30/2016.
 */

@OverlaidSprite
public class InventorySlot extends game.gui.GUI {

    public InventorySlot(int x, int y, int width, int height) {
        super(Textures.basicGUITextureID, x, y, width, height);
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
