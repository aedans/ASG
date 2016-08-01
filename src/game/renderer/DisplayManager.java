package game.renderer;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.*;

/**
 * Created by Aedan Smith on 5/3/2016.
 */

public final class DisplayManager {

    public static int fpscap = Display.getDesktopDisplayMode().getFrequency()*2;
    public static int xRes, yRes;
    public static float ppX, ppY;
    public static int blackBarWidth, blackBarHeight;

    public static void createDisplay(int xRes, int yRes, boolean fullscreen, String title) throws LWJGLException {
        DisplayManager.xRes = xRes;
        DisplayManager.yRes = yRes;
        ppX = 1.0f/(float)DisplayManager.xRes;
        ppY = 1.0f/(float)DisplayManager.yRes;
        if (xRes > yRes){
            blackBarWidth = (xRes-yRes)/2;
            blackBarHeight = 0;
            System.out.println(blackBarWidth);
        } else {

        }
        ContextAttribs attributes = new ContextAttribs(3, 2)
                .withForwardCompatible(true)
                .withProfileCore(true);
        Display.setDisplayMode(new DisplayMode(xRes, yRes));
        Display.setResizable(false);
        Display.setFullscreen(fullscreen);
        Display.create(new PixelFormat(), attributes);
        Display.setTitle(title);
        GL11.glViewport(0, 0, xRes, yRes);
    }

    public static boolean isCloseRequested(){
        return Display.isCloseRequested();
    }

    public static void updateDisplay(){
        Display.sync(fpscap);
        Display.update();
    }

    public static void closeDisplay(){
        Display.destroy();
    }

    private DisplayManager(){}

}