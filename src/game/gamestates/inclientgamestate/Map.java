package game.gamestates.inclientgamestate;

import acklib.utils.distribution.Distributions;
import acklib.utils.distribution.Tend2D;
import acklib.utils.distribution.tends.GroupTend2D;
import game.gamestates.inclientgamestate.entities.Entity;
import game.renderer.lights.Light;
import game.renderer.lights.LightList;
import game.gamestates.inclientgamestate.entities.terrain.Terrain;
import game.renderer.data.RenderList;
import game.renderer.textures.Textures;

import java.util.ArrayList;

/**
 * Created by Aedan Smith on 7/6/2016.
 *
 * The Map that the Game is played on.
 */

public class Map extends RenderList<Entity> {

    /**
     * The LightList that affects the Entities.
     */
    private LightList lightList = new LightList();

    /**
     * The width and height of the Map.
     */
    private int width, height;

    /**
     * The array of Terrain that makes up the Map.
     */
    private Terrain[][] terrain;

    /**
     * Default Map constructor.
     *
     * @param width: The width of the Map.
     * @param height: The height of the Map.
     */
    public Map(int width, int height) {
        super(Textures.entityTextures.size());
        this.width = width;
        this.height = height;
        this.terrain = new Terrain[width][height];
    }

    /**
     * Generates the Map.
     *
     * TODO: Implement better Map generation.
     */
    public void generate() {
        int[][] terrainID = Distributions.get2dDistribution(width, height, 100, new Tend2D[]{
                new GroupTend2D(width / 2, height / 2, 80),
        });
//        DistributionRandom.randomize2dDistribution(terrainID,2);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                terrain[i][j] = Terrain.get(i * 64, j * 64, terrainID[i][j]);
                add(terrain[i][j]);
            }
        }
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

    public Terrain getTileAt(int x, int y) {
        return terrain[x][y];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getPixelHeight() {
        return height * 64;
    }

    public int getPixelWidth() {
        return width * 64;
    }


}
