package baseball;

import baseball.domain.InputValidation;
import baseball.domain.RandomNumber;
import baseball.domain.Rule;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGameRun {

    private Rule rule;

    public void playGame() {
        String randomNumber = RandomNumber.getStrRandomNumber();
        System.out.println(randomNumber);

        do {
            rule = new Rule(setUserNumber(), randomNumber);
            rule.startGame();
            OutputView.printStrikeAndBall(rule.getStrikeCount(), rule.getBallCount());
        } while (!playOrExit());

    }

    private String setUserNumber() {
        String userNumber = InputView.getInputMessage();
        InputValidation inputValidation = new InputValidation(userNumber);

        if (!inputValidation.isCheckValidNumber()) {
            throw new IllegalStateException("잘못된 값을 입력했습니다.");
        }

        return userNumber;
    }

    private boolean newGame() {
        final int NEW_GAME = 1;
        final int EXIT = 2;
        int selectNumber = InputView.getOptionMessage();

        if ((selectNumber != NEW_GAME) && (selectNumber != EXIT)) {
            throw new IllegalStateException("잘못된 값을 입력했습니다.");
        }

        return selectNumber == NEW_GAME;
    }

    private boolean endGame() {
        if (rule.isWinning()) {
            OutputView.printWinningMessage();
            return true;
        }

        return false;
    }

    private boolean playOrExit() {
        if (endGame()) {
            return !newGame();
        }

        return false;
    }

}
