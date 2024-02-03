import java.util.*;

public class TicTacToe {
    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();

    public static void main(String[] args) {
        char[][] gameBoard = {
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}
        };

        printGameBoard(gameBoard);

        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter your placement (1-9):");
            int playerPos = scan.nextInt();

            while (playerPositions.contains(playerPos) || cpuPositions.contains(playerPos)) {
                System.out.println("Position taken! Enter a valid position:");
                playerPos = scan.nextInt();
            }

            placePiece(gameBoard, playerPos, "player");

            String result = checkWinner();
            if (result.length() > 0) {
                printGameBoard(gameBoard);
                System.out.println(result);
                break;
            }

            Random rand = new Random();
            int cpuPos;
            do {
                cpuPos = rand.nextInt(9) + 1;
            } while (playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos));

            placePiece(gameBoard, cpuPos, "cpu");

            result = checkWinner();
            if (result.length() > 0) {
                printGameBoard(gameBoard);
                System.out.println(result);
                break;
            }

            printGameBoard(gameBoard);
        }
    }

    public static void printGameBoard(char[][] gameBoard) {
        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void placePiece(char[][] gameBoard, int pos, String user) {
        char symbol = ' ';
        if (user.equals("player")) {
            symbol = 'X';
            playerPositions.add(pos);
        } else if (user.equals("cpu")) {
            symbol = 'O';
            cpuPositions.add(pos);
        }

        switch (pos) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
            default:
                break;
        }
    }

    public static String checkWinner() {
        List<List<Integer>> winningConditions = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9),
                Arrays.asList(1, 4, 7),
                Arrays.asList(2, 5, 8),
                Arrays.asList(3, 6, 9),
                Arrays.asList(1, 5, 9),
                Arrays.asList(3, 5, 7)
        );

        for (List<Integer> condition : winningConditions) {
            if (playerPositions.containsAll(condition)) {
                return "Congratulations! You win!";
            } else if (cpuPositions.containsAll(condition)) {
                return "CPU wins! Better luck next time.";
            }
        }

        if (playerPositions.size() + cpuPositions.size() == 9) {
            return "It's a draw!";
        }

        return "";
    }
}
