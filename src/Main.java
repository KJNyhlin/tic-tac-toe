import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        char[][] board = {
                {' ', '|', ' ', '|', ' '},
                {'–', '+', '–', '+', '–'},
                {' ', '|', ' ', '|', ' '},
                {'–', '+', '–', '+', '–'},
                {' ', '|', ' ', '|', ' '}};

        printBoard(board);


        //ArrayList<ArrayList<String>> board = new ArrayList<>(3);
        //ArrayList<String> row1 = new ArrayList<>(3);
        //String row1col1 = "┌─────\n|     ";
        //String row1col2 = "┌─────\n|     ";
        //String row1col3 = "┬─────┐\n|     |";
        //ArrayList<String> row2 = new ArrayList<>(3);
        //ArrayList<String> row3 = new ArrayList<>(3);
        ////String str1 = "┌─────┬─────┬─────┐\n" +
        ////       "                |     │  X  |     |";
        //row1.add(0, row1col1);
        //row1.add(1, row1col2);
        //row1.add(2, row1col3);
        //board.add(0, row1);
        //board.add(1, row2);
        //board.add(2, row3);
        //System.out.println(board.get(0).);

        //String board = Arrays.toString(new String[3][3]);
       // String[][] board = new String[][]{
       //         {"┌─────\n|     \n|-----", "┌─────\n|     \n|-----", "┌─────\n|     \n|-----"},
       //         {"┌─────\n|     \n|-----", "┌─────\n|     \n|-----", "┌─────\n|     \n|-----"},
       //         {"┌─────\n|     \n|-----", "┌─────\n|     \n|-----", "┌─────\n|     \n|-----"}
       // };
       // // print the board
       // for (int i = 0; i < 3; i++) {
       //     for (int j = 0; j < 3; j++) {
       //         System.out.print(board[i][j]);
       //     }
       // }
        //System.out.println(Arrays.deepToString(board));
        /*System.out.println("""
                ┌─────┬─────┬─────┐
                |     │  X  |     |
                |-----|-----|-----|
                |     |  O  |     |
                |-----|-----|-----|
                |     |     |     |
                |-----|-----|-----|
                
                """);


    }*/

        //char[][] board = new char[3][3];
        //for (int i = 0; i < 3; i++) {
        //    for (int j = 0; j < 3; j++) {
        //        board[i][j] = '-';
        //    }
        //}
        //for (int i = 0; i < 3; i++){
        //    System.out.print(board.get(i));
        //    for (int j = 0; j < 3; j++) {
        //        System.out.println(board.get(j));
        //    }
        //}
        //System.out.println(Arrays.deepToString(board));


    }






public static void printBoard(char[][] board) {
    for (char[] row : board) {
        for (char c : row) {
            System.out.print(c);
        }
        System.out.println();
    }
}
}