package game.gui;

import game.gamestates.inclientgamestate.entities.lights.AlwaysLit;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Aedan Smith on 7/11/2016.
 */

@AlwaysLit
@Retention(RetentionPolicy.RUNTIME)
public @interface Invisible {
}
