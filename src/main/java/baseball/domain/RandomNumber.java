package baseball.domain;

public class RandomNumber {
    private static final int numLength = 3;
    private static final int indexLength = 9;

    private static String strRandomNumber = "";
    private static boolean[] flag = new boolean[indexLength];

    public static String getStrRandomNumber() {
        return generateRandomNumber();
    }

    private static String generateRandomNumber() {
        int index = 1;

        while (index <= numLength) {
            int randomNum = (int) (Math.random() * 9) + 1;

            if (IsDuplicateNumber(randomNum)) {
                continue;
            } else {
                strRandomNumber += randomNum;
                index++;
            }

        }
        return strRandomNumber;
    }

    private static boolean IsDuplicateNumber(int randomNum) {

        if (!flag[randomNum - 1]) {
            flag[randomNum - 1] = true;
            return false;
        }

        return true;
    }

}
