import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

/**
 * JUnit test fixture for {@code RubiksCube}'s constructor and kernel methods.
 *
 * @author Alex Lamont
 *
 */
public abstract class RubiksCubeTest {

    /**
     * Invokes the appropriate {@code RubiksCube} constructor for the
     * implementation under test and returns the result.
     *
     * @return the new Rubik's cube
     * @ensures constructorTest = a new RubiksCube
     */
    protected abstract RubiksCube constructorTest();

    //Using toString to verify a sequence of random turns
    //Randomly generated scramble:
    //F R' B D2 L2 F' U2 L2 B' R2 B' L2 R2 D L F2 D' B2 D' F'
    @Test
    public final void testTurn() {
        RubiksCube r1 = this.constructorTest();
        r1.turn(RubiksCube.Side.FRONT, 1);
        r1.turn(RubiksCube.Side.RIGHT, 3);
        r1.turn(RubiksCube.Side.BACK, 1);
        r1.turn(RubiksCube.Side.DOWN, 2);
        r1.turn(RubiksCube.Side.LEFT, 2);
        r1.turn(RubiksCube.Side.FRONT, 3);
        r1.turn(RubiksCube.Side.UP, 2);
        r1.turn(RubiksCube.Side.LEFT, 2);
        r1.turn(RubiksCube.Side.BACK, 3);
        r1.turn(RubiksCube.Side.RIGHT, 2);
        r1.turn(RubiksCube.Side.BACK, 3);
        r1.turn(RubiksCube.Side.LEFT, 2);
        r1.turn(RubiksCube.Side.RIGHT, 2);
        r1.turn(RubiksCube.Side.DOWN, 1);
        r1.turn(RubiksCube.Side.LEFT, 1);
        r1.turn(RubiksCube.Side.FRONT, 2);
        r1.turn(RubiksCube.Side.DOWN, 3);
        r1.turn(RubiksCube.Side.BACK, 2);
        r1.turn(RubiksCube.Side.DOWN, 3);
        r1.turn(RubiksCube.Side.FRONT, 3);
        String s = r1.toString();
        String sExp = "YOG-RBY-BRW-OYB-GRY-RGW-GOW-BWO-BY-GW-RB-GY-OW-WR-OY-OB-OG-RG-RY-WB";
        assertEquals(sExp, s);
    }

    @Test
    public final void testEdgeAt() {
        RubiksCube r = this.constructorTest();
        String p = r.edgeAt(0);
        String pExp = "WB";
        assertEquals(pExp, p);
    }

    @Test
    public final void testCornerAt() {
        RubiksCube r = this.constructorTest();
        String p = r.cornerAt(0);
        String pExp = "WOB";
        assertEquals(pExp, p);
    }

    @Test
    public final void testIsSolvedTrue() {
        RubiksCube r = this.constructorTest();
        boolean i = r.isSolved();
        boolean iExp = true;
        assertEquals(iExp, i);
    }

    @Test
    public final void testIsSolvedFalse() {
        RubiksCube r = this.constructorTest();
        r.turn(RubiksCube.Side.RIGHT, 1);
        boolean i = r.isSolved();
        boolean iExp = false;
        assertEquals(iExp, i);
    }

    /*
     * Scramble is random so these tests could fail, but are incredibly unlikely
     * to. If these tests succeed, scramble is likely working as expected. It
     * isn't great, but it's the best I could think of.
     */
    @Test
    public final void testScramble() {
        RubiksCube r1 = this.constructorTest();
        RubiksCube r2 = this.constructorTest();
        RubiksCube r3 = this.constructorTest();
        r1.scramble();
        r2.scramble();
        r3.scramble();
        boolean s1 = r1.isSolved();
        boolean s2 = r2.isSolved();
        boolean s3 = r3.isSolved();
        boolean sExp = false;
        assertEquals(sExp, s1);
        assertEquals(sExp, s2);
        assertEquals(sExp, s3);
        assertNotEquals(r1, r2);
        assertNotEquals(r2, r3);
        assertNotEquals(r1, r3);
    }

    @Test
    public final void testEqualsAlias() {
        RubiksCube r1 = this.constructorTest();
        RubiksCube r2 = r1;
        boolean e = r1.equals(r2);
        boolean eExp = true;
        assertEquals(eExp, e);
    }

    @Test
    public final void testEqualsNull() {
        RubiksCube r1 = this.constructorTest();
        RubiksCube r2 = null;
        boolean e = r1.equals(r2);
        boolean eExp = false;
        assertEquals(eExp, e);
    }

    @Test
    public final void testEqualsDifferentObject() {
        RubiksCube r1 = this.constructorTest();
        Integer r2 = 1;
        boolean e = r1.equals(r2);
        boolean eExp = false;
        assertEquals(eExp, e);
    }

    @Test
    public final void testEqualsValidFalse() {
        RubiksCube r1 = this.constructorTest();
        RubiksCube r2 = this.constructorTest();
        r2.turn(RubiksCube.Side.RIGHT, 1);
        boolean e = r1.equals(r2);
        boolean eExp = false;
        assertEquals(eExp, e);
    }

    @Test
    public final void testEqualsValidTrue() {
        RubiksCube r1 = this.constructorTest();
        RubiksCube r2 = this.constructorTest();
        boolean e = r1.equals(r2);
        boolean eExp = true;
        assertEquals(eExp, e);
    }

}
