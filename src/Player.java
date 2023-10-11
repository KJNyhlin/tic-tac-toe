import java.util.Random;

public class Player {
    public String name;
    public char symbol;
    public boolean isHuman;
    public boolean starting;
    int score = 0;
    public static Random rand = new Random();

    public Player(char symbol) {
        this.symbol = symbol;
    }

    public static boolean makeMove(char[][] board, Player currentPlayer, String move) {
        int i;
        int j;
        i = Board.getRightRowIndex(move);
        j = Board.getRightColumnIndex(move);
        if (board[i][j] != ' ') {
            return false;
        }
        board[i][j] = currentPlayer.symbol;
        Board.printBoard(board);
        return true;
    }

    public static void makeComputerMove(char[][] board, Player currentPlayer) {
        int i;
        int j;
        do {
            int move = rand.nextInt(1, 10);
            i = Board.getRightRowIndex(String.valueOf(move));
            j = Board.getRightColumnIndex(String.valueOf(move));
        } while (board[i][j] != ' ');
        board[i][j] = currentPlayer.symbol;
        Board.printBoard(board);
        System.out.println("Computer has made its move.");
    }

    public static Player switchCurrentPlayer(Player currentPlayer, Player player1, Player player2) {
        Player newCurrentPlayer;
        if (currentPlayer == player1) {
            newCurrentPlayer = player2;
        } else {
            newCurrentPlayer = player1;
        }
        return newCurrentPlayer;
    }

    public static boolean switchStartingPlayer(Player currentPlayer) {
        if (currentPlayer.starting) {
            return false;
        }
        return true;
    }

    public static void printScore(Player player1, Player player2) {
        int nameLength1 = player1.name.length();
        int nameLength2 = player2.name.length();
        int lengthDifference = Math.max(nameLength1, nameLength2) - Math.min(nameLength1, nameLength2);
        StringBuilder space = new StringBuilder();
        for (int i = 0; i < lengthDifference; i++) {
            space.append(" ");
        }
        if (nameLength1 < nameLength2) {
            System.out.println(player1.name + " " + space + player1.score);
            System.out.println(player2.name + " " + player2.score);
        } else {
            System.out.println(player1.name + " " + player1.score);
            System.out.println(player2.name + " " + space + player2.score);
        }
    }
}
