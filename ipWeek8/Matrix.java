package ipWeek8;
class Matrix {
	private Size size;
	private int[] values;

	public Matrix(Size size) {
		this.size = size;
		this.values = new int[size.elements()];
	}
	
	public Matrix(Size size, int[] v) {
		assert v.length == size.elements();
		this.size = size;
		this.values = new int[v.length];
		for (int i = 0; i < v.length; i++)
			this.values[i] = v[i];
	}
	
	public Size dimension() {
		return this.size;
	}
	
	public int getValue(int line, int column) {
		return this.values[line * this.size.columns() + column];
	}
	
	public void setValue(int line, int column, int value) {
		this.values[line * this.size.columns() + column] = value;
	}
	
    public String toString() {
    	String text = "";
    	text += "[";
    	for (int i = 0; i < size.lines(); i++) {
    		for (int j = 0; j < size.columns(); j++) {
    			text += values[i * size.columns() + j];
    			if (j < size.columns() - 1)
    				text += " ";
    		}
    		if (i < size.lines() - 1)
    			text += "\n ";
    	}
    	text += "]";
    	return text;
    }

}
