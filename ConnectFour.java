import java.util.Scanner;

public class ConnectFour {
    private static final int ROWS = 6;
    private static final int COLUMNS = 7;
    private static final char EMPTY_SLOT = ' ';
    private static final char PLAYER1_TOKEN = 'X';
    private static final char PLAYER2_TOKEN = 'O';

    private char[][] board;

    public ConnectFour() {
        board = new char[ROWS][COLUMNS];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                board[row][col] = EMPTY_SLOT;
            }
        }
    }

    private void printBoard() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                System.out.print("| " + board[row][col] + " ");
            }
            System.out.println("|");
            for (int i = 0; i < COLUMNS; i++) {
                System.out.print("----");
            }
            System.out.println("-");
        }
        System.out.println("1   2   3   4   5   6   7");
    }

    private boolean dropToken(int column, char playerToken) {
        for (int row = ROWS - 1; row >= 0; row--) {
            if (board[row][column] == EMPTY_SLOT) {
                board[row][column] = playerToken;
                return true;
            }
        }
        return false;
    }

    private boolean checkWin(int row, int col, char playerToken) {
        return checkDirection(row, col, playerToken, 0, 1) ||  // Horizontal
               checkDirection(row, col, playerToken, 1, 0) ||  // Vertical
               checkDirection(row, col, playerToken, 1, 1) ||  // Diagonal \
               checkDirection(row, col, playerToken, 1, -1);   // Diagonal /
    }

    private boolean checkDirection(int row, int col, char playerToken, int rowChange, int colChange) {
        for (int i = 0; i < 4; i++) {
            int newRow = row + i * rowChange;
            int newCol = col + i * colChange;

            if (newRow < 0 || newRow >= ROWS || newCol < 0 || newCol >= COLUMNS || board[newRow][newCol] != playerToken) {
                return false;
            }
        }
        return true;
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        int currentPlayer = 1;
        boolean gameWon = false;

        while (!gameWon) {
            printBoard();
            System.out.println("Player " + currentPlayer + ", enter your move (1-7): ");
            int column = scanner.nextInt() - 1;

            if (column < 0 || column >= COLUMNS || board[0][column] != EMPTY_SLOT) {
                System.out.println("Invalid move. Try again.");
                continue;
            }

            if (dropToken(column, (currentPlayer == 1) ? PLAYER1_TOKEN : PLAYER2_TOKEN)) {
                gameWon = checkWin(ROWS - 1, column, (currentPlayer == 1) ? PLAYER1_TOKEN : PLAYER2_TOKEN);
                currentPlayer = (currentPlayer == 1) ? 2 : 1;
            } else {
                System.out.println("Column is full. Try again.");
            }
        }

        printBoard();
        System.out.println("Player " + (currentPlayer == 1 ? 2 : 1) + " wins!");
        scanner.close();
    }

    public static void main(String[] args) {
        ConnectFour connectFour = new ConnectFour();
        connectFour.playGame();
    }
}
