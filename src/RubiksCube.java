/**
 * {@code RubiksCubeKernel} enhanced with secondary methods.
 */
public interface RubiksCube extends RubiksCubeKernel {

    /**
     * Reports whether the cube is solved.
     *
     * @return true iff every piece is in its starting position and orientation
     * @ensures isSolved = (this = a solved cube)
     */
    boolean isSolved();

    /**
     * Scrambles the cube.
     *
     * @ensures the cube is in a random state
     */
    void scramble();
}
