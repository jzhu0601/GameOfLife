package gameOfLife;

/**
 * This main function of the Grid class is used for initializing the Grid,as
 * well as updating each cell alive or dead status.
 * 
 * @author Jason Zhu
 * @version v-01 August/02/2015
 */
public class Grid {

	/**
	 * CellState is used for check the status of the cell, its either Alive or
	 * Dead.
	 */
	static enum CellState {
		Alive, Dead;
	}

	/* Variable currentState */
	CellState[][] currentState;

	/* Variable nextState */
	private CellState[][] nextState;

	/* Variable gridRow of the grid */
	private int gridRow;

	/* Variable gridColumn of the grid */
	private int gridColumn;

	/**
	 * Constructor initialize the starting size of the grid, and by default all
	 * cells are in Dead status.
	 * 
	 * @param row
	 *            how many rows of the grid
	 * @param column
	 *            how many columns of the grid
	 */
	public Grid(int row, int column) {
		gridRow = row;
		gridColumn = column;

		currentState = new CellState[gridRow][gridColumn];
		nextState = new CellState[gridRow][gridColumn];
		initiateStartingCellState(gridRow, gridColumn);
	}// end of constructor

	/**
	 * It is being called when initializing the starting size of the grid by the
	 * constructor.
	 * 
	 * @param row
	 *            how many rows of the grid
	 * @param column
	 *            how many columns of the grid
	 */
	void initiateStartingCellState(int row, int column) {
		for (int i = 0; i < gridRow; i++) {
			for (int j = 0; j < gridColumn; j++) {
				currentState[i][j] = CellState.Dead;
			}
		}
	}// end of initiateStartingCellState

	/**
	 * It is being called to update the current cell status, either from Alive
	 * to Dead, or from Dead to Alive.
	 */
	void updateCurrentCellState() {

		for (int i = 0; i < gridRow; i++) {
			for (int j = 0; j < gridColumn; j++) {
				int liveNeighbors = getAliveNeighbors(i, j);
				nextState[i][j] = SurvivingRules.getCurrentCellState(
						currentState[i][j], liveNeighbors);
			}
		}
		currentState = nextState;
		nextState = new CellState[gridRow][gridColumn];
	}// end of updateCurrentCellState

	/**
	 * It is being called to acquire how many alive neighbors are there for each
	 * cell.
	 * 
	 * @param x
	 *            Origin cell position x
	 * @param y
	 *            Origin cell position y
	 * 
	 * @return The actually alive neighbors of any given cell
	 */
	int getAliveNeighbors(int x, int y) {

		int liveNeighbors = 0;
		int[][] neighbors = { { x - 1, y }, { x - 1, y - 1 }, { x, y - 1 },
				{ x + 1, y - 1 }, { x + 1, y }, { x + 1, y + 1 }, { x, y + 1 },
				{ x - 1, y + 1 } };

		for (int i = 0; i < neighbors.length; i++) {
			int neighborX = neighbors[i][0];
			int neighborY = neighbors[i][1];
			if (neighborX >= 0 && neighborX < gridRow && neighborY >= 0
					&& neighborY < gridColumn
					&& currentState[neighborX][neighborY] == CellState.Alive) {
				liveNeighbors++;
			}
		}
		return liveNeighbors;
	}// end of getAliveNeighbors

}// end of class
