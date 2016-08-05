package game.renderer.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Aedan Smith on 7/29/2016.
 * <p>
 * Runtime Annotation that tells the Renderer not to apply lighting to the annotated Renderable.
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface AlwaysLit {
}
