package game.renderer.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Aedan Smith on 7/30/2016.
 * <p>
 * Runtime Annotation that tells the Renderer to always render the annotated Renderable, regardless of the Renderable's
 * position on or off screen.
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface ConstRender {
}
