public class Board {
    public char[][] board;
    public static int boardRows = 6;
    public static int boardColumns = 19;

    public Board() {
        board = new char[][]{
                {'┌', '─', '─', '─', '─', '─', '┬', '─', '─', '─', '─', '─', '┬', '─', '─', '─', '─', '─', '┐'},
                {'│', ' ', ' ', ' ', ' ', ' ', '│', ' ', ' ', ' ', ' ', ' ', '│', ' ', ' ', ' ', ' ', ' ', '│'},
                {'├', '─', '─', '─', '─', '─', '┼', '─', '─', '─', '─', '─', '┼', '─', '─', '─', '─', '─', '┤'},
                {'│', ' ', ' ', ' ', ' ', ' ', '│', ' ', ' ', ' ', ' ', ' ', '│', ' ', ' ', ' ', ' ', ' ', '│'},
                {'├', '─', '─', '─', '─', '─', '┼', '─', '─', '─', '─', '─', '┼', '─', '─', '─', '─', '─', '┤'},
                {'│', ' ', ' ', ' ', ' ', ' ', '│', ' ', ' ', ' ', ' ', ' ', '│', ' ', ' ', ' ', ' ', ' ', '│'},
                {'└', '─', '─', '─', '─', '─', '┴', '─', '─', '─', '─', '─', '┴', '─', '─', '─', '─', '─', '┘'}
        };
    }

    public static void printBoard(char[][] board) {
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static int getRightRowIndex(String move) {
        int i;
        switch (move) {
            case "1", "2", "3" -> {
                return i = 1;
            }
            case "4", "5", "6" -> {
                return i = 3;
            }
            case "7", "8", "9" -> {
                return i = 5;
            }
            default -> {return i = Integer.parseInt(null);}
        }
    }

    public static int getRightColumnIndex(String move) {
        int j;
        switch (move) {
            case "1", "4", "7" -> {
                j = 3;
            }
            case "2", "5", "8" -> {
                j = 9;
            }
            case "3", "6", "9" -> {
                j = 15;
            }
            default -> j = Integer.parseInt(null);
        }
        return j;
    }
    public static boolean threeInRow(char[][] board) {
        for (int i = 1; i < boardRows; i += 2) { // checks all the rows if one is complete
            if (board[i][3] != ' ') { // checks that the first one in the comparison is not a space
                if (board[i][3] == board[i][9] && board[i][9] == board[i][15]) {
                    return true;
                }
            }
        }
        for (int j = 3; j < boardColumns; j += 6) {
            if (board[1][j] != ' ') {
                if (board[1][j] == board[3][j] && board[3][j] == board[5][j]) {
                    return true;
                }
            }
        }
        if (board[3][9] != ' ') { // mittersta rutan
            if (board[1][3] == board[3][9] && board[3][9] == board[5][15]) { // ena diagonalen
                return true;
            }
            else if (board[1][15] == board[3][9] && board[3][9] == board[5][3]) { // andra diagonalen
                return true;
            }
        }
        return false;
    }

    public static boolean isDraw(char[][] board) {
        for (int i = 1; i < boardRows; i += 2) {
            for (int j = 3; j < boardColumns; j += 6) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
    //┌─────┬─────┬─────┐
    //│1/3  │1/9  │1/15 │
    //├─────┼─────┼─────┤
    //│3/3  │3/9  │3/15 │
    //├─────┼─────┼─────┤
    //│5/3  │5/9  │5/15 │
    //└─────┴─────┴─────┘
}
