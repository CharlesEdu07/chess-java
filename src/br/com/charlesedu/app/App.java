package br.com.charlesedu.app;

import java.util.InputMismatchException;
import java.util.Scanner;

import br.com.charlesedu.chess.ChessException;
import br.com.charlesedu.chess.ChessMatch;
import br.com.charlesedu.chess.ChessPiece;
import br.com.charlesedu.chess.ChessPosition;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        ChessMatch chessMatch = new ChessMatch();

        while (true) {
            try {
                UI.clearScreen();

                UI.printBoard(chessMatch.getPieces());

                System.out.println();
                
                System.out.print("Source: ");
                ChessPosition source = UI.readChessPosition(sc);

                System.out.print("Target: ");
                ChessPosition target = UI.readChessPosition(sc);

                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
            } catch (ChessException e) {
                System.out.println();
                System.out.println(e.getMessage());
                System.out.print("\nPress ENTER to continue...");
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println(e.getMessage());
                System.out.print("\nPress ENTER to continue...");
                sc.nextLine();
            }
        }
    }
}
