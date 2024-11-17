package ipWeek8;
class Counter {
	private int value;
	private int max;

    Counter(int max) {
    	assert max > 0;
    	this.value = 0;
    	this.max = max;
    }
    
    int value() {
    	return this.value;
    }
    
    boolean atStart() {
    	return this.value == 0;
    }
    
    boolean atEnd() {
    	return this.value == max;
    }
    
    void increment() {
    	this.value++;
    }
    
    void decrement() {
    	this.value--;
    }
}
