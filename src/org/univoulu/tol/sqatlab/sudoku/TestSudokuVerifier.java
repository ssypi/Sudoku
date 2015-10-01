package org.univoulu.tol.sqatlab.sudoku;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestSudokuVerifier {

	private final String SOLUTION_VALID = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
	private final String SOLUTION_INCORRECT = "123456789912345678891234567789123456678912345567891234456789123345678912234567891";
	
	private SudokuVerifier verifier;
	
	@Before
	public void setup() {
		verifier = new SudokuVerifier();
	}
	
	@Test
	public void should_return_zero_for_valid_solution() {
		int result = verifier.verify(SOLUTION_VALID);
		assertEquals(SudokuVerifier.RESULT_CORRECT, result);		
	}
	
	@Test
	public void should_return_less_than_zero_for_incorrect_solution() {
		int result = verifier.verify(SOLUTION_INCORRECT);
		assertTrue(result < 0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void should_throw_error_on_too_long_input() {
		verifier.verify(SOLUTION_VALID + "a");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void should_throw_error_on_too_short_input() {
		verifier.verify(SOLUTION_VALID.substring(0, SOLUTION_VALID.length()));
	}
}
