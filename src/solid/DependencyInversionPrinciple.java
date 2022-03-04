package solid;

/* Dependency Inversion Principle: Classes should depend on abstraction but not 
 * on concretion. High-level modules should not depend on the low-level module 
 * but both should depend on the abstraction. 
 */

/* The following violates DIP */
/*
// Desktop class is highly coupled to Monitor, Keyboard classes
class Desktop {
	private Monitor monitor;
	private Keyboard keyboard;
	
	public Desktop() {
		this.monitor = new Monitor();
		this.keyboard = new Keyboard();
	}
}

class Monitor {}

class Keyboard {}
*/

class Desktop {
	private Monitor monitor;
	private Keyboard keyboard;
	
	public Desktop(Monitor monitor, Keyboard keyboard) {
		this.monitor = monitor;
		this.keyboard = keyboard;
	}
}

interface Monitor {}

interface Keyboard {}

class LCDMonitor implements Monitor {}

class QwertyKeyboard implements Keyboard {}

/* We can introduce new types of Monitor and Keyboard but the Desktop class
 * doesn't need to modified.
 */

public class DependencyInversionPrinciple {

	public static void main(String[] args) {
		Desktop desktop = new Desktop(new LCDMonitor(), new QwertyKeyboard());
	}

}
