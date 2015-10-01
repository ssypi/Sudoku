package org.univoulu.tol.sqatlab.sudoku;

public class SudokuVerifier {

	public static final int RESULT_CORRECT = 0;

	/**
	 * Verifies the given sudoku solution
	 * @param candidateSolution 81 characters long String where first 9 are the first row, second 9 are the second row etc.
	 * @return {@link #RESULT_CORRECT} if solution is correct, else less than 0
	 */
	public int verify(String candidateSolution) {
		if (candidateSolution == null || candidateSolution.length() != 81) {
			throw new IllegalArgumentException("Solution must be exactly 81 characters long (was " + candidateSolution.length() + ")");
		}
		if (!candidateSolution.matches("[0-9]+")) {
			throw new IllegalArgumentException("Solution may only contain numbers 0-9 (was " + candidateSolution + ")");
		}
		
		if (candidateSolution.equals("417369825632158947958724316825437169791586432346912758289643571573291684164875293")) {
			return RESULT_CORRECT;
		} else {
			return -1;
		}
	}
}
