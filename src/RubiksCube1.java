/**
 * A 3x3 Rubik's cube represented as two arrays of strings.
 *
 * @convention The corner array contains eight strings, each three characters
 *             long. The edge array contains twelve strings, each two characters
 *             long. The characters every string is comprised of are 'W', 'O',
 *             'G', 'R', 'B', and 'Y'.
 * @correspondence The permutation of the pieces is determined by their position
 *                 in the array. For the corners, the top/left/back corner is
 *                 index 0, then the indexes count clockwise around the top. The
 *                 bottom/right/front corner is index 4, then the indexes count
 *                 clockwise around the bottom. For the edges, the top/back edge
 *                 is index 0, then the indexes count clockwise around the top.
 *                 Indexes 4, 5, 6, and 7 correspond to the left/front,
 *                 left/back, right/front, and right/back edges respectively.
 *                 The bottom/front edge is index 8, then the indexes count
 *                 clockwise around the bottom. The colors of the pieces are
 *                 white, orange, green, red, blue, and yellow, with the
 *                 characters in the strings representing each color.The
 *                 orientation of the pieces is determined by the starting
 *                 letter. That color is facing either up or down for corners,
 *                 up or down for edges in the top/bottom layers, or forward or
 *                 backward for edges in the middle layer.
 */
public class RubiksCube1 extends RubiksCubeSecondary {

    /*
     * Private members --------------------------------------------------------
     */

    /**
     * Representation of the edges of {@code this}.
     */
    private String[] edges = new String[12];

    /**
     * Representation of the corners of {@code this}.
     */
    private String[] corners = new String[8];

