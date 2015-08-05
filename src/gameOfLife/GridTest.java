package gameOfLife;

import static org.junit.Assert.*;
import gameOfLife.Grid.CellState;

import org.junit.Test;

/**
 * The GridTest class is used for testing the functionality of Grid class.
 * 
 * @author Jason Zhu
 * @version v-01 August/02/2015
 */
public class GridTest {

	/**
	 * Test getLiveNeighbors functionality, random cells testing
	 */
	@Test
	public void testGetLiveNeighborsRandomCell() {

		// Testing randomn cells
		Grid grid = new Grid(5, 5);
		grid.currentState[2][2] = CellState.Alive;
		grid.currentState[1][2] = CellState.Alive;
		grid.currentState[3][2] = CellState.Alive;
		grid.updateCurrentCellState();
		assertEquals(2, grid.getAliveNeighbors(2, 2));
		assertEquals(3, grid.getAliveNeighbors(3, 2));
		assertEquals(3, grid.getAliveNeighbors(1, 2));

		// Testing cells that are on the border of the grid
	}

	/**
	 * Test getLiveNeighbors functionality, cells on the border of the grid
	 */
	@Test
	public void testGetLiveNeighborsCellOnBorder() {

		// Testing cells that are on the border of the grid
		Grid grid = new Grid(5, 5);
		grid.currentState[0][0] = CellState.Alive;
		grid.currentState[0][1] = CellState.Alive;
		grid.currentState[0][2] = CellState.Alive;
		grid.updateCurrentCellState();
		assertEquals(2, grid.getAliveNeighbors(0, 0));
		assertEquals(1, grid.getAliveNeighbors(0, 1));
		assertEquals(2, grid.getAliveNeighbors(0, 2));
	}

}
