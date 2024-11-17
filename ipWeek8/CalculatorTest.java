package ipWeek8;
import static java.lang.System.out;
class CalculatorTest {
	public static void main(String[] args) {
		Calculator c = new Calculator();
		out.println(c.value());
		c.plus(2);
		out.println(c.value());
		c.times(4);
		out.println(c.value());
		c.power(3);
		out.println(c.value());
	}
}
