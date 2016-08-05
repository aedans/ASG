package game.renderer.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Aedan Smith on 7/11/2016.
 * <p>
 * Runtime Annotation that tells the Renderer not to render the annotated Renderable.
 */

@ConstRender
@Retention(RetentionPolicy.RUNTIME)
public @interface Invisible {
}
