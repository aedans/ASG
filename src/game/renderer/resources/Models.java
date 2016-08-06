package game.renderer.resources;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Aedan Smith on 8/5/2016.
 *
 * Class for accessing the Models that the Game is using.
 */

public class Models {

    private static int size = 0;

    /**
     * The list of Model vertices that the Game is using.
     */
    private static ArrayList<float[]> modelVertices = new ArrayList<>();

    /**
     * The list of Model indices that the Game is using.
     */
    private static ArrayList<int[]> modelIndices = new ArrayList<>();

    /**
     * Adds the given Model to the list of Models.
     * @param indices: The list of indices.
     * @param vertices: The list of vertices in the Model.
     */
    public static void add(float[] vertices, int[] indices){
        modelVertices.add(vertices);
        modelIndices.add(indices);
        size++;
    }

    /**
     * Returns if the list of Models contains
     *
     * @param vertices: The list of vertices.
     * @param indices: The list of indices.
     * @return int: The position of the Model in Models. -1 if not in Models.
     */
    public static int contains(float[] vertices, int[] indices){
        for (int i = 0; i < size; i++) {
            if (Arrays.equals(modelVertices.get(i), vertices) && Arrays.equals(modelIndices.get(i), indices))
                return i;
        }
        return -1;
    }

}
