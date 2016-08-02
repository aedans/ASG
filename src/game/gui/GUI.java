package game.gui;

import game.renderer.DisplayManager;
import game.sprites.Sprite;
import org.lwjgl.input.Mouse;

import java.awt.geom.Point2D;

/**
 * Created by Aedan Smith on 7/8/2016.
 */

public abstract class GUI extends Sprite {

    private int width, height;
    private long lastClicked = 0;
    private int timeFastClick = 0;

    protected GUI(int textureID, int x, int y, int width, int height) {
        super(textureID, DisplayManager.ppX * x * 2 - DisplayManager.xRes / 2, DisplayManager.ppY * y * 2 - DisplayManager.yRes / 2, width, height);
        this.width = width;
        this.height = height;
    }

    // TODO: Fix
    @SuppressWarnings("WeakerAccess")
    public void checkClicked() {
        if (Mouse.isButtonDown(0)) {
            if (Mouse.getX() > this.getPixelX() - width / 2)
                if (Mouse.getX() < this.getPixelX() + width / 2)
                    if (Mouse.getY() > this.getPixelX() - height / 2)
                        if (Mouse.getY() < this.getPixelX() + height / 2) {
                            this.onPressed();
                            if (timeFastClick > 2 || System.currentTimeMillis() - lastClicked > 300) {
                                this.onClick();
                                timeFastClick++;
                                lastClicked = System.currentTimeMillis();
                            }
                            return;
                        }
        }
        timeFastClick = 0;
    }

    @Override
    public void onRender() {

    }

    @Override
    public Point2D.Float getPixelPosition() {
        return new Point2D.Float(
                super.getPixelX() + DisplayManager.xRes / 2,
                super.getPixelY() + DisplayManager.yRes / 2
        );
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public abstract void onPressed();

    protected abstract void onClick();

}
