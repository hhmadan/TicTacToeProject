package tictactoegame;

import java.util.Scanner;

public class TicTacToe {
    final static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        char[][] ticTacToeBoard = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};

        showBoard(ticTacToeBoard);
        System.out.println("What you want==> X or O? Enter..");
        char letter = sc.next().charAt(0);
        System.out.println(letter);
    }
    public static void showBoard(char [][] ticTacToeBoard){
        for(char[] row : ticTacToeBoard){
            for(char column : row){
                System.out.print(column);
            }
            System.out.println();
        }
    }
}
