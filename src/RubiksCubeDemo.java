public final class RubiksCubeDemo {
    private RubiksCubeDemo() {
    }

    //I tried to make a solver, but I vastly underestimated the time it would take, RIP
    private static void solveCross(RubiksCube r) {
        while ((r.edgeAt(0).charAt(0) != 'Y') && (r.edgeAt(1).charAt(0) != 'Y')
                && (r.edgeAt(2).charAt(0) != 'Y')
                && (r.edgeAt(3).charAt(0) != 'Y')) {
            for (int i = 0; i < 4; i++) {
                if (r.edgeAt(0).charAt(0) == 'Y') {
                    r.turn(RubiksCube.Side.UP, 1);
                }
            }
            if (r.edgeAt(0).charAt(1) == 'Y') {
                r.turn(RubiksCube.Side.BACK, 1);
                r.turn(RubiksCube.Side.UP, 3);
                r.turn(RubiksCube.Side.LEFT, 1);
                r.turn(RubiksCube.Side.UP, 1);
            } else if (r.edgeAt(3).charAt(1) == 'Y') {
                r.turn(RubiksCube.Side.LEFT, 3);
                r.turn(RubiksCube.Side.BACK, 3);
            } else if (r.edgeAt(2).charAt(1) == 'Y') {
                r.turn(RubiksCube.Side.FRONT, 3);
                r.turn(RubiksCube.Side.UP, 3);
                r.turn(RubiksCube.Side.LEFT, 3);
                r.turn(RubiksCube.Side.UP, 1);
            } else if (r.edgeAt(1).charAt(1) == 'Y') {
                r.turn(RubiksCube.Side.RIGHT, 1);
                r.turn(RubiksCube.Side.BACK, 1);
            } else if (r.edgeAt(4).charAt(0) == 'Y') {
                r.turn(RubiksCube.Side.UP, 3);
                r.turn(RubiksCube.Side.LEFT, 3);
                r.turn(RubiksCube.Side.UP, 1);
            } else if (r.edgeAt(4).charAt(1) == 'Y') {
                r.turn(RubiksCube.Side.UP, 2);
                r.turn(RubiksCube.Side.FRONT, 1);
                r.turn(RubiksCube.Side.UP, 2);
            }
            //TODO Check other places for the cross edges
        }
        //TODO Solve the cross
    }

    //TODO after cross, solve F2L, OLL, PLL

    public static void main() {
        RubiksCube r = new RubiksCube1();

        r.scramble();

        solveCross(r);

    }
}
