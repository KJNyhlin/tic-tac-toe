import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        System.out.println("Let's play a game of tic tac toe!");
        System.out.println();
        System.out.println("How many human players, 1 or 2?");
        Player player1 = new Player('X');
        player1.isHuman = true;
        Player player2 = new Player('O');


        int numPlayers;
        boolean validNumOfPlayers = false;
        while (!validNumOfPlayers) {
            numPlayers = readIntFromUser(sc);

            if (numPlayers == 1) {
                validNumOfPlayers = true;
                System.out.println("Please enter your name:");
                player1.name = sc.nextLine();
                player2.name = "Computer";
                player2.isHuman = false;
            } else if (numPlayers == 2) {
                validNumOfPlayers = true;
                System.out.println("Please enter the name of player one:");
                player1.name = sc.nextLine();
                System.out.println("Please enter the name of player two:");
                player2.name = sc.nextLine();
                player2.isHuman = true;
            } else {
                System.out.println("Please enter 1 or 2.");
            }
        }
        Player currentPlayer = player1;

        boolean stillPlaying = true;
        while (stillPlaying) {
            Board board = new Board();
            char[][] b = board.board;
            if (currentPlayer.isHuman) {
                //otherwise the board will be printed both before and after computer makes its move
                Board.printBoard(b);
            }
            boolean gameFinished = false;
            currentPlayer.starting = true;
            // En spelomgång:
            while (!gameFinished) {
                if (currentPlayer.isHuman) {
                    System.out.println(currentPlayer.name + ", where would you like to place your " +
                            currentPlayer.symbol + "? (1-9)");
                    String move;
                    boolean validMove = false;
                    while (!validMove) {
                        move = sc.nextLine();
                        switch (move) {
                            case "1", "2", "3", "4", "5", "6", "7", "8", "9" -> {
                                if (!Player.makeMove(b, currentPlayer, move)) { // checks if makeMove returns false
                                    System.out.println("That space is already occupied! Try again.");
                                } else {
                                    validMove = true;
                                    Player.makeMove(b, currentPlayer, move);
                                }
                            }
                            default -> System.out.println("Not a valid move. Please enter a number 1-9.");
                        }

                    }
                } else { // if currentPlayer is not human
                    Player.makeRandomComputerMove(b, currentPlayer);
                }

                if (Board.threeInRow(b)) { // checks if current player wins
                    System.out.println(currentPlayer.name.toUpperCase() + " WINS!");
                    currentPlayer.score++;
                    gameFinished = true;
                } else if (Board.isDraw(b)) { // checks if board is now full
                    System.out.println("Game ends in a draw.");
                    gameFinished = true;
                } else { // switches currentPlayer before next turn
                    currentPlayer = Player.switchCurrentPlayer(currentPlayer, player1, player2);
                }
            }


            System.out.println("Current score:");
            Player.printScore(player1, player2);
            System.out.println("Would you like to play again? (y/n)");
            boolean validInput = false;
            while (!validInput) {
                String input = sc.nextLine();
                if (input.equalsIgnoreCase("n")) {
                    System.out.println("See you next time!");
                    stillPlaying = false;
                    validInput = true;
                } else if (input.equalsIgnoreCase("y")) {
                    currentPlayer = Player.switchCurrentPlayer(currentPlayer, player1, player2);
                    currentPlayer.starting = Player.switchStartingPlayer(currentPlayer);
                    validInput = true;
                } else {
                    System.out.println("Invalid input. Please enter \"y\" for yes or \"n\" for no.");
                }
            }

        }
    }

    public static int readIntFromUser(Scanner sc) {
        while (true) {
            try {
                String s = sc.nextLine();
                return Integer.parseInt(s);
            } catch (Exception e) {
                System.out.println("Input must be a number. Please try again.");
            }
        }
    }

}



