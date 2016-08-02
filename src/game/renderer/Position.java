package game.renderer;

import org.lwjgl.opengl.Display;

/**
 * Created by Aedan Smith on 8/2/2016.
 *
 * Class used to track the position of a sprite on the OpenGL and Pixel coordinate planes.
 */

public class Position {

    /**
     * The Pixel position of the Position.
     */
    private int px, py;

    /**
     * The OpenGL Position of the Position.
     */
    private float ox, oy;

    /**
     * Default Position constructor.
     *
     * @param px: The X position on the Pixel coordinate plane.
     * @param py: The Y position on the Pixel coordinate plane.
     */
    public Position(int px, int py){
        this(
                px,
                py,
                DisplayManager.ppX * px,
                DisplayManager.ppY * py
        );
    }

    /**
     * Default Position constructor.
     *
     * @param ox: The X position on the OpenGL coordinate plane.
     * @param oy: The Y position on the OpenGL coordinate plane.
     */
    public Position(float ox, float oy){
        this(
                (int) (ox / DisplayManager.ppX),
                (int) (oy / DisplayManager.ppY),
                ox,
                oy
        );
    }

    /**
     * Private Position constructor.
     *
     * @param px: The X position on the Pixel coordinate plane.
     * @param py: The Y position on the Pixel coordinate plane.
     * @param ox: The X position on the OpenGL coordinate plane.
     * @param oy: The Y position on the OpenGL coordinate plane.
     */
    private Position(int px, int py, float ox, float oy){
        this.px = px;
        this.py = py;
        this.ox = ox;
        this.oy = oy;
    }

    public int getPixelX(){
        return px;
    }

    public int getPixelY(){
        return py;
    }

    public float getOpenGLX(){
        return ox;
    }

    public float getOpenGLY(){
        return oy;
    }

}
