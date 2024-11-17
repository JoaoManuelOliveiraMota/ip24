package ipWeek8;
class Calculator {
	private int value;
	
	Calculator() {
		this.value = 0;
	}
	
	int	value() {
		return this.value;
	}
	
	void plus(int x) {
		this.value += x;
	}
	
	void times(int x) {
		int	y = this.value;
		for (int i = 1; i < x; i++) {
			this.plus(y);
		}
	}
	
	void power(int x) {
		int	y = this.value;
		for (int i = 1; i < x; i++) {
			this.times(y);
		}
	}
}