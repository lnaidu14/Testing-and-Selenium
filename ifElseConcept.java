package javaBasics;

public class ifElseConcept {

	//Comparison operators -> < > <= >= == !=
	public static void main(String[] args) {
		int a =10;
		int b =10;
		
		if(b>a) {
			System.out.println("b is greater than a");
		}
		else if(a==b) {
			System.out.println("a and b are equal");
		}
		else {
			System.out.println("a is greater than b");
		}
		//write logic to find out the highest number
		int a1 = 400;
		int b1 = 200;
		int c1 = 50;
		
		//nested if-else
		if (a1>b1 & a1>c1) {
			System.out.println("a1 is the greatest");
		
		}
		else if(b1>c1) {
			System.out.println("b1 is the greatest");
		}
		else {
			System.out.println("c is the greatest");
		}
	}

}
