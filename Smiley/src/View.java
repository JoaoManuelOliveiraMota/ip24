import pt.iscte.guitoo.Color;
import pt.iscte.guitoo.StandardColor;
import pt.iscte.guitoo.board.Board;

public class View {
	PositionTrace model;
	Board board;

	View(PositionTrace model) {
		this.model = model;
		board = new Board("Tabuleiro", 4, 6, 40);
		board.setIconProvider(this::icon);
		board.addMouseListener(this::click);
		board.setBackgroundProvider(this::background);
		board.addAction("new", this::action);
	}

	// qual o ícone na posição (line, col)?
	// null significa não haver ícone
	String icon(int line, int col) {
		// TODO interrogar model para saber a posição atual
		if (line == model.last().line() && col == model.last().col() && model.energy() > 0)
			return "happy.png";
		else if (line == model.last().line() && col == model.last().col() && model.energy() == 0)
			return "sad.png";
		else
			return null;
	}

	// executa cada vez que é clicada uma posição do tabuleiro (line, col)
	void click(int line, int col) {
		// TODO fazer movimento
		Position p = new Position(line, col);
		if (!model.isVisited(p))
		{
			model.moveTo(p);
			board.setTitle("Energy: " + model.energy());
		}
	}

	// qual a cor de fundo da posição (line, col)?
	Color background(int line, int col) {
		// TODO interrogar model para saber se a posição foi visitada
		Position p = new Position(line, col);
		if (model.isVisited(p))
			return StandardColor.WHITE;
		else
			return StandardColor.GRAY;
	}

	// executa quando o botão é primido
	void action() {
		int energy = board.promptInt("Energia?");
		if (energy >= 0) {
			PositionTrace newModel = new PositionTrace(energy);
			View gui = new View(newModel);
			gui.start();
		}
	}

	void start() {
		board.open();
	}

	public static void main(String[] args) {
		View gui = new View(new PositionTrace(10));
		gui.start();
	}
}