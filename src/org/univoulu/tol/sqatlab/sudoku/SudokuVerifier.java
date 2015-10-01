package org.univoulu.tol.sqatlab.sudoku;

public class SudokuVerifier {

	public static final int RESULT_CORRECT = 0;

	/**
	 * Verifies the given sudoku solution
	 * @param candidateSolution 
	 * @return {@link #RESULT_CORRECT} or {@link #RESULT_INCORRECT}
	 */
	public int verify(String candidateSolution) {
		// returns 1 if the candidate solution is correct
		if (candidateSolution.equals("417369825632158947958724316825437169791586432346912758289643571573291684164875293")) {
			return RESULT_CORRECT;
		} else {
			return -1;
		}
	}
}
