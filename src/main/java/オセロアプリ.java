import java.util.Scanner;

public class オセロアプリ {
    private static final int SIZE = 8;
    private static final char EMPTY = '.';
    private static final char BLACK = 'B';
    private static final char WHITE = 'W';
    private static char[][] board = new char[SIZE][SIZE];

    private static final int[][] DIRECTIONS = {
        {-1, -1}, {-1, 0}, {-1, 1},
        {0, -1},          {0, 1},
        {1, -1},  {1, 0}, {1, 1}
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initBoard();
        printBoard();

        char currentPlayer = BLACK;

        while (true) {
            System.out.println("現在のプレイヤー: " + (currentPlayer == BLACK ? "黒(B)" : "白(W)"));
            System.out.print("行と列を半角スペースで入力（例: 3 4）：");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (!isValidMove(row, col, currentPlayer)) {
                System.out.println("無効な手です。もう一度。");
                continue;
            }

            placeDisk(row, col, currentPlayer);
            printBoard();

            currentPlayer = (currentPlayer == BLACK) ? WHITE : BLACK;
        }
    }

    private static void initBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = EMPTY;
            }
        }
        board[3][3] = WHITE;
        board[3][4] = BLACK;
        board[4][3] = BLACK;
        board[4][4] = WHITE;
    }

    private static void printBoard() {
        System.out.print("  ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static boolean isValidMove(int row, int col, char player) {
        if (row < 0 || row >= SIZE || col < 0 || col >= SIZE || board[row][col] != EMPTY) {
            return false;
        }
        char opponent = (player == BLACK) ? WHITE : BLACK;

        for (int[] dir : DIRECTIONS) {
            int r = row + dir[0], c = col + dir[1];
            boolean foundOpponent = false;

            while (r >= 0 && r < SIZE && c >= 0 && c < SIZE) {
                if (board[r][c] == opponent) {
                    foundOpponent = true;
                } else if (board[r][c] == player && foundOpponent) {
                    return true;
                } else {
                    break;
                }
                r += dir[0];
                c += dir[1];
            }
        }
        return false;
    }

    private static void placeDisk(int row, int col, char player) {
        board[row][col] = player;
        char opponent = (player == BLACK) ? WHITE : BLACK;

        for (int[] dir : DIRECTIONS) {
            int r = row + dir[0], c = col + dir[1];
            boolean foundOpponent = false;
            int steps = 0;

            while (r >= 0 && r < SIZE && c >= 0 && c < SIZE) {
                if (board[r][c] == opponent) {
                    foundOpponent = true;
                    steps++;
                } else if (board[r][c] == player && foundOpponent) {
                    // ひっくり返す
                    int rr = row + dir[0], cc = col + dir[1];
                    for (int i = 0; i < steps; i++) {
                        board[rr][cc] = player;
                        rr += dir[0];
                        cc += dir[1];
                    }
                    break;
                } else {
                    break;
                }
                r += dir[0];
                c += dir[1];
            }
        }
    }
}