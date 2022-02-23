public class HW_l2 {

    public static void main(String[] args) {
        System.out.println(isSumBetweenTenAndTwenty(10, 50));
        numberEstimation(0);
        System.out.println(isNumberNegative(51));
        int numbersString = 4;
        printString("print " + numbersString, numbersString);
        System.out.println(isLeapYear(1995));
        printFir(); //не стал отправлять в месседжерах, решил здесь сдать.
                    //Если было удобнее по телефону - скажи, пожалуйста, во время занятия или напиши в телеграмм.
                    //Спасибо
    }

    public static boolean isSumBetweenTenAndTwenty(int a, int b) {
        if(a + b > 10 && a + b <= 20) {
            return true;
        } else {
            return false;
        }
    }

    public static void numberEstimation(int a) {
        if (a >= 0) {
            System.out.println("positive number");
        } else {
            System.out.println("negative number");
        }
    }

    public static boolean isNumberNegative(int a) {
        if(a < 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void printString(String s, int a) {
        for (int i = 0; i < a; i++) {
            System.out.println(s);
        }
    }

    public static boolean isLeapYear(int year) {
        if (year % 4 != 0) {
            return false;
        } else if (year % 100 != 0) {
            return true;
        } else if (year % 400 != 0) {
            return false;
        } else return true;
    }

    public static void printFir() {
        int rowCount = 6;
        String space;

        for (int i = 0; i < rowCount; i++) {
            space = "";
            for (int j = 0; j < 6 + i; j++) {
                if(j < 6 - i - 1) {
                    space += " ";
                } else {
                    space += "*";
                }
            }
            System.out.println(space);
        }
    }
}
