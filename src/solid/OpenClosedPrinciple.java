package solid;

/* Open/Closed Principle: Software components (methods, functions, variables) 
 * should be open for extension, but closed for modification.
 */

//class VehicleInfo {
//	public int vehicleNumber(Vehicle vcl) {
//		if (vcl instanceof Car) {
//			return vcl.getNumber();
//		}
//		if (vcl instanceof Bike) {
//			return vcl.getNumber();
//		}
//	}
//}

/* If we want to add another subclass named Truck, simply, we add one more 
 * if-statement that violates the open-closed principle. The only way to add 
 * the subclass and achieve the goal of principle by overriding the 
 * vehicleNumber() method, as shown below.
 */

class VehicleInfo {
	public int vehicleNumber() {
		return 123;
	}
}

class Car extends VehicleInfo {
	public int vehicleNumber() {
		return this.getValue();
	}

	private int getValue() {
		return 456;
	}
}

class Bike extends VehicleInfo {
	public int vehicleNumber() {
		return this.getValue();
	}

	private int getValue() {
		return 789;
	}
}

class Truck extends VehicleInfo {
	public int vehicleNumber() {
		return this.getValue();
	}

	private int getValue() {
		return 101112;
	}
}

/* Similarly, we can add more vehicles by making another subclass extending from
 * the vehicle class. This approach would not affect the existing application.
 */

public class OpenClosedPrinciple {

}
