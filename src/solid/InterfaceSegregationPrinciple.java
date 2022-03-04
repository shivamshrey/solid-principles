package solid;

/* Interface Segregation Principle: Clients should not be forced to implement 
 * unnecessary methods which they will not use.
 */

// The following violates Interface Segregation Principle
/*
interface Shape {
	void calculateArea();
	void calculateVolume();
}

class Square implements Shape {
	
	private int side;
	
	public Square(int side) {
		this.side = side;
	}
	
	@Override
	public void calculateArea() {
		System.out.println(side * side);
	}

	// Even though square has no volume but it still has to implement calculateVolume()
	@Override
	public void calculateVolume() {
		throw new UnsupportedOperationException("A square has no volume");
	}
	
}

class Cube implements Shape {
	
	private int side;

	public Cube(int side) {
		super();
		this.side = side;
	}

	@Override
	public void calculateArea() {
		System.out.println(side * side * 6);
	}

	@Override
	public void calculateVolume() {
		System.out.println(side * side * side);
	}
	
}
*/

interface TwoDimensionalShape {
	void calculateArea();
}

interface ThreeDimensionalShape {
	void calculateVolume();
}

// Now Square class doesn't have to implement calculateVolume() unnecessarily
class Square implements TwoDimensionalShape {

	private int side;
	
	public Square(int side) {
		this.side = side;
	}
	
	@Override
	public void calculateArea() {
		System.out.println(side * side);
	}
	
}

class Cube implements TwoDimensionalShape, ThreeDimensionalShape {
	 
	private int side;

	public Cube(int side) {
		super();
		this.side = side;
	}

	@Override
	public void calculateVolume() {
		System.out.println(side * side * side);
	}

	@Override
	public void calculateArea() {
		System.out.println(side * side * 6);
	}
	
}

public class InterfaceSegregationPrinciple {

	public static void main(String[] args) {
		new Square(7).calculateArea();
		new Cube(7).calculateArea();
		new Cube(7).calculateVolume();
	}

}
