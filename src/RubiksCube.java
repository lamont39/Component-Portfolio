import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Display a proof of concept of a Rubik's cube in Java.
 *
 * @author Alex Lamont
 *
 */
public final class RubiksCube {
    private RubiksCube() {
    }

    private static void swap(String[] array, int i, int j) {
        String tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;

    }

    private static void turnR(String[] corners, String[] edges) {
        swap(corners, 2, 1);
        swap(corners, 2, 6);
        swap(corners, 2, 5);

        swap(edges, 6, 1);
        swap(edges, 6, 7); //unintentional
        swap(edges, 6, 9); //unintentional
    }

    private static void rotateZ(String[] corners, String[] edges) {
        swap(corners, 0, 1);
        swap(corners, 0, 2);
        swap(corners, 0, 3);
        swap(corners, 4, 7);
        swap(corners, 4, 6);
        swap(corners, 4, 5);

        swap(edges, 3, 1);
        swap(edges, 3, 9);
        swap(edges, 3, 11);
        swap(edges, 2, 6);
        swap(edges, 2, 8);
        swap(edges, 2, 4);
        swap(edges, 0, 7);
        swap(edges, 0, 10);
        swap(edges, 0, 5);

    }

    private static void rotateX(String[] corners, String[] edges) {
        swap(corners, 5, 2);
        swap(corners, 5, 1);
        swap(corners, 5, 6);
        swap(corners, 4, 3);
        swap(corners, 4, 0);
        swap(corners, 4, 7);

        swap(edges, 2, 0);
        swap(edges, 2, 10);
        swap(edges, 2, 8);
        swap(edges, 6, 1);
        swap(edges, 6, 7); //unintentional
        swap(edges, 6, 9); //unintentional
        swap(edges, 4, 3);
        swap(edges, 4, 5);
        swap(edges, 4, 11);
    }

    private static void rotateXp(String[] corners, String[] edges) {
        rotateX(corners, edges);
        rotateX(corners, edges);
        rotateX(corners, edges);
    }

    private static void rotateZp(String[] corners, String[] edges) {
        rotateZ(corners, edges);
        rotateZ(corners, edges);
        rotateZ(corners, edges);
    }

    private static void turnR2(String[] corners, String[] edges) {
        turnR(corners, edges);
        turnR(corners, edges);
    }

    private static void turnRp(String[] corners, String[] edges) {
        turnR(corners, edges);
        turnR(corners, edges);
        turnR(corners, edges);
    }

    private static void turnU(String[] corners, String[] edges) {
        rotateX(corners, edges);
        rotateZ(corners, edges);
        turnR(corners, edges);
        rotateZp(corners, edges);
        rotateXp(corners, edges);
    }

    private static void turnUp(String[] corners, String[] edges) {
        turnU(corners, edges);
        turnU(corners, edges);
        turnU(corners, edges);
    }

    private static void turnF(String[] corners, String[] edges) {
        rotateZp(corners, edges);
        turnR(corners, edges);
        rotateZ(corners, edges);
    }

    private static void turnFp(String[] corners, String[] edges) {
        turnF(corners, edges);
        turnF(corners, edges);
        turnF(corners, edges);
    }

    private static void tPermutation(String[] corners, String[] edges) {
        //Algorithm that swaps two corners and two edges
        //Cubing notation: R U R' U' R' F R2 U' R' U' R U R' F'

        turnR(corners, edges);
        turnU(corners, edges);
        turnRp(corners, edges);
        turnUp(corners, edges);
        turnRp(corners, edges);
        turnF(corners, edges);
        turnR2(corners, edges);
        turnUp(corners, edges);
        turnRp(corners, edges);
        turnUp(corners, edges);
        turnR(corners, edges);
        turnU(corners, edges);
        turnRp(corners, edges);
        turnFp(corners, edges);
    }

    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();

        String[] corners = { "WBO", "WBR", "WGR", "WGO", "YGO", "YGR", "YBR",
                "YBO" };

        String[] edges = { "WB", "WR", "WG", "WO", "GO", "BO", "GR", "BR", "YG",
                "YR", "YB", "YO" };

        out.println("Starting corner permutation");

        for (int i = 0; i < corners.length; i++) {
            out.println(corners[i]);
        }

        out.println();
        out.println("Starting edge permutation");

        for (int i = 0; i < edges.length; i++) {
            out.println(edges[i]);
        }

        tPermutation(corners, edges);

        out.println();
        out.println("Ending corner permutation");

        for (int i = 0; i < corners.length; i++) {
            out.println(corners[i]);
        }

        out.println();
        out.println("Ending edge permutation");

        for (int i = 0; i < edges.length; i++) {
            out.println(edges[i]);
        }

        out.close();

    }
}
