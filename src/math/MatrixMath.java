package math;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

import java.awt.geom.Point2D;

/**
 * Created by Aedan Smith on 7/5/2016.
 */

public final class MatrixMath {

    public static Matrix4f createTransformationMatrix(Point2D.Float translation, float rx, float ry, float scale){
        Matrix4f matrix4f = new Matrix4f();
        matrix4f.setIdentity();
        Matrix4f.translate(new Vector2f(translation.x, translation.y), matrix4f, matrix4f);
        Matrix4f.rotate((float) Math.toRadians(rx), new Vector3f(1, 0, 0), matrix4f, matrix4f);
        Matrix4f.rotate((float) Math.toRadians(ry), new Vector3f(0, 1, 0), matrix4f, matrix4f);
        Matrix4f.scale(new Vector3f(scale,scale,scale), matrix4f, matrix4f);
        return matrix4f;
    }

}
