package ipWeek8;
class Algebra {
	
	public static Matrix identity(int order) {
		int[] v = new int[order * order];
		Matrix m = new Matrix(new Size(order, order), v);
		for (int i = 0; i < order; i++) {
			m.setValue(i, i, 1);
		}
		return m;
	}
	
	public static void scale(Matrix m, int n) {
		for (int i = 0; i < m.dimension().lines(); i++) {
			for (int j = 0; j < m.dimension().columns(); j++) {
				m.setValue(i, j, m.getValue(i, j) * n);
			}
		}
	}
	
	public static Matrix sum(Matrix m, Matrix n) {
		assert m.dimension().equals(n.dimension());
		
		Matrix x = new Matrix(m.dimension());
		for (int i = 0; i < x.dimension().lines(); i++) {
			for (int j = 0; j < x.dimension().columns(); j++) {
				x.setValue(i, j, m.getValue(i, j) + n.getValue(i, j));
			}
		}
		return x;
	}
	
	public static Matrix transpost(Matrix m) {
		Matrix n = new Matrix(m.dimension().invertDim());
		for (int i = 0; i < n.dimension().lines(); i++) {
			for (int j = 0; j < n.dimension().columns(); j++) {
				n.setValue(i, j, m.getValue(j, i));
			}
		}
		return n;
	}
	
	public static boolean isSimetric(Matrix m) {
		if (m.dimension().lines() != m.dimension().columns())
			return false;
		for (int i = 0; i < m.dimension().lines(); i++) {
			for (int j = 0; j < m.dimension().columns(); j++) {
				if (m.getValue(i, j) != m.getValue(j, i))
					return false;
			}
		}
		return true;
	}
	
	public static Matrix mult(Matrix m, Matrix n) {
		assert m.dimension().columns() == n.dimension().lines();
		
		Size resultSize = new Size(m.dimension().lines(), n.dimension().columns());
		int[] resultVal = new int[resultSize.elements()];
		
		for (int i = 0; i < m.dimension().lines(); i++) {
			for (int j = 0; j < n.dimension().columns(); j++) {
				int sum = 0;
				for (int k = 0; k < m.dimension().columns(); k++) {
					sum += m.getValue(i, k) * n.getValue(k, j);
				}
				resultVal[i * resultSize.columns() + j] = sum;
			}
		}
		return new Matrix(resultSize, resultVal);
	}
	
}