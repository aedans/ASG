package game.renderer;

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

    /**
     * Translates the position.
     *
     * @param px: The amount to translate horizontally on the Pixel coordinate plane.
     * @param py: The amount to translate vetically on the Pixel coordinate plane.
     */
    public void translate(int px, int py){
        this.px += px;
        this.py += py;
        this.ox += DisplayManager.ppX * px;
        this.oy += DisplayManager.ppY * py;
    }

    /**
     * Translates the position.
     *
     * @param ox: The amount to translate horizontally on the OpenGL coordinate plane.
     * @param oy: The amount to translate vetically on the OpenGL coordinate plane.
     */
    public void translate(float ox, float oy) {
        this.px += (int) (ox / DisplayManager.ppX);
        this.py += (int) (oy / DisplayManager.ppY);
        this.ox += ox;
        this.oy += oy;
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

    public double distance(Position position) {
        double px = position.getOpenGLX() - this.getOpenGLX();
        double py = position.getOpenGLY() - this.getOpenGLY();
        return Math.sqrt(px * px + py * py);
    }

    public Position deepClone(){
        return new Position(px, py, ox, oy);
    }

    @Override
    public String toString() {
        return "Position(" + px + ", " + py + ", " + ox + ", " + oy + ")";
    }

}
