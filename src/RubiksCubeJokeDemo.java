import java.util.Random;

public final class RubiksCubeJokeDemo {
    private RubiksCubeJokeDemo() {
    }

    public static void justPeelTheStickersOff(RubiksCube r) {
        r.clear();
    }

    public static void bogoSolve(RubiksCube r) {
        Random x = new Random();

        while (!r.isSolved()) {
            RubiksCube.Side randomSide = RubiksCube.Side.values()[x.nextInt(5)];
            int randomAmount = x.nextInt(3) + 1;
            r.turn(randomSide, randomAmount);
        }
    }

    public static void main() {
        RubiksCube r = new RubiksCube1();

        r.scramble();
        justPeelTheStickersOff(r);
        System.out.println(r.isSolved());

        r.scramble();
        bogoSolve(r);
        System.out.println(r.isSolved());

    }
}
