/**
 * @author gramcha
 * 15-Jan-2018 1:18:14 PM
 * 
 */
package com.gramcha.entities;

public class BoardState {
	private int fullmoves;
	private String white_win;
	private int pawn_diff;
	private int rook_diff;
	private int knight_diff;
	private int bishop_diff;
	private int queen_diff;

	public int getFullmoves() {
		return fullmoves;
	}

	public void setFullmoves(int fullmoves) {
		this.fullmoves = fullmoves;
	}

	public String getWhite_win() {
		return white_win;
	}

	public void setWhite_win(String white_win) {
		this.white_win = white_win;
	}

	public int getPawn_diff() {
		return pawn_diff;
	}

	public void setPawn_diff(int pawn_diff) {
		this.pawn_diff = pawn_diff;
	}

	public int getRook_diff() {
		return rook_diff;
	}

	public void setRook_diff(int rook_diff) {
		this.rook_diff = rook_diff;
	}

	public int getKnight_diff() {
		return knight_diff;
	}

	public void setKnight_diff(int knight_diff) {
		this.knight_diff = knight_diff;
	}

	public int getBishop_diff() {
		return bishop_diff;
	}

	public void setBishop_diff(int bishop_diff) {
		this.bishop_diff = bishop_diff;
	}

	public int getQueen_diff() {
		return queen_diff;
	}

	public void setQueen_diff(int queen_diff) {
		this.queen_diff = queen_diff;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BoardState [fullmoves=");
		builder.append(fullmoves);
		builder.append(", white_win=");
		builder.append(white_win);
		builder.append(", pawn_diff=");
		builder.append(pawn_diff);
		builder.append(", rook_diff=");
		builder.append(rook_diff);
		builder.append(", knight_diff=");
		builder.append(knight_diff);
		builder.append(", bishop_diff=");
		builder.append(bishop_diff);
		builder.append(", queen_diff=");
		builder.append(queen_diff);
		builder.append("]");
		return builder.toString();
	}

}
// @attribute fullmoves numeric
// @attribute white_win {False,True}
// @attribute pawn_diff numeric
// @attribute rook_diff numeric
// @attribute knight_diff numeric
// @attribute bishop_diff numeric
// @attribute queen_diff numeric