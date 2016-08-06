package game.gamestates.inclientgamestate;

import game.gamestates.inclientgamestate.entities.Entity;
import game.gamestates.inclientgamestate.entities.terrain.Tile;
import game.renderer.data.RenderList;
import game.renderer.lights.Light;
import game.renderer.lights.LightList;
import game.renderer.resources.Textures;

import java.util.ArrayList;

/**
 * Created by Aedan Smith on 7/6/2016.
 * <p>
 * The World that the Game is played on.
 */

public class World extends RenderList<Entity> {

    /**
     * The LightList that affects the Entities.
     */
    private LightList lightList = new LightList();

    /**
     * The TileMap for the World.
     */
    private TileMap tileMap;

    /**
     * Default World constructor.
     *
     * @param width:  The width of the World.
     * @param height: The height of the World.
     */
    public World(int width, int height) {
        super(Textures.entityTextures.size());
        tileMap = new TileMap(width, height);
        for (Tile[] ts : tileMap.getTiles())
            add(ts);
    }

    /**
     * See game.renderer.data.RenderList documentation
     */
    @Override
    protected void onAdd(Entity entity) {
        if (entity.isLight)
            lightList.addLight((Light) entity);
    }

    /**
     * See game.renderer.data.RenderList documentation
     */
    @Override
    protected void onRemove(Entity entity) {
        if (entity.isLight)
            lightList.removeLight((Light) entity);
        entity.onDestruction();
    }

    /**
     * See game.renderer.data.RenderList documentation
     */
    @Override
    protected void onUpdate() {
        for (ArrayList<Entity> es : renderables)
            es.forEach(Entity::update);
    }

    public LightList getLightList() {
        return lightList;
    }

    public int getTileWidth() {
        return tileMap.getWidth();
    }

    public int getTileHeight() {
        return tileMap.getHeight();
    }

    public int getPixelWidth() {
        return tileMap.getWidth() * 64;
    }

    public int getPixelHeight() {
        return tileMap.getHeight() * 64;
    }

    public TileMap getTileMap() {
        return tileMap;
    }

}
