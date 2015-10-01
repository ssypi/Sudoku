package org.univoulu.tol.sqatlab.sudoku;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSudokuVerifier {

	private final String SOLUTION_CORRECT = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
	private final String SOLUTION_INCORRECT = "123456789912345678891234567789123456678912345567891234456789123345678912234567891";
	
	@Test
	public void should_accept_correct_solution() {
		SudokuVerifier verifier = new SudokuVerifier();
		int result = verifier.verify(SOLUTION_CORRECT);
		assertEquals(SudokuVerifier.RESULT_CORRECT, result);		
	}

}
