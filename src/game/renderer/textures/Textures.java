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
    public static ArrayList<Integer> spriteTextures = new ArrayList<>();

    public static int redPlayerTextureID = Loader.loadPNGTexture("red_circle");
    public static int bluePlayerTextureID = Loader.loadPNGTexture("blue_circle");
    public static int fireballTextureID = Loader.loadPNGTexture("small_orange_circle");
    public static int redBaseTextureID = Loader.loadJPGTexture("large_red_square");
    public static int blueBaseTextureID = Loader.loadJPGTexture("large_blue_square");
    public static int grassTextureID = Loader.loadJPGTexture("green_square");
    public static int mudTextureID = Loader.loadJPGTexture("brown_square");
    public static int waterTextureID = Loader.loadJPGTexture("blue_square");

    /**
     * List of Textures for GUIs.
     */
    public static ArrayList<Integer> GUITextures = new ArrayList<>();

    public static int blackTextureID = Loader.loadPNGTexture("black");
    public static int blankTextureID = Loader.loadPNGTexture("blank");
    public static int testTextureID = Loader.loadPNGTexture("test");
    public static int inventorySlotTexture = Loader.loadJPGTexture("grey_square");

    // Loads all Textures.
    static {
        // Players
        spriteTextures.add(redPlayerTextureID);
        spriteTextures.add(bluePlayerTextureID);

        // Projectiles
        spriteTextures.add(fireballTextureID);

        // Structures
        spriteTextures.add(redBaseTextureID);
        spriteTextures.add(blueBaseTextureID);

        // Tiles
        spriteTextures.add(grassTextureID);
        spriteTextures.add(mudTextureID);
        spriteTextures.add(waterTextureID);

        //GUI
        GUITextures.add(blankTextureID);
        GUITextures.add(testTextureID);
        GUITextures.add(inventorySlotTexture);
        GUITextures.add(blackTextureID);
    }

}