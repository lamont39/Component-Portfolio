import components.standard.Standard;

/**
 * Rubik's cube kernel component with primary methods.
 *
 *
 */
public interface RubiksCubeKernel extends Standard {

    /**
     * Rotates the cube once clockwise around the vertical axis when viewed from
     * above.
     *
     * @updates this
     * @ensures this = #this roated
     */
    void rotateY();

    /**
     * Rotates the cube once clockwise around the left/right axis when viewed
     * from the right.
     *
     * @updates this
     * @ensures this = #this rotated
     */
    void rotateX();

    /**
     * Turns the right side of the cube once clockwise.
     *
     * @updates this
     * @ensures this = #this with the right side turned
     */
    void turnR();

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

    /**
     * Reports whether the cube is solved.
     *
     * @return true iff every piece is in its starting position and orientation
     * @ensures isSolved = (this = a solved cube)
     */
    boolean isSolved();

}
