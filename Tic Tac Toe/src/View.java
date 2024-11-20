import pt.iscte.guitoo.Color;
import pt.iscte.guitoo.StandardColor;
import pt.iscte.guitoo.board.Board;

public class View {
	TicTacToe model;
	Board board;

	View(TicTacToe model) {
		this.model = model;
		board = new Board("" + (model.isXTurn() ? "X" : "O") + "'s turn", 3, 3, 80);
		board.setIconProvider(this::icon);
		board.addMouseListener(this::click);
		board.setBackgroundProvider(this::background);
		board.addAction("random", this::random);
		board.addAction("new", this::newBoard);
	}

	// qual o ícone na posição (line, col)?
	// null significa não haver ícone
	String icon(int line, int col) {
		if (model.isX(line, col))
			return "x.png";
		else if (model.isO(line, col))
			return "o.png";
		else
			return null;
	}

	// executa cada vez que é clicada uma posição do tabuleiro (line, col)
	void click(int line, int col) {
		// TODO fazer movimento
		if (model.isEmpty(line, col) && !model.gameOver())
		{
			model.play(line, col);
			if (model.winner())
				board.setTitle("" + (!model.isXTurn() ? "X" : "O") + " wins!");
			else if (model.empty().length == 0)
				board.setTitle("It's a tie!");
			else
				board.setTitle("" + (model.isXTurn() ? "X" : "O") + "'s turn");
		}
	}

	// qual a cor de fundo da posição (line, col)?
	Color background(int line, int col) {
		if (model.winner())
		{
			Position[] winningGrid = model.winningGrid();
			for (int i = 0; i < winningGrid.length; i++)
				if (winningGrid[i].line() == line && winningGrid[i].col() == col)
					return StandardColor.YELLOW;
		}
		return StandardColor.WHITE;
	}

	// executa quando o botão é primido
	void newBoard() {
		TicTacToe newModel = new TicTacToe();
		View gui = new View(newModel);
		gui.start();
	}
	
	void random() {
		if (!model.gameOver())
		{
			model.playRandom();
			if (model.winner())
				board.setTitle("" + (!model.isXTurn() ? "X" : "O") + " wins!");
			else if (model.empty().length == 0)
				board.setTitle("It's a tie!");
			else
				board.setTitle("" + (model.isXTurn() ? "X" : "O") + "'s turn");
		}
	}

	void start() {
		board.open();
	}

	public static void main(String[] args) {
		View gui = new View(new TicTacToe());
		gui.start();
	}
}