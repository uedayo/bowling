import junit.framework.*;

public class TestGame extends TestCase {

  public TestGame(String name) {
    super(name);
  }

  public void testOneThrow() {
    Game g = new Game();
    g.add(5);
    assertEquals(5, g.score());
  }

  public void testTwoThrowsNoMark(){
    Game g = new Game();
    g.add(5);
    g.add(4);
    assertEquals(9, g.score());
  }
}
