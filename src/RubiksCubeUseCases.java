public class RubiksCubeUseCases {
    private RubiksCubeUseCases() {
    }

    public static void main() {
        RubiksCube r = new RubiksCube1();

        r.scramble();

        while (!r.isSolved()) {
            r.turn(RIGHT, 1);
        }
    }
}
