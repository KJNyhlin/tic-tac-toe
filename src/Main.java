import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Board board = new Board();
        Board.printBoard(Board.board);

        /*
        TODO:
        Skapa en tom spelplan "board" i en klass. Spelplanen är en 2d-array av char.
        Klassen Board ska ha en metod printBoard som skriver ut spelplanen.
        Ta input från spelaren om spelarnas namn.
        Skapa en klass Player som har en instansvariablerna name och symbol (om de är X eller O).
        Starta en spelloop, håll koll på vems tur det är (instansvariabel i Player?),
        låt varje spelare i tur och ordning ange ett nummer 1-9 för var de vill placera sin symbol.
        Kolla att fältet är tomt. Om det är det, skriv ut spelplanen med den tillagda symbolen.
        Skapa en funktion som kollar om någon vinner. Kolla sedan om det i nästa drag blir oavgjort.

         */


        // Box-drawing characters:
        //System.out.println("\u2500 \u2502 \u250C \u2510 \u2514 \u2518 \u251C \u2524 \u252C " +
        //        "\u2534 \u253C \u2550 \u2551 \u2552 \u2553 \u2554 \u2555 \u2556\u2557 \u2558 " +
        //        "\u2559 \u255A \u255B \u255C \u255D \u255E \u255F\u2560 \u2561 \u2562 \u2563 " +
        //        "\u2564 \u2565 \u2566 \u2567 \u2568 \u2569 \u256A \u256B \u256C");



    }







}