import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        System.out.println("Let's play a game of tic tac toe!");
        System.out.println();
        System.out.println("Number of human players, 1 or 2?");
        Player player1 = new Player('X');
        player1.isHuman = true;
        Player player2 = new Player('O');


        boolean validNumOfPlayers = false;
        int numPlayers = sc.nextInt(); //TODO gör en try/catch här ifall anv inte skriver en int
        sc.nextLine();
        while (!validNumOfPlayers) {
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
                System.out.println("Invalid input. Please enter 1 or 2.");
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
            boolean gameOver = false;
            currentPlayer.starting = true;
            // En spelomgång:
            while (!gameOver) {
                if (currentPlayer.isHuman) {
                    System.out.println(currentPlayer.name + ", where would you like to place your " +
                            currentPlayer.symbol + "? (1-9)");
                    String move = "";
                    boolean validInput = false;
                    while (!validInput) {
                        move = sc.nextLine();
                        // TODO gör ev om hela board-arrayen så att getRight...metoderna inte behövs
                        switch (move) {
                            case "1", "2", "3", "4", "5", "6", "7", "8", "9" -> {
                                validInput = true;
                            }
                            default -> {
                                System.out.println("Not a valid move. Please enter a number 1-9.");
                            }
                        }
                    }
                    int i = Board.getRightRowIndex(move);
                    int j = Board.getRightColumnIndex(move);
                    //checking if field is already occupied
                    if (!Player.makeMove(b, currentPlayer, move)) { // försöker använda makeMove-metoden
                        System.out.println("That space is already occupied!");
                    }
                } else { // if currentPlayer is not human
                    Player.makeComputerMove(b, currentPlayer);
                }

                if (Board.threeInRow(b)) { // checks if current player wins
                    System.out.println(currentPlayer.name.toUpperCase() + " WINS!");
                    currentPlayer.score++;
                    gameOver = true;
                } else if (Board.isDraw(b)) { // checks if board is now full
                    System.out.println("Game ends in a draw.");
                    gameOver = true;
                } else { // switches currentPlayer before next turn
                    currentPlayer = Player.switchCurrentPlayer(currentPlayer, player1, player2);
                }
            }

                System.out.println("Current score:");
                System.out.println(player1.name + " " + player1.score); //TODO fixa så att denna och nästa rad blir lika långa,
                System.out.println(player2.name + " " + player2.score); //om ena namnet är längre, gör space efter andra namnet

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
        /*
        TODO:
        Skapa en tom spelplan "board" i en klass. Spelplanen är en 2d-array av char.
        Klassen Board ska ha en metod printBoard som skriver ut spelplanen.
        Ta input från spelaren om spelarnas namn.
        Skapa en klass Player som har en instansvariablerna name och symbol (om de är X eller O).
        Starta en spelloop, håll koll på vems tur det är (instansvariabel i Player?),
        låt varje spelare i tur och ordning ange ett nummer 1-9 för var de vill placera sin symbol.
        Kolla att fältet är tomt. Om det är det, skriv ut spelplanen med den tillagda symbolen.
        Skapa en funktion som kollar om någon vinner. (EV: Kolla sedan om det i nästa drag blir oavgjort.)
        Om brädet är fullt men ingen vunnit ska det också bli oavgjort och game over.

         */


    // Box-drawing characters:
    //System.out.println("\u2500 \u2502 \u250C \u2510 \u2514 \u2518 \u251C \u2524 \u252C " +
    //        "\u2534 \u253C \u2550 \u2551 \u2552 \u2553 \u2554 \u2555 \u2556\u2557 \u2558 " +
    //        "\u2559 \u255A \u255B \u255C \u255D \u255E \u255F\u2560 \u2561 \u2562 \u2563 " +
    //        "\u2564 \u2565 \u2566 \u2567 \u2568 \u2569 \u256A \u256B \u256C");


}



