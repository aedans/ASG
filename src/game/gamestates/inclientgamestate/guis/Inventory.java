package game.gamestates.inclientgamestate.guis;

import game.gui.GUI;
import game.gui.GUIHub;
import game.item.Item;

/**
 * Created by Aedan Smith on 7/30/2016.
 */

public class Inventory extends GUIHub {

    private InventorySlot[] inventorySlots;

    public Inventory(int x, int y, int width, int height) {
        inventorySlots = new InventorySlot[width * height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                inventorySlots[i * height + j] = (new InventorySlot(x + i * 64, y + j * 64, 64, 64));
            }
        }
    }

    @Override
    public GUI[] getSubGUIs() {
        return inventorySlots;
    }

}
