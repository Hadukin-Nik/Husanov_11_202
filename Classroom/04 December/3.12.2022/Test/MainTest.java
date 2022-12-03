public class MainTest {
	public static void main(String[] args) {
		Line a = new Line(new Point(1,1), new Point(4,2));
		Line b = new Line(new Point(3,5), new Point(5,3));

		Line[] lines = new Line[] {a,b};

		System.out.println(a);
		System.out.println(b);

		System.out.println("Is equals: " + a.equals(b));
		System.out.println("Length of a:" + a.getLength());
		System.out.println("Square of a:" + a.getSquare());

		System.out.println("allLength:" + LineMassive.allLength(lines));
		System.out.println("isOneInMassive:" + LineMassive.isOneInMassive(lines));
	}
}