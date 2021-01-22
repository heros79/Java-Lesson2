import java.util.Random;
import java.util.Scanner;

public class Main {

    private static char[][] gameMap;
    public static Scanner sc = new Scanner(System.in);

    private static final char EMPTY_DOT = '•';
    private static final char X_DOT = 'X';
    private static final char O_DOT = 'O';

    public static void main(String[] args) {
        startGame();
    }

    private static void startGame() {
        initGameMap(3, 3);
        paintGameMap();
        int count = 0;
        while (true) {
            humanTurn();
            count++;
            paintGameMap();
            if (chekWin(X_DOT)) {
                System.out.println("You WIN!!!");
                break;
            }

            if (count == gameMap.length * gameMap[0].length) {
                System.out.println("-))) FRIENDLY WIN -)))");
            }

            computeTurn();
            count++;
            paintGameMap();
            if (chekWin(O_DOT)) {
                System.out.println("Sorry but you looser, computer WIN -((( ");
            }

            if (count == gameMap.length * gameMap[0].length) {
                System.out.println("-))) FRIENDLY WIN -)))");
            }

        }
    }

    private static boolean chekWin(char c) {
        if (gameMap[0][0] == c && gameMap[0][1] == c && gameMap[0][2] == c) {
            return true;
        }
        if (gameMap[1][0] == c && gameMap[1][1] == c && gameMap[1][2] == c) {
            return true;
        }
        if (gameMap[2][0] == c && gameMap[2][1] == c && gameMap[2][2] == c) {
            return true;
        }

        if (gameMap[0][0] == c && gameMap[1][0] == c && gameMap[2][0] == c) {
            return true;
        }
        if (gameMap[0][1] == c && gameMap[1][1] == c && gameMap[2][1] == c) {
            return true;
        }
        if (gameMap[0][2] == c && gameMap[1][2] == c && gameMap[2][2] == c) {
            return true;
        }

        if (gameMap[0][0] == c && gameMap[1][1] == c && gameMap[2][2] == c) {
            return true;
        }
        if (gameMap[0][2] == c && gameMap[1][1] == c && gameMap[2][0] == c) {
            return true;
        }

        return false;
    }

    private static void computeTurn() {
        System.out.println("Computer not a human, computer thinking");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {
        }
        int x, y;
        boolean checkCell;
        Random random = new Random();
        do {
            x = random.nextInt(gameMap.length);
            y = random.nextInt(gameMap.length);
            checkCell = isValidCell(x, y);
        } while (!checkCell);
        gameMap[x][y] = O_DOT;
    }

    private static void humanTurn() {
        int x = -1;
        int y = -1;
        boolean checkCell;
        do {
            System.out.println("Пожалуйста введите координаты в формате X Y");
            if (sc.hasNextInt()) {
                x = sc.nextInt() - 1;
            }
            if (sc.hasNextInt()) {
                y = sc.nextInt() - 1;
            }
            checkCell = isValidCell(x, y);
            sc.nextLine();
        } while (!checkCell);
        gameMap[x][y] = X_DOT;
    }

    private static boolean isValidCell(int x, int y) {
        if (x < 0 || y < 0 || x > gameMap.length || y > gameMap[0].length) {
            return false;
        }
        return gameMap[x][y] == EMPTY_DOT;
    }

    private static void paintGameMap() {
        for (int i = 0; i < gameMap.length; i++) {
            for (int j = 0; j < gameMap[i].length; j++) {
                System.out.print(gameMap[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void initGameMap(int length, int width) {
        if (length < 3 || width < 3) {
            System.out.println("You stupid man");
            System.exit(0);
        }
        gameMap = new char[length][width];
        for (int i = 0; i < gameMap.length; i++) {
            for (int j = 0; j < gameMap[i].length; j++) {
                gameMap[i][j] = EMPTY_DOT;
            }
        }
    }
}