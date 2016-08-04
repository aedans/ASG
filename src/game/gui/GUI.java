package game.gui;

import game.renderer.math.Position;
import game.sprites.Sprite;
import game.renderer.math.MatrixMath;
import org.lwjgl.input.Mouse;
import org.lwjgl.util.vector.Matrix4f;

/**
 * Created by Aedan Smith on 7/8/2016.
 */

public abstract class GUI extends Sprite {

    private int width, height;
    private long lastClicked = 0;
    private int timeFastClick = 0;

    protected GUI(Position position, int textureID, int width, int height) {
        super(
                position,
                textureID,
                width,
                height
        );
        this.width = width;
        this.height = height;
    }

    // TODO: Fix
    @SuppressWarnings("WeakerAccess")
    public void checkClicked() {
        if (Mouse.isButtonDown(0)) {
            if (Mouse.getX() > this.getPosition().getPixelX() - width / 2)
                if (Mouse.getX() < this.getPosition().getPixelX() + width / 2)
                    if (Mouse.getY() > this.getPosition().getPixelY() - height / 2)
                        if (Mouse.getY() < this.getPosition().getPixelY() + height / 2) {
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
    protected void onDestruction() {

    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public Matrix4f getTransformationMatrix() {
        return MatrixMath.createTransformationMatrix(
                getPosition().deepClone().translate(-1f, -1f)
        );
    }

    public abstract void onPressed();

    protected abstract void onClick();

}
