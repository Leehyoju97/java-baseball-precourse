package baseball.view;

import baseball.domain.Input;

public class InputView {
    private final static String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private final static String OPTION_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요";

    public static String getInputMessage() {
        System.out.print(INPUT_MESSAGE);
        return Input.inputStringNumber();
    }

    public static int getOptionMessage() {
        System.out.println(OPTION_MESSAGE);
        return Input.inputIntNumber();
    }
}
