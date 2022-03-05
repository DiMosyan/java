import java.util.Scanner;

public class HW_l4 {

    private static char[][] map;
    private final static int SIZE = 7;
    private final static int SCORE_TO_WIN = 4;
    private final static char EMPTY_CELL = '•';
    private final static char HUMAN_CELL = 'X';
    private final static char COMPUTER_CELL = 'O';
    private static Scanner sc = new Scanner(System.in);



    public static void main(String[] args) {
        play();
    }

    private static void play() {
        init();
        paint();
        while(true) {
            humanTurn();
            if(checkWin()) {
                paint();
                System.out.println("You win!");
                break;
            }
            if(checkDraw()) {
                paint();
                System.out.println("Draw");
                break;
            }

            compTurn();
            paint();
            if(checkWin()) {
                System.out.println("Computer win!");
                break;
            }
            if(checkDraw()) {
                System.out.println("Draw");
                break;
            }
        }
    }

    private static void humanTurn() {
        int x, y;
        do {
            while(true) {
                System.out.println("Enter coordinate in format 'x y'");
                if(sc.hasNextInt()) {
                    x = sc.nextInt();
                } else {
                    System.out.println("Wrong format coordinate x");
                    sc.nextLine();
                    continue;
                }
                if(sc.hasNextInt()) {
                    y = sc.nextInt();
                    break;
                } else {
                    System.out.println("Wrong format coordinate y");
                    sc.nextLine();
                }
            }
        } while(!cellValidation(x, y, HUMAN_CELL));
        map[x - 1][y - 1] = HUMAN_CELL;
    }

    private static void compTurn() {
        int x, y;

        do {
            x = (int) (Math.random() * SIZE);
            y = (int) (Math.random() * SIZE);
        } while(!cellValidation(x + 1, y + 1, COMPUTER_CELL));
        map[x][y] = COMPUTER_CELL;
    }

    private static boolean cellValidation(int x, int y, char dot) {
        if(x < 1 || x > SIZE || y < 1 || y > SIZE) {
            System.out.println("Going beyond the map");
            return false;
        }
        if(map[x - 1][y - 1] == EMPTY_CELL) {
            return true;
        } else {
            if(dot == HUMAN_CELL) {
                System.out.println("Cell is busy");
            }
            return false;
        }
    }

    private static void init() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = EMPTY_CELL;
            }
        }
    }

    private static void paint() {
        System.out.print("  ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
        }
        System.out.println();
        for (int i = 0; i < map.length; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean checkWin() {
        int scoreCount = 0;
        for (int i = 0; i < map.length; i++) {  //проверяем строчки
            for (int j = 1; j < map[i].length; j++) {
                if(map[i][j] == map[i][j - 1] && map[i][j] != EMPTY_CELL) {
                    scoreCount++;
                    if(scoreCount == SCORE_TO_WIN - 1) {
                        return true;
                    }
                } else {
                    scoreCount = 0;
                    if(SIZE - j - 1 < SCORE_TO_WIN - 1) {
                        break;
                    }
                }
            }
        }


        scoreCount = 0;
        for (int i = 0; i < SIZE; i++) {    //проверяем столбцы
            for (int j = 1; j < SIZE; j++) {
                if(map[j][i] == map[j - 1][i] && map[j][i] != EMPTY_CELL) {
                    scoreCount++;
                    if(scoreCount == SCORE_TO_WIN - 1) {
                        return true;
                    }
                } else {
                    scoreCount = 0;
                    if(SIZE - j - 1 < SCORE_TO_WIN - 1) {
                        break;
                    }
                }
            }
        }



        scoreCount = 0;
        for (int i = 1; i < SIZE; i++) { //проверяем диагональ
            if(map[i][i] == map[i - 1][i - 1] && map[i][i] != EMPTY_CELL) {
                scoreCount++;
                if(scoreCount == SCORE_TO_WIN - 1) {
                    return true;
                }
            } else {
                scoreCount = 0;
                if(SIZE - i - 1 < SCORE_TO_WIN - 1) {
                    break;
                }
            }
        }


        scoreCount = 0;
        for (int i = 0; i < SIZE - 1; i++) { // проверяем другую диагональ
            if(map[i][SIZE - i - 1] == map[i + 1][SIZE - i - 2] && map[i][SIZE - i - 1] != EMPTY_CELL) {
                scoreCount++;
                if(scoreCount == SCORE_TO_WIN - 1) {
                    return true;
                }
            } else {
                scoreCount = 0;
                if(SIZE - i - 2 < SCORE_TO_WIN - 1) {
                    break;
                }
            }
        }

        scoreCount = 0;
        if(SIZE - SCORE_TO_WIN != 0) {  //если победу можно достичь не только по основной диагонали
            for (int i = 0; i < SIZE - SCORE_TO_WIN; i++) {
                for (int j = i + 2; j < SIZE; j++) { // проверяем ниже диагонали x = y
                    if(map[j][j - i - 1] == map[j - 1][j - i - 2] && map[j][j - i - 1] != EMPTY_CELL) {
                        scoreCount++;
                        if(scoreCount == SCORE_TO_WIN - 1) {
                            return true;
                        }
                    } else {
                        scoreCount = 0;
                        if(SIZE - j - i - 1 < SCORE_TO_WIN - 1) {
                            break;
                        }
                    }
                }

                scoreCount = 0;
                for (int j = i + 2; j < SIZE; j++) { // проверяем выше диагонали x = y
                    if(map[j - i - 1][j] == map[j - i - 2][j - 1] && map[j - i - 1][j] != EMPTY_CELL) {
                        scoreCount++;
                        if(scoreCount == SCORE_TO_WIN - 1) {
                            return true;
                        }
                    } else {
                        scoreCount = 0;
                        if(SIZE - j - i - 1 < SCORE_TO_WIN - 1) {
                            break;
                        }
                    }
                }

                scoreCount = 0;
                for (int j = 0; j < SIZE - i - 1; j++) { // проверяем выше диагонали x = length - 1 - y
                    if(map[j][SIZE - j - i - 2] == map[j + 1][SIZE - j - i - 3] && map[j][SIZE - j - i - 2] != EMPTY_CELL) {
                        scoreCount++;
                        if(scoreCount == SCORE_TO_WIN - 1) {
                            return true;
                        }
                    } else {
                        scoreCount = 0;
                        if(SIZE - j - i - 3 < SCORE_TO_WIN - 1) {
                            break;
                        }
                    }
                }

                scoreCount = 0;
                for (int j = i + 1; j < SIZE; j++) { // проверяем ниже диагонали x = length - 1 - y
                    if(map[j][SIZE - j + i] == map[j + 1][SIZE - j - 1 + i] && map[j][SIZE - j + i] != EMPTY_CELL) {
                        scoreCount++;
                        if(scoreCount == SCORE_TO_WIN - 1) {
                            return true;
                        }
                    } else {
                        scoreCount = 0;
                        if(SIZE - j - i - 2 < SCORE_TO_WIN - 1) {
                            break;
                        }
                    }
                }
            }
        }
        return false;
    }

    private static boolean checkDraw(){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if(map[i][j] == EMPTY_CELL) {
                    return false;
                }
            }
        }
        return true;
    }
}
