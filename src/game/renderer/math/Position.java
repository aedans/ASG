package game.renderer.math;

import game.renderer.DisplayManager;

/**
 * Created by Aedan Smith on 8/2/2016.
 * <p>
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
    public Position(int px, int py) {
        this(
                px,
                py,
                DisplayManager.ppX * px * 2,
                DisplayManager.ppY * py * 2
        );
    }

    /**
     * Default Position constructor.
     *
     * @param ox: The X position on the OpenGL coordinate plane.
     * @param oy: The Y position on the OpenGL coordinate plane.
     */
    public Position(float ox, float oy) {
        this(
                (int) (ox / DisplayManager.ppX / 2),
                (int) (oy / DisplayManager.ppY / 2),
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
    private Position(int px, int py, float ox, float oy) {
        this.px = px;
        this.py = py;
        this.ox = ox;
        this.oy = oy;
    }

    /**
     * Translates the position.
     *
     * @param px: The amount to translate horizontally on the Pixel coordinate plane.
     * @param py: The amount to translate vetically on the Pixel coordinate plane.
     * @return Position: this.
     */
    public Position translate(int px, int py) {
        this.px += px;
        this.py += py;
        this.ox = DisplayManager.ppX * this.px * 2;
        this.oy = DisplayManager.ppY * this.py * 2;
        return this;
    }

    /**
     * Translates the position.
     *
     * @param ox: The amount to translate horizontally on the OpenGL coordinate plane.
     * @param oy: The amount to translate vertically on the OpenGL coordinate plane.
     * @return Position: this.
     */
    public Position translate(float ox, float oy) {
        this.ox += ox;
        this.oy += oy;
        this.px = (int) (this.ox / DisplayManager.ppX / 2);
        this.py = (int) (this.oy / DisplayManager.ppY / 2);
        return this;
    }

    /**
     * Multiplies the OpenGL and Pixel position by the given factor.
     *
     * @param factor: The factor to multiply the Position by.
     * @return Position: this.
     */
    public Position multiply(float factor) {
        px *= factor;
        py *= factor;
        ox *= factor;
        oy *= factor;
        return this;
    }

    /**
     * Gets the distance between this and another position (in OpenGL).
     *
     * @param position: The position to get the distance to.
     * @return double: The distance to the position.
     */
    public double distance(Position position) {
        double px = position.getOpenGLX() - this.getOpenGLX();
        double py = position.getOpenGLY() - this.getOpenGLY();
        return Math.sqrt(px * px + py * py);
    }

    public int getPixelX() {
        return px;
    }

    public int getPixelY() {
        return py;
    }

    public float getOpenGLX() {
        return ox;
    }

    public float getOpenGLY() {
        return oy;
    }

    public Position deepClone() {
        return new Position(px, py, ox, oy);
    }

    @Override
    public String toString() {
        return "Position(" + px + ", " + py + ", " + ox + ", " + oy + ")";
    }

}
