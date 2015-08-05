package gameOfLife;

import gameOfLife.Grid.CellState;

/**
 * This main function of the SurvivingRules class is to check the live status of
 * the cell.
 * 
 * @author Jason Zhu
 * @version v-01 August/02/2015
 */
public class SurvivingRules {

	/**
	 * It is being called to check the status of the cell
	 * 
	 * @param currentState
	 *            the current status of the cell, either Alive or Dead
	 * @param aliveNeighbors
	 *            how many alive neighbors around the cell
	 * 
	 * @return The status of the cell, either Alive or Dead
	 */
	static CellState getCurrentCellState(CellState currentState,
			int aliveNeighbors) {
		if (currentState == CellState.Alive && aliveNeighbors < 2) {
			return CellState.Dead;
		}// a cell is dead if it has fewer than 2 alive neighbors

		if (currentState == CellState.Alive && aliveNeighbors > 3) {
			return CellState.Dead;
		}// a cell is dead if it has more than 3 alive neighbors

		if (currentState == CellState.Dead && aliveNeighbors == 3) {
			return CellState.Alive;
		}// a dead cell becomes alive if it has three alive neighbors

		return currentState;
	}// end of getCurrentCellState

}// end of class
