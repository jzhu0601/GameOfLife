package gameOfLife;

import static org.junit.Assert.*;
import gameOfLife.Grid.CellState;

import org.junit.Test;

/**
 * The SurvivingRules Test class is used for testing the functionality of
 * SurvivingRules class.
 * 
 * @author Jason Zhu
 * @version v-01 August/02/2015
 */
public class SurvivingRulesTest {

	/**
	 * Test LiveCell_LessThanTwoLiveNeighbors_Dies functionality, any cell with
	 * less than two neighbors should be in Dead status.
	 */
	@Test
	public void LiveCell_LessThanTwoLiveNeighbors_Dies() {
		CellState currentStateC0 = CellState.Alive;
		CellState currentStateC1 = CellState.Alive;
		int liveNeighborsC0 = 0;
		int liveNeighborsC1 = 1;
		CellState resultC0 = SurvivingRules.getCurrentCellState(currentStateC0,
				liveNeighborsC0);
		CellState resultC1 = SurvivingRules.getCurrentCellState(currentStateC1,
				liveNeighborsC1);
		assertEquals(CellState.Dead, resultC0);
		assertEquals(CellState.Dead, resultC1);
	}

	/**
	 * Test LiveCell_TwoOrThreeLiveNeighbors_Lives functionality, any cell with
	 * two or three neighbors should be in Alive status.
	 */
	@Test
	public void LiveCell_TwoOrThreeLiveNeighbors_Lives() {
		CellState curentStateC2 = CellState.Alive;
		CellState curentStateC3 = CellState.Alive;
		int liveNeighborsC2 = 2;
		int liveNeighborsC3 = 3;

		CellState resultC2 = SurvivingRules.getCurrentCellState(curentStateC2,
				liveNeighborsC2);
		CellState resultC3 = SurvivingRules.getCurrentCellState(curentStateC3,
				liveNeighborsC3);

		assertEquals(CellState.Alive, resultC2);
		assertEquals(CellState.Alive, resultC3);
	}

	/**
	 * Test LiveCell_MoreThanThreeLiveNeighbors_Dies functionality, any cell
	 * with more than three neighbors should be in Dead status.
	 */
	@Test
	public void LiveCell_MoreThanThreeLiveNeighbors_Dies() {
		CellState curentStateC4 = CellState.Alive;
		CellState curentStateC5 = CellState.Alive;
		CellState curentStateC6 = CellState.Alive;
		CellState curentStateC7 = CellState.Alive;
		CellState curentStateC8 = CellState.Alive;
		int liveNeighborsC4 = 4;
		int liveNeighborsC5 = 5;
		int liveNeighborsC6 = 6;
		int liveNeighborsC7 = 7;
		int liveNeighborsC8 = 8;

		CellState resultC4 = SurvivingRules.getCurrentCellState(curentStateC4,
				liveNeighborsC4);
		CellState resultC5 = SurvivingRules.getCurrentCellState(curentStateC5,
				liveNeighborsC5);
		CellState resultC6 = SurvivingRules.getCurrentCellState(curentStateC6,
				liveNeighborsC6);
		CellState resultC7 = SurvivingRules.getCurrentCellState(curentStateC7,
				liveNeighborsC7);
		CellState resultC8 = SurvivingRules.getCurrentCellState(curentStateC8,
				liveNeighborsC8);

		assertEquals(CellState.Dead, resultC4);
		assertEquals(CellState.Dead, resultC5);
		assertEquals(CellState.Dead, resultC6);
		assertEquals(CellState.Dead, resultC7);
		assertEquals(CellState.Dead, resultC8);

	}

	/**
	 * Test DeadCell_WithThreeLiveNeighbors_Lives functionality, any dead cell
	 * with three alive neighbors should be in Alive status.
	 */
	@Test
	public void DeadCell_WithThreeLiveNeighbors_Lives() {
		CellState curentStateC3 = CellState.Dead;
		int liveNeighborsC3 = 3;

		CellState result = SurvivingRules.getCurrentCellState(curentStateC3,
				liveNeighborsC3);

		assertEquals(CellState.Alive, result);
	}
}
