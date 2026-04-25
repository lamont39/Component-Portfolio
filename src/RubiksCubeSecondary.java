import java.util.Random;

/**
 * Layered implementations of secondary methods for {@code RubiksCube}.
 */
public abstract class RubiksCubeSecondary implements RubiksCube {

    /*
     * Common methods (from Object) -------------------------------------------
     */

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o == null) {
            return false;
        }

        if (!(o instanceof RubiksCube)) {
            return false;
        }

        RubiksCube cube2 = (RubiksCube) o;

        for (int i = 0; i < 12; i++) {
            if (this.edgeAt(i) != cube2.edgeAt(i)) {
                return false;
            }
        }

        for (int i = 0; i < 8; i++) {
            if (this.cornerAt(i) != cube2.cornerAt(i)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hashCode = 0;

        for (int i = 0; i < 12; i++) {
            hashCode += this.edgeAt(i).hashCode();
        }

        for (int i = 0; i < 8; i++) {
            hashCode += this.cornerAt(i).hashCode();
        }

        return hashCode;
    }

    @Override
    public String toString() {
        String toString = "";

        for (int i = 0; i < 8; i++) {
            toString += this.cornerAt(i) + "-";
        }

        for (int i = 0; i < 12; i++) {
            toString += this.edgeAt(i) + "-";
        }

        return toString.substring(0, toString.length() - 1);
    }

    /*
     * Other non-kernel methods -----------------------------------------------
     */

    @Override
    public boolean isSolved() {
        String[] solvedEdges = { "WB", "WR", "WG", "WO", "GO", "BO", "GR", "BR",
                "YG", "YR", "YB", "YO" };

        String[] solvedCorners = { "WOB", "WBR", "WRG", "WGO", "YOG", "YGR",
                "YRB", "YBO" };

        for (int i = 0; i < 12; i++) {
            if (this.edgeAt(i) != solvedEdges[i]) {
                return false;
            }
        }

        for (int i = 0; i < 8; i++) {
            if (this.cornerAt(i) != solvedCorners[i]) {
                return false;
            }
        }

        return true;
    }

    @Override
    public void scramble() {
        Random x = new Random();

        for (int i = 0; i < 20; i++) {
            RubiksCube.Side side = RubiksCube.Side.values()[x.nextInt(5)];
            this.turn(side, x.nextInt(4));
        }
    }

}
