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

    public static void makeRandomComputerMove(char[][] board, Player currentPlayer) {
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

    public static void makeSmartComputerMove(char[][] board, Player currentPlayer) {
        int i;
        int j;
        int xCount = 0;
        int oCount = 0;
        for (i = 1; i < Board.boardRows; i += 2) { // goes from row to row
            for (j = 3; j < Board.boardColumns; j += 6) { // checks all the columns within each row
                if (board[i][j] == 'X') {
                    xCount++; // counts X's in a horisontal row
                }
                if (board[i][j] == 'O') {
                    oCount++; // counts O's in a horisontal row
                }
            }
            if (xCount == 2 || oCount == 2) {
                for (j = 3; j < Board.boardColumns; j += 6) { // goes through the same row again to find a blank space
                    if (board[i][j] == ' ') {
                        executeComputerMove(i, j, board, currentPlayer);
                        return;
                    }
                }
            }
        }
        if (oCount == 0) { // if it's the computer's first move
            if (board[3][9] == ' ') { // if center is free, take it
                Player.executeComputerMove(3, 9, board, currentPlayer);
                return;
            } else { // take a corner
                int randomCorner = rand.nextInt(1, 5);
                switch (randomCorner) {
                    case 1 -> Player.executeComputerMove(1, 3, board, currentPlayer);
                    case 2 -> Player.executeComputerMove(1, 15, board, currentPlayer);
                    case 3 -> Player.executeComputerMove(5, 3, board, currentPlayer);
                    case 4 -> Player.executeComputerMove(5, 15, board, currentPlayer);
                }
                return;
            }
        }
        xCount = 0;
        oCount = 0;
        for (j = 3; j < Board.boardColumns; j += 6) { // goes from column to column
            for (i = 1; i < Board.boardRows; i += 2) { // checks all the rows within each column
                if (board[i][j] == 'X') {
                    xCount++; // counts X's in a vertical row (column)
                }
                if (board[i][j] == 'O') {
                    oCount++; // counts O's in a vertical row (column)
                }
            }
            if (xCount == 2 || oCount == 2) {
                for (i = 1; i < Board.boardRows; i += 2) { // goes through the same column again to find a blank space
                    if (board[i][j] == ' ') {
                        executeComputerMove(i, j, board, currentPlayer);
                        return;
                    }
                }
            }
        }
        // check diagonal from top left corner, if it has 2 O's in a row
        if ((board[1][3] == 'O' && board[3][9] == 'O') || (board[1][3] == 'O' && board[5][15] == 'O') ||
                (board[3][9] == 'O' && board[5][15] == 'O')) {
            if (board[1][3] == ' ') {
                executeComputerMove(1, 3, board, currentPlayer);
                return;
            }
            else if (board[3][9] == ' ') {
                executeComputerMove(3, 9, board, currentPlayer);
                return;
            }
            else {
                executeComputerMove(5, 15, board, currentPlayer);
                return;
            }
        }
        // check diagonal from bottom left corner, if it has 2 O's in a row
        if ((board[5][3] == 'O' && board[3][9] == 'O') || (board[3][9] == 'O' && board[1][15] == 'O') ||
                (board[5][3] == 'O' && board[1][15] == 'O')) {
            if (board[5][3] == ' ') {
                executeComputerMove(5, 3, board, currentPlayer);
                return;
            }
            else if (board[3][9] == ' ') {
                executeComputerMove(3, 9, board, currentPlayer);
                return;
            }
            else {
                executeComputerMove(1, 15, board, currentPlayer);
                return;
            }
        }
        // check diagonal from top left corner, if it has 2 X's in a row
        if ((board[1][3] == 'X' && board[3][9] == 'X') || (board[1][3] == 'X' && board[5][15] == 'X') ||
                (board[3][9] == 'X' && board[5][15] == 'X')) {
            if (board[1][3] == ' ') {
                executeComputerMove(1, 3, board, currentPlayer);
                return;
            }
            else if (board[3][9] == ' ') {
                executeComputerMove(3, 9, board, currentPlayer);
                return;
            }
            else {
                executeComputerMove(5, 15, board, currentPlayer);
                return;
            }
        }
        // check diagonal from bottom left corner, if it has 2 X's in a row
        if ((board[5][3] == 'X' && board[3][9] == 'X') || (board[3][9] == 'X' && board[1][15] == 'X') ||
                (board[5][3] == 'X' && board[1][15] == 'X')) {
            if (board[5][3] == ' ') {
                executeComputerMove(5, 3, board, currentPlayer);
                return;
            }
            else if (board[3][9] == ' ') {
                executeComputerMove(3, 9, board, currentPlayer);
                return;
            }
            else {
                executeComputerMove(1, 15, board, currentPlayer);
                return;
            }
        }
        Player.makeRandomComputerMove(board,currentPlayer);
    }




    private static void executeComputerMove(int i, int j, char[][] board, Player currentPlayer) {
        board[i][j] = currentPlayer.symbol;
        Board.printBoard(board);
        System.out.println("Computer has made a smart move.");
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


//┌─────┬─────┬─────┐
//│1/3  │1/9  │1/15 │
//├─────┼─────┼─────┤
//│3/3  │3/9  │3/15 │
//├─────┼─────┼─────┤
//│5/3  │5/9  │5/15 │
//└─────┴─────┴─────┘