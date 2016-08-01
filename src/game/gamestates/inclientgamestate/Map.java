package game.gamestates.inclientgamestate;

import acklib.utils.distribution.Distributions;
import acklib.utils.distribution.Tend2D;
import acklib.utils.distribution.tends.GroupTend2D;
import game.gamestates.inclientgamestate.entities.Entity;
import game.gamestates.inclientgamestate.entities.terrain.Terrain;
import game.sprites.Sprite;

import java.util.ArrayList;

/**
 * Created by Aedan Smith on 7/6/2016.
 */

public class Map {

    private int width, height;
    private Terrain[][] terrain;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        this.terrain = new Terrain[width][height];
    }

    public void generate() {
        int[][] terrain = Distributions.get2dDistribution(width, height, 100, new Tend2D[]{
                new GroupTend2D(width / 2, height / 2, 80),
        });
//        DistributionRandom.randomize2dDistribution(terrain,2);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                this.terrain[i][j] = Terrain.get(i * 64, j * 64, terrain[i][j]);
            }
        }
    }

    public ArrayList<Sprite> getSprites() {
        ArrayList<Sprite> entities = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                entities.add((Sprite) terrain[i][j]);
            }
        }
        return entities;
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
