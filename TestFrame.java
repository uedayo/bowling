import junit.framework.*;

public class TestFrame extends TestCase {

  public TestFrame(String name){
    super(name);
  }

  public void testScoreNoThrows(){
    Frame f = new Frame();
    assertEquals(0, f.getScore());
  }
}
