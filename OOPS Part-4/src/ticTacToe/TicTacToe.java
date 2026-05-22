package ticTacToe;

import java.util.Scanner;

/*
Problem Statement:
Implement Tic Tac Toe game using
Board and Player classes.
*/

public class TicTacToe {
    private Player player1;
    private Player player2;
    private Board board;
    private int playerCount;

    private Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        TicTacToe t = new TicTacToe();
        t.startGame();
    }

    // O(1)
    public void startGame() {
        // take players input
        player1 = takePlayerInput(++playerCount);
        player2 = takePlayerInput(++playerCount);

        // avoid same symbols
        while (player1.getSymbol() == player2.getSymbol()) {
            System.out.println("Symbol already taken ! Pick another symbol !");
            player2.setSymbol(s.next().charAt(0));
        }

        // create board
        board = new Board(player1.getSymbol(), player2.getSymbol());

        boolean player1Turn = true;
        int status = Board.INCOMPLETE;

        // game loop
        while (status == Board.INCOMPLETE || status == Board.INVALIDMOVE) {
            if (player1Turn) {
                System.out.println("Player 1 - " + player1.getName() + "'s turn");
            } else {
                System.out.println("Player 2 - " + player2.getName() + "'s turn");
            }

            System.out.println("Enter x and y:");

            int x = s.nextInt();
            int y = s.nextInt();
            if (player1Turn) {
                status = board.move(player1.getSymbol(), x, y);
            } else {
                status = board.move(player2.getSymbol(), x, y);
            }

            // invalid move
            if (status == Board.INVALIDMOVE) {
                System.out.println("Invalid move ! Please try again !");
                continue;
            }

            // print updated board
            board.print();
            player1Turn = !player1Turn;
        }

        // final result
        if (status == Board.PLAYER1WINS) {
            System.out.println("Player 1 - " + player1.getName() + " wins !!");
        } else if (status == Board.PLAYER2WINS) {
            System.out.println("Player 2 - " + player2.getName() + " wins !!");
        } else {
            System.out.println("Draw !!");
        }
    }

    // O(1)
    private Player takePlayerInput(int num) {
        System.out.println("Enter Player " + num + " name:");
        String name = s.next();

        System.out.println("Enter Player " + num + " symbol:");
        char symbol = s.next().charAt(0);

        return new Player(name, symbol);
    }
}

/*
Sample Input 1 :
Enter Player 1 name:
Shiv
Enter Player 1 symbol:
X
Enter Player 2 name:
Shakti
Enter Player 2 symbol:
O

Sample Moves :
0 0
1 1
0 1
2 2
0 2

Sample Output 1 :
Player 1 - Shiv wins !!


Sample Input 2 :
Enter Player 1 name:
Shiv
Enter Player 1 symbol:
X
Enter Player 2 name:
Shakti
Enter Player 2 symbol:
O

Sample Moves :
0 0
1 0
2 2
1 1
2 0
1 2

Sample Output 2 :
Player 2 - Shakti wins !!
*/