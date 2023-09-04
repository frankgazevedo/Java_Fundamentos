package application;

import entities.chess.ChessPiece;

public class UI {

	public static void printBoard(ChessPiece[][] pieces) {
		for (int i = 0; i < pieces.length; i++) {

			// imprime o começo de cada linha
			System.out.print((8 - i) + " ");
			for (int j = 0; j < pieces.length; j++) {

				// imprime cada peça na linha
				printPiece(pieces[i][j]);
			}

			// imprime o '\n' para mudar de linha
			System.out.println();
		}

		// imprime a última linha
		System.out.println("  a b c d e f g h");

	}

	private static void printPiece(ChessPiece piece) {
		if (piece == null) {
			System.out.print("-");
		} else {
			System.out.print(piece);
		}
		System.out.print(" ");
	}

}
