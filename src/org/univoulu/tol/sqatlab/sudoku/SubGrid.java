package org.univoulu.tol.sqatlab.sudoku;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubGrid {
	private final Set<Integer> cells;
	
	public SubGrid(String subgrid) {
		if (subgrid == null || subgrid.length() != 9 || !subgrid.matches("[0-9]+")) {
			throw new IllegalArgumentException("Subgrid must only contain numbers 0-9 and have exactly 9 digits long (was " + subgrid + ")");
		}
		Set<Integer> temp = new HashSet<>();
		
		for(char c : subgrid.toCharArray()) {
			int cell = Character.getNumericValue(c);
			temp.add(cell);
		}
		
		cells = Collections.unmodifiableSet(temp);
	}
	
	public boolean isValid() {
		return true;
	}
	
	public List<Integer> getCells() {
		return cells;
	}
}
