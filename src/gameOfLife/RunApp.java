package gameOfLife;

import gameOfLife.Grid.CellState;

import java.util.AbstractMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 * This main function of the RunApp class is to take user input, such as the
 * size of the grid, how many generations of the cell and generating random
 * alive cells at the beginning stage.
 * 
 * @author Jason Zhu
 * @version v-01 August/02/2015
 */
public class RunApp {

	/**
	 * main method is the starting point of the application, it takes user input
	 * to build the grid, as well as generating random starting alive cells
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out
				.println("Welcome, to start please type in how many rows do you want the grid to have:");
		int inputRows = scan.nextInt();
		System.out
				.println("And please type in how many columns do you want the grid have: ");
		int inputColumns = scan.nextInt();
		System.out
				.println("How many generations of the cell do you want to see?");
		int numOfGenerations = scan.nextInt();
		System.out
				.println("How many alive cells do you want to set to start? The maximum alive cells cannot be more than "
						+ inputRows * inputColumns + " cells");
		int startingNumLiveCells = scan.nextInt();
		System.out.println();
		scan.close();

		Grid grid = new Grid(inputRows, inputColumns);

		Random randomNumGenerator = new Random();
		Set<Map.Entry<Integer, Integer>> generated = new LinkedHashSet<>();
		while (generated.size() < startingNumLiveCells) {
			int randomRows = randomNumGenerator.nextInt(inputRows);
			int randomColumns = randomNumGenerator.nextInt(inputColumns);
			grid.currentState[randomRows][randomColumns] = CellState.Alive;
			generated.add(new AbstractMap.SimpleEntry<>(randomRows,
					randomColumns));
		}

		System.out.println("Starting Generation:");
		printGrid(grid.currentState);
		System.out.println();
		int counter = 1;
		for (int i = 0; i < numOfGenerations; i++) {
			System.out.println("Generation " + counter + ":");
			grid.updateCurrentCellState();
			printGrid(grid.currentState);
			counter++;
		}
	}

	/**
	 * This method is called to print the grid to the console.
	 * 
	 * @param currentState
	 *            the current state of the cells
	 */
	private static void printGrid(CellState[][] currentState) {

		int x = 0;
		int rowLength = currentState[0].length;

		for (int i = 0; i < currentState.length; i++) {
			for (int j = 0; j < currentState[0].length; j++) {
				CellState currentCellstate = currentState[i][j];
				String output = (currentCellstate == CellState.Alive ? "#"
						: "-");
				System.out.print(output);
				x++;
				if (x >= rowLength) {
					x = 0;
					System.out.println();
				}
			}
		}
	}

}
