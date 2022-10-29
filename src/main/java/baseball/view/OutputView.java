package baseball.view;

import baseball.domain.Rule;

public class OutputView {
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String WINNING_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String NOTHING = "낫싱";

    public static void printWinningMessage() {
        System.out.println(WINNING_MESSAGE);
    }

    public static void printStrikeAndBall(int strikeCount, int ballCount) {

        if (Rule.isZeroStrikeAndBallCount(ballCount, strikeCount)) {
            System.out.println(ballCount + BALL + " " + strikeCount + STRIKE);
            return;
        }

        if (Rule.isZeroStrikeCount(strikeCount)) {
            System.out.println(strikeCount + STRIKE);
            return;
        }

        if (Rule.isZeroBallCount(ballCount)) {
            System.out.println(ballCount + BALL);
            return;
        }

        if (Rule.isNonZeroStrikeAndBallCount(strikeCount, ballCount)) {
            System.out.println(NOTHING);
        }

    }

}
