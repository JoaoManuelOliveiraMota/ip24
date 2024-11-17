package ipWeek8;
import static java.lang.System.out;
class CounterTest {
	public static void main(String[] args) {
		Counter c = new Counter(5);
		out.println(c.value());
		while(!c.atEnd()) {
			c.increment();
			out.println(c.value());
		}
		while(!c.atStart()) {
			c.decrement();
			out.println(c.value());
		}
	}
}
