package entities.chess;

import entities.boardgame.Board;

public class ChessMatch {

	private Board board;

	public ChessMatch() {
		super();
		this.board = new Board(8, 8);
	}

	// retorna a matriz de peças de xadrez na partida
	public ChessPiece[][] getPieces() {
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];

		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getColumns(); j++) {

				// down casting
				mat[i][j] = (ChessPiece) board.piece(i, j);
			}
		}

		return mat;
	}
}
