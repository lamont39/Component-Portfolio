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
     * Rotates the cube once counterclockwise around the vertical axis when
     * viewed from above.
     *
     * @updates this
     * @ensures this = #this roated
     */
    void rotateYp();

    /**
     * Rotates the cube twice around the vertical axis when viewed from above.
     *
     * @updates this
     * @ensures this = #this roated
     */
    void rotateY2();

    /**
     * Rotates the cube once counterclockwise around the left/right axis when
     * viewed from the right.
     *
     * @updates this
     * @ensures this = #this roated
     */
    void rotateXp();

    /**
     * Rotates the cube twice around the left/right axis when viewed from the
     * right.
     *
     * @updates this
     * @ensures this = #this roated
     */
    void rotateX2();

    /**
     * Rotates the cube once clockwise around the front/back axis when viewed
     * from the front.
     *
     * @updates this
     * @ensures this = #this roated
     */
    void rotateZ();

    /**
     * Rotates the cube once counterclockwise around the front/back axis when
     * viewed from the front.
     *
     * @updates this
     * @ensures this = #this roated
     */
    void rotateZp();

    /**
     * Rotates the cube twice around the front/back axis when viewed from the
     * front.
     *
     * @updates this
     * @ensures this = #this roated
     */
    void rotateZ2();

    /**
     * Turns the right side of the cube once counterclockwise.
     *
     * @updates this
     * @ensures this = #this with the right side turned
     */
    void turnRp();

    /**
     * Turns the right side of the cube twice.
     *
     * @updates this
     * @ensures this = #this with the right side turned
     */
    void turnR2();

    /**
     * Turns the left side of the cube once clockwise.
     *
     * @updates this
     * @ensures this = #this with the left side turned
     */
    void turnL();

    /**
     * Turns the left side of the cube once counterclockwise.
     *
     * @updates this
     * @ensures this = #this with the left side turned
     */
    void turnLp();

    /**
     * Turns the left side of the cube twice.
     *
     * @updates this
     * @ensures this = #this with the left side turned
     */
    void turnL2();

    /**
     * Turns the front side of the cube once clockwise.
     *
     * @updates this
     * @ensures this = #this with the front side turned
     */
    void turnF();

    /**
     * Turns the front side of the cube once counterclockwise.
     *
     * @updates this
     * @ensures this = #this with the front side turned
     */
    void turnFp();

    /**
     * Turns the front side of the cube twice.
     *
     * @updates this
     * @ensures this = #this with the front side turned
     */
    void turnF2();

    /**
     * Turns the top side of the cube once clockwise.
     *
     * @updates this
     * @ensures this = #this with the top side turned
     */
    void turnU();

    /**
     * Turns the top side of the cube once counterclockwise.
     *
     * @updates this
     * @ensures this = #this with the top side turned
     */
    void turnUp();

    /**
     * Turns the top side of the cube twice.
     *
     * @updates this
     * @ensures this = #this with the top side turned
     */
    void turnU2();

    /**
     * Turns the bottom side of the cube once clockwise.
     *
     * @updates this
     * @ensures this = #this with the bottom side turned
     */
    void turnD();

    /**
     * Turns the bottom side of the cube once counterclockwise.
     *
     * @updates this
     * @ensures this = #this with the bottom side turned
     */
    void turnDp();

    /**
     * Turns the bottom side of the cube twice.
     *
     * @updates this
     * @ensures this = #this with the bottom side turned
     */
    void turnD2();

    /**
     * Turns the back side of the cube once clockwise.
     *
     * @updates this
     * @ensures this = #this with the back side turned
     */
    void turnB();

    /**
     * Turns the back side of the cube once counterclockwise.
     *
     * @updates this
     * @ensures this = #this with the back side turned
     */
    void turnBp();

    /**
     * Turns the back side of the cube twice.
     *
     * @updates this
     * @ensures this = #this with the back side turned
     */
    void turnB2();

}