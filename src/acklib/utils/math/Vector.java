package acklib.utils.math;

/**
 * Created by thomkad18 on 5/16/2016.
 *
 * Interface to represent a vector in any dimension
 */
public interface Vector {
    /**
     * Returns the magnitude of the vector (size)
     *
     * @return length of the vector
     */
    double getLength();

    /**
     * Returns the length of a vector given components
     *
     * @param components x, y, z...
     * @return the length of the vector
     */
    static double getLength(double... components){
        //square and add all components
        double componentsSquared = 0;
        for (double component : components) {
            componentsSquared += (component * component);
        }
        return Math.sqrt(componentsSquared);
    }
}
