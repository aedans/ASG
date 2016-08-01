package game.gamestates.inclientgamestate;

import game.gui.GUI;
import game.gui.GUIHub;
import game.renderer.RenderList;
import game.sprites.Textures;

import java.util.ArrayList;

/**
 * Created by Aedan Smith on 7/30/2016.
 */

public class GUIList extends RenderList<GUI> {

    protected GUIList() {
        super(Textures.GUITextures.size());
    }

    public void add(GUIHub guiHub){
        for (GUI gui : guiHub.getSubGUIs())
            add(gui);
    }

    public void remove(GUIHub guiHub) {
        for (GUI gui : guiHub.getSubGUIs())
            remove(gui);
    }

    @Override
    protected void onAdd(GUI gui) {

    }

    @Override
    protected void onRemove(GUI gui) {

    }

    public void checkClicked(){
        for (ArrayList<GUI> guis : renderables)
            guis.forEach(GUI::checkClicked);
    }

}
