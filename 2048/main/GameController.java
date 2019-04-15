package main;

import java.util.ArrayList;

import javafx.scene.input.KeyCode;

public class GameController {

	public GameController() {

	}

	public Tile[][] spawn(Tile[][] grid) {

		ArrayList<Integer> Col = new ArrayList<Integer>();

		ArrayList<Integer> Row = new ArrayList<Integer>();

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == null) {
					Col.add(j);
					Row.add(i);
				}
			}
		}

		int index = (int) (Math.random() * Col.size());

		grid[Row.get(index)][Col.get(index)] = new Tile();

		grid[Row.get(index)][Col.get(index)].randomSize();

		return grid;

	}

	public Tile[][] move(Tile[][] grid, KeyCode key) {

		switch (key) {
		case LEFT:
			for (int row = 0; row < grid.length; row++) {

				for (int rep = 0; rep < 3; rep++) {

					for (int col = 1; col < grid[row].length; col++) {

						// sätta samman lika tiles
						if (grid[row][col] != null && grid[row][col - 1] != null) {

							if (grid[row][col].getValue() == grid[row][col - 1].getValue()
									&& !grid[row][col - 1].getFuse() && !grid[row][col].getFuse()) {

								System.out.println("svetsade");

								grid[row][col - 1].increase();
								grid[row][col] = null;
								grid[row][col - 1].switchFuse();

							}
						}

						if (grid[row][col - 1] == null && grid[row][col] != null) {

							System.out.println("to empty"); // temp

							grid[row][col - 1] = new Tile();
							grid[row][col - 1].setup(grid[row][col].getIncreases());
							grid[row][col] = null;
						}
					}
				}
			}
			break;

		case RIGHT:
			for (int row = 0; row < grid.length; row++) {

				for (int rep = 0; rep < 3; rep++) {

					for (int col = 2; col >= 0; col--) {

						// sätta samman lika tiles
						if (grid[row][col] != null && grid[row][col + 1] != null) {

							if (grid[row][col].getValue() == grid[row][col + 1].getValue()
									&& !grid[row][col + 1].getFuse() && !grid[row][col].getFuse()) {

								System.out.println("svetsade");

								grid[row][col + 1].increase();
								grid[row][col] = null;
								grid[row][col + 1].switchFuse();

							}
						}

						if (grid[row][col + 1] == null && grid[row][col] != null) {

							System.out.println("to empty"); // temp

							grid[row][col + 1] = new Tile();
							grid[row][col + 1].setup(grid[row][col].getIncreases());
							grid[row][col] = null;
						}
					}
				}
			}
			break;

		case UP:
			for (int col = 0; col < 4; col++) {

				for (int rep = 0; rep < 3; rep++) {

					for (int row = 1; row < 4; row++) {

						// sätta samman lika tiles
						if (grid[row][col] != null && grid[row - 1][col] != null) {

							if (grid[row][col].getValue() == grid[row - 1][col].getValue()
									&& !grid[row - 1][col].getFuse() && !grid[row][col].getFuse()) {

								System.out.println("svetsade");

								grid[row - 1][col].increase();
								grid[row][col] = null;
								grid[row - 1][col].switchFuse();

							}
						}

						if (grid[row - 1][col] == null && grid[row][col] != null) {

							System.out.println("to empty"); // temp

							grid[row - 1][col] = new Tile();
							grid[row - 1][col].setup(grid[row][col].getIncreases());
							grid[row][col] = null;
						}
					}
				}
			}
			break;
		case DOWN:
			for (int col = 0; col < 4; col++) {

				for (int rep = 0; rep < 3; rep++) {

					for (int row = 2; row >= 0; row--) {

						// sätta samman lika tiles
						if (grid[row][col] != null && grid[row + 1][col] != null) {

							if (grid[row][col].getValue() == grid[row + 1][col].getValue()
									&& !grid[row + 1][col].getFuse() && !grid[row][col].getFuse()) {

								System.out.println("svetsade");

								grid[row + 1][col].increase();
								grid[row][col] = null;
								grid[row + 1][col].switchFuse();

							}
						}

						if (grid[row + 1][col] == null && grid[row][col] != null) {

							System.out.println("to empty"); // temp

							grid[row + 1][col] = new Tile();
							grid[row + 1][col].setup(grid[row][col].getIncreases());
							grid[row][col] = null;
						}
					}
				}
			}
			break;

		default:
			break;
		}

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] != null && grid[i][j].getFuse()) {
					grid[i][j].switchFuse();
				}
			}
		}

		return grid;

	}

	// en för att rotera

	// för att ta ett steg vänster

}
