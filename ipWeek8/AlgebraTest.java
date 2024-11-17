package ipWeek8;
import static java.lang.System.out;
class AlgebraTest {
	
	public static void main(String[] args) {
		out.println(Algebra.identity(4).toString());
		
		Matrix m = MatrixTest.naturals(new Size(4, 4));
		Algebra.scale(m, 2);
		out.println(m.toString());
		
		out.println(Algebra.sum(Algebra.identity(4), Algebra.identity(4)).toString());
		
		out.println(Algebra.transpost(m).toString());
		
		out.println(Algebra.isSimetric(m));
		out.println(Algebra.isSimetric(Algebra.identity(4)));
		
		Matrix n = Algebra.identity(4);
		Algebra.scale(n, 2);
		out.println(Algebra.mult(m, n));
	}
}