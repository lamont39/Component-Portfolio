import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * JUnit test fixture for {@code RubiksCube}'s constructor and kernel methods.
 *
 * @author Alex Lamont
 *
 */
public abstract class RubiksCubeTest {

    /**
     * Invokes the appropriate {@code Set} constructor for the implementation
     * under test and returns the result.
     *
     * @return the new Rubik's cube
     * @ensures constructorTest = //TODO
     */
    protected abstract RubiksCube constructorTest();

    /**
     * Invokes the appropriate {@code Set} constructor for the reference
     * implementation and returns the result.
     *
     * @return the new Rubik's cube
     * @ensures constructorRef = //TODO
     */
    protected abstract RubiksCube constructorRef(String s);

    /*
     * Test case for constructor()
     */
    @Test
    public final void testIsSolved() {
        RubiksCube r = this.constructorTest();
        boolean i = r.isSolved();
        boolean iExp = true;
        assertEquals(iExp, i);
    }

}
