import java.util.Scanner;

public class オセロアプリ {
    private static final int SIZE = 8;
    private static final char EMPTY = '.';
    private static final char BLACK = 'B';
    private static final char WHITE = 'W';
    private static char[][] board = new char[SIZE][SIZE];

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

            // 入力チェック
            if (row < 0 || row >= SIZE || col < 0 || col >= SIZE || board[row][col] != EMPTY) {
                System.out.println("無効な入力です。もう一度。");
                continue;
            }

            board[row][col] = currentPlayer;
            printBoard();

            // プレイヤー交代
            currentPlayer = (currentPlayer == BLACK) ? WHITE : BLACK;
        }
    }

    private static void initBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = EMPTY;
            }
        }
        // 初期配置
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
}