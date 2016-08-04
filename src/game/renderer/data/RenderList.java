package game.renderer.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Aedan Smith on 7/17/2016.
 * <p>
 * A List of Renderable objects to be used by the Renderer.
 */

public abstract class RenderList<T extends Renderable> {

    /**
     * The number of possible textures.
     */
    public int numTextures;

    /**
     * The list of Renderables to add on the next update(). Prevents Concurrent
     * Modification Exceptions.
     */
    @SuppressWarnings("WeakerAccess")
    protected ArrayList<T> toAdd = new ArrayList<>();

    /**
     * The list of Renderables to remove on the next update(). Prevents Concurrent
     * Modification Exceptions.
     */
    @SuppressWarnings("WeakerAccess")
    protected ArrayList<T> toRemove = new ArrayList<>();

    /**
     * An Array of Renderables, one ArrayList for each Texture.
     */
    protected ArrayList[] renderables;

    /**
     * Default RenderList constructor
     *
     * @param numTextures: The number of textures the RenderList should support.
     */
    public RenderList(int numTextures) {
        this.numTextures = numTextures;
        this.renderables = new ArrayList[numTextures];
        for (int i = 0; i < numTextures; i++)
            renderables[i] = new ArrayList();
    }

    /**
     * Puts a List of Renderables in a queue to be added next update();
     *
     * @param renderables: The List of Renderables to add.
     */
    public void add(List<T> renderables) {
        toAdd.addAll(renderables);
    }

    /**
     * Puts any number of Renderables in a queue to be added next update();
     *
     * @param renderables: The Renderables to add.
     */
    @SafeVarargs
    public final void add(T... renderables) {
        Collections.addAll(toAdd, renderables);
    }

    /**
     * Puts a List of Renderables in a queue to be removed next update();
     *
     * @param renderables: The List of Renderables to remove.
     */
    public void remove(List<T> renderables) {
        toRemove.addAll(renderables);
    }

    /**
     * Puts any number of Renderables in a queue to be removed next update();
     *
     * @param renderables: The Renderables to remove.
     */
    @SafeVarargs
    public final void remove(T... renderables) {
        Collections.addAll(toRemove, renderables);
    }

    /**
     * A function called once each Game loop.
     */
    public void update() {
        // Adds all Renderables in the toAdd queue.
        for (T t : toAdd) {
            renderables[t.getTexturedModel().getGameTextureID() - 1].add(t);
            onAdd(t);
        }
        toAdd = new ArrayList<>();

        // Removes all Renderables in the toRemove queue.
        for (T t : toRemove) {
            get(t.getTexturedModel().getGameTextureID() - 1).remove(t);
            onRemove(t);
        }
        toRemove = new ArrayList<>();

        onUpdate();
    }

    /**
     * Returns all Renderables with the given Texture ID.
     *
     * @param textureID: The Texture ID of the requested Renderables.
     * @return ArrayList<T>: The ArrayList of Renderables.
     */
    public ArrayList<T> get(int textureID) {
        return renderables[textureID];
    }

    /**
     * Function called upon adding a Renderable to the RenderList.
     *
     * @param t: The added Object
     */
    protected abstract void onAdd(T t);

    /**
     * Function called upon removing a Renderable from the RenderList.
     *
     * @param t: The removed Object
     */
    protected abstract void onRemove(T t);

    /**
     * A function called once each Game loop.
     */
    protected abstract void onUpdate();

}
