package game.item;

/**
 * Created by Aedan Smith on 7/30/2016.
 */

public abstract class Item {

    private int textureID;

    public Item(int textureID){
        this.textureID = textureID;
    }

    public int getTextureID() {
        return textureID;
    }

    public abstract void onPressed();

    public abstract void onClick();

    public abstract void update();

}
