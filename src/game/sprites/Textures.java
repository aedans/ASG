package game.sprites;

import game.renderer.Loader;

import java.util.ArrayList;

/**
 * Created by Aedan Smith on 7/6/2016.
 */

public final class Textures {

    public static ArrayList<Integer> spriteTextures = new ArrayList<>();

    public static int redPlayerTextureID = Loader.loadPNGTexture("red_circle");
    public static int bluePlayerTextureID = Loader.loadPNGTexture("blue_circle");
    public static int fireballTextureID = Loader.loadPNGTexture("small_orange_circle");
    public static int redBaseTextureID = Loader.loadJPGTexture("large_red_square");
    public static int blueBaseTextureID = Loader.loadJPGTexture("large_blue_square");
    public static int grassTextureID = Loader.loadJPGTexture("green_square");
    public static int mudTextureID = Loader.loadJPGTexture("brown_square");
    public static int waterTextureID = Loader.loadJPGTexture("blue_square");

    public static ArrayList<Integer> GUITextures = new ArrayList<>();

    public static int blankTextureID = Loader.loadPNGTexture("blank");
    public static int testTextureID = Loader.loadPNGTexture("test");
    public static int basicGUITextureID = Loader.loadJPGTexture("grey_square");

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
        GUITextures.add(basicGUITextureID);
    }

}
