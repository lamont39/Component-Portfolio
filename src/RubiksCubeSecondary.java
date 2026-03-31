public abstract class RubiksCubeSecondary implements RubiksCube {

    @Override
    public boolean isSolved() {
        boolean isSolved = true;

        String[] solvedEdges = { "WB", "WR", "WG", "WO", "GO", "BO", "GR", "BR",
                "YG", "YR", "YB", "YO" };

        String[] solvedCorners = { "WOB", "WBR", "WRG", "WGO", "YOG", "YGR",
                "YRB", "YBO" };

        for (int i = 0; i < 12; i++) {
            if (this.edgeAt(i) != solvedEdges[i]) {
                isSolved = false;
            }
        }

        for (int i = 0; i < 8; i++) {
            if (this.cornerAt(i) != solvedCorners[i]) {
                isSolved = false;
            }
        }

        return isSolved;
    }

    @Override
    public String toString() {
        String toString = "";

        for (int i = 0; i < 12; i++) {
            toString += this.edgeAt(i);
        }

        for (int i = 0; i < 8; i++) {
            toString += this.cornerAt(i);
        }

        return toString;
    }

    public boolean equals(RubiksCube cube2) {
        boolean equals = true;

        for (int i = 0; i < 12; i++) {
            if (this.edgeAt(i) != cube2.edgeAt(i)) {
                equals = false;
            }
        }

        for (int i = 0; i < 8; i++) {
            if (this.cornerAt(i) != cube2.cornerAt(i)) {
                equals = false;
            }
        }

        return equals;
    }

}
