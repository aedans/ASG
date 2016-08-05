package game.gamestates.inclientgamestate;

import acklib.utils.distribution.Distributions;
import acklib.utils.distribution.Tend2D;
import acklib.utils.distribution.tends.GroupTend2D;
import game.gamestates.inclientgamestate.entities.terrain.Tile;

/**
 * Created by Aedan Smith on 8/5/2016.
 */

public class TileMap {

    /**
     * The array of Tile that makes up the World.
     */
    private Tile[][] tiles;

    /**
     * The width and height of the World.
     */
    private int width, height;

    /**
     * Default TileMap constructor.
     *
     * @param width: The width of the TileMap.
     * @param height: The height of the TileMap.
     */
    public TileMap(int width, int height){
        this.width = width;
        this.height = height;
        this.tiles = new Tile[width][height];
        generate();
    }

    /**
     * Generates the Tile Map.
     *
     * TODO: Implement better World generation.
     */
    public void generate() {
        int[][] terrainID = Distributions.get2dDistribution(width, height, 100, new Tend2D[]{
                new GroupTend2D(width / 2, height / 2, 80),
        });
//        DistributionRandom.randomize2dDistribution(terrainID,2);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                tiles[i][j] = Tile.get(i * 64, j * 64, terrainID[i][j]);
            }
        }
    }

    /**
     * Gets the Tile at a given xy position.
     *
     * @param x: The x position of the Tile.
     * @param y: The y position of the Tile.
     * @return Tile: The Tile at the position.
     */
    public Tile getTileAt(int x, int y) {
        return tiles[x][y];
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
