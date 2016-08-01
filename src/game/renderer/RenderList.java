package game.renderer;

import game.sprites.Sprite;

import java.util.ArrayList;

/**
 * Created by Aedan Smith on 7/17/2016.
 */

public abstract class RenderList<T extends Renderable> {

    public int depth;
    protected ArrayList<T> toAdd = new ArrayList<>();
    protected ArrayList<T> toRemove = new ArrayList<>();
    protected ArrayList[] renderables;

    protected RenderList(int depth){
        this.depth = depth;
        this.renderables = new ArrayList[depth];
        for (int i = 0; i < depth; i++)
            renderables[i] = new ArrayList();
    }

    public void add(ArrayList<T> ts){
        ts.forEach(this::add);
    }

    public void add(T[] ts) {
        for (T t : ts)
            add(t);
    }

    public void add(T t) {
        toAdd.add(t);
    }

    public void remove(T t) {
        toRemove.add(t);
    }

    public void update(){
        for (T t : toAdd) {
            renderables[t.getTexturedModel().getGameTextureID() - 1].add(t);
            onAdd(t);
        }
        toAdd = new ArrayList<>();

        for (T t : toRemove) {
            get(t.getTexturedModel().getGameTextureID() - 1).remove(t);
            onRemove(t);
        }
        toRemove = new ArrayList<>();

        for (ArrayList<Sprite> e : renderables){
            e.forEach(Sprite::update);
        }
    }

    public ArrayList<Sprite> get(int key){
        return renderables[key];
    }

    protected abstract void onAdd(T t);

    protected abstract void onRemove(T t);

}
