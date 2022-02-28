public class HW_l3 {

    public static void main(String[] args) {
        changeArr();
        System.out.println();

        initialArrHundred();
        System.out.println();

        doubleIfLessSix();
        System.out.println();

        diagonalsSquare();
        System.out.println();

        int arr[] = initialArr(10, 38);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println();

        minAndMaxValue();
        System.out.println();

        System.out.println(checkLeftAndRightSum(new int[] {2, 1, 1, 2, 2}));
        System.out.println();

        arrayShift(new int[] {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1}, -2);
    }

    public static void changeArr() {
        int[] arr = new int[10];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 2);
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void initialArrHundred() {
        int arr[] = new int[100];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void doubleIfLessSix() {
        int arr[] = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i < arr.length; i++) {  //вывод начального массива для наглядности
            if (arr[i] < 10) {
                System.out.print(arr[i] + "  ");
            } else {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < 6) {
                arr[i] *= 2;
            }
            if (arr[i] < 10) {
                System.out.print(arr[i] + "  ");
            } else {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }

    public static void diagonalsSquare() {
        int arr[][] = new int[10][10];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(i == j) {
                    arr[i][j] = 1;
                }
                if (j == arr[i].length - 1 - i) {
                    arr[i][j] = 1;
                }
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static int[] initialArr(int len, int initialValue) {
        int arr[] = new int[len];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = initialValue;
        }
        return arr;
    }

    public static void minAndMaxValue() {
        int arr[] = new int[10];
        int minValue;
        int maxValue;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        minValue = arr[0];
        maxValue = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if(arr[i] < minValue) {
                minValue = arr[i];
            }
            if(arr[i] > maxValue) {
                maxValue = arr[i];
            }
        }
        System.out.println("Minimum value - " + minValue);
        System.out.println("Maximum value - " + maxValue);
    }

    public static boolean checkLeftAndRightSum(int arr[]) {
        int leftSum = arr[0];
        int rightSum = 0;
        for (int i = 1; i < arr.length; i++) {
            rightSum += arr[i];
        }

        for (int i = 1; i < arr.length - 1; i++) {
            if(leftSum == rightSum) {
                return true;
            } else {
                leftSum += arr[i];
                rightSum -= arr[i];
            }
        }
        return false;
    }

    public static void arrayShift(int arr[], int n) {
        int buf;

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        if(n > 0) {
            for (int i = 0; i < n; i++) {
                buf = arr[0];
                arr[0] = arr[arr.length - 1];
                for (int j = arr.length - 1; j > 1; j--) {
                    arr[j] = arr[j - 1];
                }
                arr[1] = buf;
            }
        } else {
            for (int i = 0; i < n * (-1); i++) {
                buf = arr[arr.length - 1];
                arr[arr.length - 1] = arr[0];
                for (int j = 0; j < arr.length - 2; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[arr.length - 2] = buf;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
