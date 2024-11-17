package ipWeek8;
public record Size(int lines, int columns) {
	
	public Size {
		assert lines >= 0;
		assert columns >= 0;
	}

	int elements() {
		return this.lines * this.columns;
	}
	
	boolean isSquare() {
		return this.lines == this.columns;
	}
	
	Size invertDim() {
		return new Size(this.columns, this.lines);
	}
	
	boolean isValid(int lines, int columns) {
		return lines < this.lines && columns < this.columns;
	}
}