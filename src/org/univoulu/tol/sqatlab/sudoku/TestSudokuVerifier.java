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
		assertEquals(SudokuVerifier.SUCCESS, result);		
	}
	
	@Test
	public void should_return_less_than_zero_for_incorrect_solution() {
		int result = verifier.verify(SOLUTION_INCORRECT);
		assertTrue(result < 0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void should_throw_expection_on_too_long_input() {
		verifier.verify(SOLUTION_VALID + "a");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void should_throw_exception_on_too_short_input() {
		verifier.verify(SOLUTION_VALID.substring(0, SOLUTION_VALID.length() -1));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void should_throw_exception_on_non_digit_input() {
		String testSolution = "";
		for (int i = 0; i < 81; i++) {
			testSolution += "a";
		}
		verifier.verify(testSolution);
	}
	
	@Test
	public void should_return_negative_two_if_sub_grid_contains_multiples_of_same_digit() {
		String testSolution = "417369825612158947958724316825437169791586432346912758289643571573291684164875293";
		int result = verifier.verify(testSolution);
		assertEquals(-2, result);
	}
	
	/**
	 * R3: A digit can appear only once in the rows of the global grid.
	 */
	@Test
	public void should_return_negative_three_if_row_contains_multiples() {
		String testSolution = "417369825932158947658724316825437169791586432346912758289643571573291684164875293";
		int result = verifier.verify(testSolution);
		assertEquals(-3, result);
	}
	
}
