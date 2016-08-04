package game.item;

import game.gui.GUI;
import game.renderer.Position;

import java.util.Objects;

/**
 * Created by Aedan Smith on 7/30/2016.
 */

public class ItemStack extends GUI {

    private Item item;
    private int stackSize;

    public ItemStack(Item item, int stackSize, int x, int y) {
        super(new Position(x, y), item.getTextureID(), 64, 64);
        this.item = item;
        this.stackSize = stackSize;
    }

    public Item getItem() {
        return item;
    }

    public int getStackSize() {
        return stackSize;
    }

    public boolean add(Item item, int num) {
        if (this.item == null || stackSize == 0) {
            this.item = item;
            this.stackSize = num;
            return true;
        }
        if (Objects.equals(this.item.getClass().getSimpleName(), item.getClass().getSimpleName())) {
            this.stackSize += num;
            return true;
        }
        return false;
    }

    @Override
    public void onPressed() {
        if (item != null)
            item.onPressed();
    }

    @Override
    protected void onClick() {
        if (item != null)
            item.onClick();
    }

    @Override
    public void update() {
        if (item != null)
            item.update();
    }

}
