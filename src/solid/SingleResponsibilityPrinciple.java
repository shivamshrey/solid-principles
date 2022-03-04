package solid;

/* Single Responsibility Principle: This principle states that “a class should 
 * have only one reason to change” which means every class should have a single 
 * responsibility or single job or single purpose. 
 */

/* Student class has three responsibilities to print the details of students, 
 * calculate percentages, and database.  
 */

//class Student {
//	public void addStudent() {
//	}
//
//	public void printDetails() {
//	}
//
//	public void calculatePercentage() {
//	}
//}

/* The above code snippet violates the single responsibility principle. 
 * To achieve the goal of the principle, we should implement a separate class 
 * that performs a single functionality only.
 */

class Student {
	public void addStudent() {
	}
}

class PrintStudentDetails {
	public void printDetails() {
	}
}

class Percentage {
	public void calculatePercentage() {
	}
}

/* Hence, we have achieved the goal of the single responsibility principle by
 * separating the functionality into three separate classes.
 */

public class SingleResponsibilityPrinciple {

}
