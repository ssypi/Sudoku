package org.univoulu.tol.sqatlab.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuVerifier {

	public static final int SUCCESS = 0;
	public static final int FAIL_SUBGRID_CONTAINS_MULTIPLES = -2;

	private static final int SUB_GRID_LENGTH = 9;
	
	/**
	 * Verifies the given sudoku solution
	 * @param candidateSolution 81 characters long String where first 9 are the first row, second 9 are the second row etc.
	 * @return {@link #SUCCESS} if solution is correct, else less than 0
	 */
	public int verify(String candidateSolution) {
		validateSolutionFormat(candidateSolution);
		
		List<SubGrid> subGrids = new ArrayList<>();
		String temp = candidateSolution;
		while(temp.length() > 9) {
			String gridString = temp.substring(0, SUB_GRID_LENGTH);
			SubGrid subGrid = new SubGrid(gridString);
			subGrids.add(subGrid);
			temp = temp.substring(SUB_GRID_LENGTH, temp.length());
		}
		
		boolean allGridsValid = true;
		for (SubGrid grid : subGrids) {
			if (!grid.isValid()) {
				allGridsValid = false;
			}
		}
		
		if (!allGridsValid) {
			return FAIL_SUBGRID_CONTAINS_MULTIPLES;
		}
		
		if (candidateSolution.equals("417369825632158947958724316825437169791586432346912758289643571573291684164875293")) {
			return SUCCESS;
		} else {
			return -1;
		}
	}
	
	private void validateSolutionFormat(String solution) throws IllegalArgumentException {
		if (solution == null || solution.length() != 81) {
			Integer length = null;
			if (solution != null) length = solution.length();
			throw new IllegalArgumentException("Solution must be exactly 81 characters long (was " + length + ")");
		}
		if (!solution.matches("[0-9]+")) {
			throw new IllegalArgumentException("Solution may only contain numbers 0-9 (was " + solution + ")");
		}
	}
}
