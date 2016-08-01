package game.gamestates.inclientgamestate.entities.lights;

import game.gamestates.inclientgamestate.entities.Entity;

import java.util.ArrayList;

/**
 * Created by Aedan Smith on 7/29/2016.
 */

public class LightList {

    private ArrayList<Light> lights = new ArrayList<>();

    public void addLight(Light l){
        lights.add(l);
    }

    public Light getLight(int index){
        return lights.get(index);
    }

    public void removeLight(Light l){
        lights.remove(l);
    }

    public Light getMostImportantLight(Entity e) {
        Light l = lights.get(0);
        int importantLightPointer = 0;
        double importantLightBrightness = (1/(l.getOpenGLPosition().distance(e.getOpenGLPosition())+.2f))*l.getStrength()/10-.1f, brightness;
        for (int i = 0; i < lights.size(); i++) {
            l = lights.get(i);
            brightness = (1/(l.getOpenGLPosition().distance(e.getOpenGLPosition())+.2f))*l.getStrength()/10-.1f;
            if (brightness > importantLightBrightness) {
                importantLightPointer = i;
                importantLightBrightness = brightness;
            }
        }
        return lights.get(importantLightPointer);
    }

}
