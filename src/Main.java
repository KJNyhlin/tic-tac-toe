import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Let's play a game of tic tac toe!");
        System.out.println();
        System.out.println("Please enter the name of player one:");
        String name1 = sc.nextLine();
        System.out.println("Please enter the name of player two:");
        String name2 = sc.nextLine();
        Player player1 = new Player(name1, 'X');
        Player player2 = new Player(name2, 'O');
        boolean stillPlaying = true;

        while (stillPlaying) {
            Board board = new Board();
            char[][] b = board.board;
            Board.printBoard(b);
            boolean gameOver = false;
            Player currentPlayer = player1;
            currentPlayer.starting = true;
            // En spelomgång:
            while (!gameOver) {
                System.out.println(currentPlayer.name + ", where would you like to place your " +
                        currentPlayer.symbol + "? (1-9)");
                boolean validInput = false;
                while (!validInput) {
                    // TODO gör en try/catch här för att gardera mot att användaren inte skriver int
                    int move = sc.nextInt();
                    sc.nextLine();
                    int i = 0; // row
                    int j = 0; // column
                    switch (move) {
                        case 1, 2, 3 -> {
                            i = 1;
                            validInput = true;
                        }
                        case 4, 5, 6 -> {
                            i = 3;
                            validInput = true;
                        }
                        case 7, 8, 9 -> {
                            i = 5;
                            validInput = true;
                        }
                        default -> {
                        }
                    }
                    validInput = false;
                    switch (move) {
                        case 1, 4, 7 -> {
                            j = 3;
                            validInput = true;
                        }
                        case 2, 5, 8 -> {
                            j = 9;
                            validInput = true;
                        }
                        case 3, 6, 9 -> {
                            j = 15;
                            validInput = true;
                        }
                        default -> {
                        }
                    }
                    //check if field is already occupied
                    if (b[i][j] != ' ') {
                        System.out.println("That space is already occupied!");
                    }
                    else {
                        b[i][j] = currentPlayer.symbol;
                        validInput = true;
                        Board.printBoard(b);
                        if (Board.threeInRow(b)) {
                            System.out.println(currentPlayer.name + " has three in a row!"); //TODO fixa detta:
                            // blir ju fel om den spelare som inte är starting har kört sitt sista drag
                            // kanske Player kan ha en instansvariabel winner istället
                            // måste också kolla draw
                            // fråga sedan om man vill spela igen
                            if (currentPlayer.starting) {
                                if (currentPlayer == player1) {
                                    System.out.println(player2.name + " has one move left to make a draw.");
                                } else {
                                    System.out.println(player1.name + " has one move left to make a draw.");
                                }
                            }
                            else {
                                System.out.println(currentPlayer.name.toUpperCase() + " WINS!"); //kan bli fel spelare, se ovan
                                currentPlayer.score ++; // samma här
                                gameOver = true;
                            }
                        }
                        if (currentPlayer == player1) {
                            currentPlayer = player2;
                        }
                        else {
                            currentPlayer = player1;
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







}}