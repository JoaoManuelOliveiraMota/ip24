package ipWeek8;
import static java.lang.System.out;
class MatrixTest {
	public static void main(String[] args) {
		out.println(naturals(new Size(2, 4)).toString());
		out.println(sum(naturals(new Size(2, 4))));
		int[] v = {-1, 0, -2, 2};
		Matrix m = new Matrix(new Size(2, 2), v);
		toAbs(m);
		out.println(m.toString());
	}
	
	public static Matrix naturals(Size size) {
		int [] v = new int[size.elements()];
		for (int i = 0; i < v.length; i++) {
			v[i] = i + 1;
		}
		return new Matrix(size, v);
	}
	
	public static int sum(Matrix m) {
		int counter = 0;
		for (int i = 0; i < m.dimension().lines(); i++) {
			for (int j = 0; j < m.dimension().columns(); j++) {
				counter += m.getValue(i, j);
			}
		}
		return counter;
	}
	
	public static void toAbs(Matrix m) {
		for (int i = 0; i < m.dimension().lines(); i++) {
			for (int j = 0; j < m.dimension().columns(); j++) {
				if (m.getValue(i, j) < 0)
					m.setValue(i, j, -m.getValue(i, j));
			}
		}
	}
}