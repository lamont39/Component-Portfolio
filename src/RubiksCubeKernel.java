import components.standard.Standard;

/**
 * Rubik's cube kernel component with primary methods.
 */
public interface RubiksCubeKernel extends Standard {

    /**
     * An enum, listing the six sides of the cube.
     */
    enum Side {
        UP, DOWN, FRONT, BACK, LEFT, RIGHT
    }

    /**
     * Turns a side of the cube a number of times.
     *
     * @param side
     *            the side being turned
     * @param times
     *            the number of times to turn the side
     * @requires i >= 0
     * @updates this
     * @ensures this = #this with the side turned
     */
    void turn(Side side, int times);

    /**
     * Reports the edge at index {@code i} in the edges array.
     *
     * @param i
     *            the position being checked
     * @requires 0 <= i <= 11
     * @return the edge
     * @ensures edgeAt = edges[i]
     */
    String edgeAt(int i);

    /**
     * Reports the corner at index {@code i} in the corners array.
     *
     * @param i
     *            the position being checked
     * @requires 0 <= i <= 7
     * @return the corner
     * @ensures cornerAt = corners[i]
     */
    String cornerAt(int i);

}
