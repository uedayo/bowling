public class Game {
  private int itsCurrentFrame = 1;
  private boolean firstThrowInFrame = true;

  private Scorer itsScorer = new Scorer();

  public int score() {
    return scoreForFrame(itsCurrentFrame);
  }

  public int getCurrentFrame() {
    return itsCurrentFrame;
  }

  public void add(int pins) {
    itsScorer.addThrow(pins);
    adjustCurrentFrame(pins);
  }

  private void adjustCurrentFrame(int pins) {
    if ((firstThrowInFrame == true && pins == 10 ) ||
        (!firstThrowInFrame)) {
      advanceFrame();
    } else {
      firstThrowInFrame = false;
    }
  }
  
  private boolean adjustFrameForStrike(int pins) {
    if (pins == 10) {
      // Strike
      advanceFrame();
      return true;
    }

    return false;
  }

  private void advanceFrame() {
    itsCurrentFrame = Math.min(10, itsCurrentFrame + 1);
  }

  public int scoreForFrame(int theFrame){
    return itsScorer.scoreForFrame(theFrame);
  }
}
