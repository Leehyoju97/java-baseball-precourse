package baseball.domain;

public class Rule {

    private static final int NUM_LEN = 3;

    private String userNumber;
    private String randomNumber;
    private static int strikeCount;
    private static int ballCount;

    public Rule(String userNumber, String randomNumber) {
        this.userNumber = userNumber;
        this.randomNumber = randomNumber;
    }

    public static boolean isWinning() {
        return strikeCount == NUM_LEN;
    }

    public static boolean isZeroStrikeAndBallCount(int strikeCount, int ballCount) {
        return (isZeroStrikeCount(strikeCount) && isZeroBallCount(ballCount)) ? true : false;
    }

    public static boolean isNonZeroStrikeAndBallCount(int strikeCount, int ballCount) {
        return (!isZeroStrikeCount(strikeCount) && !isZeroBallCount(ballCount)) ? true : false;
    }

    public static boolean isZeroStrikeCount(int strikeCount) {
        return (strikeCount != 0) ? true : false;
    }

    public static boolean isZeroBallCount(int ballCount) {
        return (ballCount != 0) ? true : false;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void startGame() {
        initialize();
        setStrikeOrBall();
    }

    private void initialize() {
        strikeCount = 0;
        ballCount = 0;
    }

    private boolean isStrike(int index) {
        return userNumber.charAt(index) == randomNumber.charAt(index);
    }

    private boolean isBall(int index) {
        return randomNumber.contains((Character.toString(userNumber.charAt(index))));
    }

    private void setStrikeOrBall() {
        for (int i = 0; i < NUM_LEN; i++) {
            if (isStrike(i)) {
                strikeCount++;
                ballCount--;
            }
            if (isBall(i)) {
                ballCount++;
            }
        }
    }

}
