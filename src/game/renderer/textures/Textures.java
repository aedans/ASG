package game.renderer.textures;

import game.renderer.data.Loader;

import java.util.ArrayList;

/**
 * Created by Aedan Smith on 7/6/2016.
 */

public final class Textures {

    // TODO: Implement TextureList Support.

    /**
     * List of Textures for Sprites.
     */
    public static ArrayList<Integer> entityTextures = new ArrayList<>();

    public static int redPlayerTextureID = Loader.loadPNGTexture("red_circle");
    public static int bluePlayerTextureID = Loader.loadPNGTexture("blue_circle");
    public static int fireballTextureID = Loader.loadPNGTexture("small_orange_circle");
    public static int redBaseTextureID = Loader.loadJPGTexture("large_red_square");
    public static int blueBaseTextureID = Loader.loadJPGTexture("large_blue_square");
    public static int grassTextureID = Loader.loadJPGTexture("green_square");
    public static int mudTextureID = Loader.loadJPGTexture("brown_square");
    public static int waterTextureID = Loader.loadJPGTexture("blue_square");
    public static int testTextureID = Loader.loadPNGTexture("test");


    /**
     * List of Textures for GUIs.
     */
    public static ArrayList<Integer> GUITextures = new ArrayList<>();

    public static int blackTextureID = Loader.loadPNGTexture("black");
    public static int blankTextureID = Loader.loadPNGTexture("blank");
    public static int inventorySlotTexture = Loader.loadJPGTexture("grey_square");

    // Loads all Textures.
    static {
        // Players
        entityTextures.add(redPlayerTextureID);
        entityTextures.add(bluePlayerTextureID);

        // Projectiles
        entityTextures.add(fireballTextureID);
        entityTextures.add(testTextureID);

        // Structures
        entityTextures.add(redBaseTextureID);
        entityTextures.add(blueBaseTextureID);

        // Tiles
        entityTextures.add(grassTextureID);
        entityTextures.add(mudTextureID);
        entityTextures.add(waterTextureID);

        //GUI
        GUITextures.add(blankTextureID);
        GUITextures.add(inventorySlotTexture);
        GUITextures.add(blackTextureID);
    }

}
