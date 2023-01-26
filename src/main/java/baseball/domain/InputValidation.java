package baseball.domain;

import java.util.Arrays;

public class InputValidation {
    private String userNumber;

    public InputValidation(String userNumber) {
        this.userNumber = userNumber;
    }

    public boolean isCheckValidNumber() {

        if (!isNumber()) {
            return false;
        }
        if (!isValidLength()) {
            return false;
        }
        if (!isDuplicated()) {
            return false;
        }

        return true;
    }

    private boolean isNumber() {
        String regExp = "^[1-9]+$";
        return userNumber.matches(regExp);
    }

    private boolean isValidLength() {
        final int NUMBER_LENGTH = 3;

        return userNumber.length() == NUMBER_LENGTH;
    }

    private boolean isDuplicated() {
        String[] checkStrings = userNumber.split("");
        Arrays.sort(checkStrings);

        for (int i = 0; i < checkStrings.length - 1; i++) {
            if (checkStrings[i].equals(checkStrings[i + 1])) {
                return false;
            }
        }

        return true;
    }
}
