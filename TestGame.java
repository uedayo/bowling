import junit.framework.*;

public class TestGame extends TestCase {

  public TestGame(String name) {
    super(name);
  }

  private Game g;

  public void setUp() {
    g = new Game();
  }

  public void testTwoThrowsNoMark() {
    g.add(5);
    g.add(4);
    assertEquals(9, g.score());
    assertEquals(2, g.getCurrentFrame());
  }

  public void testFourThrowsNoMark() {
    g.add(5);
    g.add(4);
    g.add(7);
    g.add(2);
    assertEquals(18, g.score());
    assertEquals(9, g.scoreForFrame(1));
    assertEquals(18, g.scoreForFrame(2));
    assertEquals(3, g.getCurrentFrame());
  }

  public void testSimpleSpare() {
    g.add(3);
    g.add(7);
    g.add(3);
    assertEquals(13, g.scoreForFrame(1));
    assertEquals(2, g.getCurrentFrame());
  }

  public void testSimpleFrameAfterSpare() {
    g.add(3);
    g.add(7);
    g.add(3);
    g.add(2);
    assertEquals(13, g.scoreForFrame(1));
    assertEquals(18, g.scoreForFrame(2));
    assertEquals(18, g.score());
    assertEquals(3, g.getCurrentFrame());
  }

  public void testSimpleStrike() {
    g.add(10);
    g.add(3);
    g.add(6);
    assertEquals(19, g.scoreForFrame(1));
    assertEquals(28, g.score());
    assertEquals(3, g.getCurrentFrame());
  }

  public void testParfectGame() {
    for(int i = 0; i < 12; i++) {
      g.add(10);
    }
    assertEquals(300, g.score());
    assertEquals(11, g.getCurrentFrame());
  }
}
