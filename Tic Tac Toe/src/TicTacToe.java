record Position(int line, int col) {

}

class TicTacToe {
	
	private static final int COLS = 3;
	private static final int EMPTY = 0;
	private static final int X = 1;
	private static final int O = 2;
	
	private int[] grid;
	private boolean xTurn;
	
	TicTacToe()
	{
		this(true);
	}
	
	TicTacToe(boolean xStart)
	{
		this.xTurn = xStart;
		this.grid = new int[COLS * COLS];
	}
	
	boolean isValid(int line, int col) {
		return line >= 0 && line < COLS && col >= 0 && col < COLS;
	}
	
	boolean isEmpty(int line, int col) {
		assert isValid(line, col);
		return grid[line * COLS + col] == EMPTY;
	}
	
	boolean isX(int line, int col) {
		assert isValid(line, col);
		return grid[line * COLS + col] == X;
	}
	
	boolean isO(int line, int col) {
		assert isValid(line, col);
		return grid[line * COLS + col] == O;
	}
	
	void play(int line, int col) {
		assert isValid(line, col);
		assert isEmpty(line, col);
		if (xTurn)
			grid[line * COLS + col] = X;
		else
			grid[line * COLS + col] = O;
		xTurn = !xTurn;
	}
	
	boolean isXTurn() {
		return this.xTurn;
	}
	
	Position[] empty() {
		int c = 0;
		for (int i = 0; i < grid.length; i++) {
			if (grid[i] == EMPTY)
				c++;
		}
		Position[] empty = new Position[c];
		int j = 0;
		for (int i = 0; i < grid.length; i++) {
			if (grid[i] == EMPTY) {
				empty[j] = new Position(i / COLS, i % COLS);
				j++;
			}
		}
		return empty;
	}
	
	void playRandom() {
		Position[] empty = empty();
		assert empty.length > 0;
		Position random = empty[(int)(Math.random() * empty.length)];
		play(random.line(), random.col());
	}
	
	boolean winner() {
		for (int i = 0; i < COLS; i++) {
			if (grid[i * COLS] != EMPTY) {
				if (grid[i * COLS] == grid[i * COLS + 1] && grid[i * COLS] == grid[i * COLS + 2])
					return true;
			}
		}
		for (int i = 0; i < COLS; i++) {
			if (grid[i] != EMPTY) {
				if (grid[i] == grid[i + COLS] && grid[i] == grid[i + 2 * COLS])
					return true;
			}
		}
		if (grid[0] != EMPTY && grid[0] == grid[COLS + 1] && grid[0] == grid[grid.length - 1])
			return true;
		if (grid[COLS - 1] != EMPTY && grid[COLS - 1] == grid[COLS + 1] && grid[COLS - 1] == grid[2 * COLS])
			return true;
		return false;
	}
	
	Position[] winningGrid() {
		Position[] winningGrid = new Position[COLS];
		for (int i = 0; i < COLS; i++) {
			if (grid[i * COLS] != EMPTY) {
				if (grid[i * COLS] == grid[i * COLS + 1] && grid[i * COLS] == grid[i * COLS + 2]) {
					for (int j = 0; j < COLS; j++)
						winningGrid[j] = new Position(i, j);
				}
			}
		}
		for (int i = 0; i < COLS; i++) {
			if (grid[i] != EMPTY) {
				if (grid[i] == grid[i + COLS] && grid[i] == grid[i + 2 * COLS])
					for (int j = 0; j < COLS; j++)
						winningGrid[j] = new Position(j, i);
			}
		}
		if (grid[0] != EMPTY && grid[0] == grid[COLS + 1] && grid[0] == grid[grid.length - 1])
			for (int i = 0; i < COLS; i++)
				winningGrid[i] = new Position(i, i);
		if (grid[COLS - 1] != EMPTY && grid[COLS - 1] == grid[COLS + 1] && grid[COLS - 1] == grid[2 * COLS])
			for (int i = 0; i < COLS; i++)
				winningGrid[i] = new Position(COLS - 1 - i, COLS - 1 - i);
		return winningGrid;
	}
	
	boolean gameOver() {
		if (empty().length == 0 || winner())
			return true;
		else
			return false;
	}
}