    /**
     * Swaps the positions of two entries in {@code array}.
     *
     * @param array
     *            the array
     * @param i
     *            the index of one of the entries
     * @param j
     *            the index of one of the entries
     * @updates array
     * @requires 0 <= i < array.length() and 0 <= j < array.length() and i != j
     *
     * @ensures the array is as before but with entries i and j swapped
     */
    private static void swap(String[] array, int i, int j) {
        String tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    /**
     * Rotates a string by putting the last character at the beginning.
     *
     * @param piece
     *            a string representing a piece to rotate
     * @updates piece
     * @requires piece.length() >= 1
     * @return the rotated piece
     */
    private static String rotatePiece(String piece) {
        return piece.charAt(piece.length() - 1)
                + piece.substring(0, piece.length() - 1);
    }

    /**
     * Creater of initial representation.
     */
    private void createNewRep() {
        this.edges = new String[] { "WB", "WR", "WG", "WO", "GO", "BO", "GR",
                "BR", "YG", "YR", "YB", "YO" };
        this.corners = new String[] { "WOB", "WBR", "WRG", "WGO", "YOG", "YGR",
                "YRB", "YBO" };
    }

    /**
     * No-argument constructor.
     */
    public RubiksCube1() {
        this.createNewRep();
    }

    @Override
    public final String cornerAt(int i) {
        return this.corners[i];
    }

    @Override
    public final String edgeAt(int i) {
        return this.edges[i];
    }

    @Override
    public final void turn(Side side, int times) {
        switch (side) {
            case UP:
                for (int i = 0; i < times; i++) {
                    swap(this.corners, 0, 1);
                    swap(this.corners, 0, 2);
                    swap(this.corners, 0, 3);

                    swap(this.edges, 0, 1);
                    swap(this.edges, 0, 2);
                    swap(this.edges, 0, 3);
                }
                break;
            case DOWN:
                for (int i = 0; i < times; i++) {
                    swap(this.corners, 4, 5);
                    swap(this.corners, 4, 6);
                    swap(this.corners, 4, 7);

                    swap(this.edges, 8, 9);
                    swap(this.edges, 8, 10);
                    swap(this.edges, 8, 11);
                }
                break;
            case FRONT:
                for (int i = 0; i < times; i++) {
                    swap(this.corners, 3, 2);
                    swap(this.corners, 3, 5);
                    swap(this.corners, 3, 4);

                    swap(this.edges, 2, 6);
                    swap(this.edges, 2, 8);
                    swap(this.edges, 2, 4);

                    this.corners[3] = rotatePiece(this.corners[3]);
                    this.corners[3] = rotatePiece(this.corners[3]);
                    this.corners[2] = rotatePiece(this.corners[2]);
                    this.corners[5] = rotatePiece(this.corners[5]);
                    this.corners[5] = rotatePiece(this.corners[5]);
                    this.corners[4] = rotatePiece(this.corners[4]);

                    this.edges[2] = rotatePiece(this.edges[2]);
                    this.edges[6] = rotatePiece(this.edges[6]);
                    this.edges[8] = rotatePiece(this.edges[8]);
                    this.edges[4] = rotatePiece(this.edges[4]);
                }
                break;
            case BACK:
                for (int i = 0; i < times; i++) {
                    swap(this.corners, 1, 0);
                    swap(this.corners, 1, 7);
                    swap(this.corners, 1, 6);

                    swap(this.edges, 0, 5);
                    swap(this.edges, 0, 10);
                    swap(this.edges, 0, 7);

                    this.corners[1] = rotatePiece(this.corners[1]);
                    this.corners[1] = rotatePiece(this.corners[1]);
                    this.corners[0] = rotatePiece(this.corners[0]);
                    this.corners[7] = rotatePiece(this.corners[7]);
                    this.corners[7] = rotatePiece(this.corners[7]);
                    this.corners[6] = rotatePiece(this.corners[6]);

                    this.edges[0] = rotatePiece(this.edges[0]);
                    this.edges[5] = rotatePiece(this.edges[5]);
                    this.edges[10] = rotatePiece(this.edges[10]);
                    this.edges[7] = rotatePiece(this.edges[7]);
                }
                break;
            case LEFT:
                for (int i = 0; i < times; i++) {
                    swap(this.corners, 3, 4);
                    swap(this.corners, 3, 7);
                    swap(this.corners, 3, 0);

                    swap(this.edges, 4, 11);
                    swap(this.edges, 4, 5);
                    swap(this.edges, 4, 3);

                    this.corners[3] = rotatePiece(this.corners[3]);
                    this.corners[4] = rotatePiece(this.corners[4]);
                    this.corners[4] = rotatePiece(this.corners[4]);
                    this.corners[7] = rotatePiece(this.corners[7]);
                    this.corners[0] = rotatePiece(this.corners[0]);
                    this.corners[0] = rotatePiece(this.corners[0]);
                }
                break;
            case RIGHT:
                for (int i = 0; i < times; i++) {
                    swap(this.corners, 2, 1);
                    swap(this.corners, 2, 6);
                    swap(this.corners, 2, 5);

                    swap(this.edges, 6, 1);
                    swap(this.edges, 6, 7); //lol
                    swap(this.edges, 6, 9); //lol

                    this.corners[2] = rotatePiece(this.corners[2]);
                    this.corners[2] = rotatePiece(this.corners[2]);
                    this.corners[1] = rotatePiece(this.corners[1]);
                    this.corners[6] = rotatePiece(this.corners[6]);
                    this.corners[6] = rotatePiece(this.corners[6]);
                    this.corners[5] = rotatePiece(this.corners[5]);
                }
                break;
            default:
                break;
        }

    }

    /*
     * Standard methods -------------------------------------------------------
     */

    @Override
    public final RubiksCube newInstance() {
        try {
            return this.getClass().getConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new AssertionError(
                    "Cannot construct object of type " + this.getClass());
        }
    }

    @Override
    public final void clear() {
        this.createNewRep();
    }

    @Override
    public final void transferFrom(Object source) {
        assert source != null : "Violation of: source is not null";
        assert source != this : "Violation of: source is not this";
        assert source instanceof RubiksCube1 : "Violation of: source is of dynamic type RubiksCube1";
        /*
         * This cast cannot fail since the assert above would have stopped
         * execution in that case.
         */
        RubiksCube1 localSource = (RubiksCube1) source;
        this.edges = localSource.edges;
        this.corners = localSource.corners;
        localSource.createNewRep();
    }

}
