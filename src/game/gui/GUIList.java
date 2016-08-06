package game.gui;

import game.renderer.data.RenderList;
import game.renderer.resources.Textures;

import java.util.ArrayList;

/**
 * Created by Aedan Smith on 7/30/2016.
 * <p>
 * A list of GUIs to be used by the Renderer
 */

public class GUIList extends RenderList<GUI> {

    /**
     * Default GUIList constructor.
     */
    public GUIList() {
        super(Textures.GUITextures.size());
    }

    /**
     * Adds a GUIHub to the GUIList.
     *
     * @param guiHub: The GUIHub to add.
     */
    public void add(GUIHub guiHub) {
        for (GUI gui : guiHub.getSubGUIs())
            add(gui);
    }

    /**
     * Removes a GUIHub to from GUIList.
     *
     * @param guiHub: The GUIHub to remove.
     */
    public void remove(GUIHub guiHub) {
        for (GUI gui : guiHub.getSubGUIs())
            remove(gui);
    }

    /**
     * See game.entities.RenderList documentation
     * <p>
     * (Currently unused)
     */
    @Override
    protected void onAdd(GUI gui) {

    }

    /**
     * See game.entities.RenderList documentation
     * <p>
     * (Currently unused)
     */
    @Override
    protected void onRemove(GUI gui) {

    }

    /**
     * See game.entities.RenderList documentation
     */
    @Override
    protected void onUpdate() {
        for (ArrayList<GUI> guis : renderables) {
            for (GUI gui : guis) {
                gui.checkClicked();
                gui.update();
            }
        }
    }

}
