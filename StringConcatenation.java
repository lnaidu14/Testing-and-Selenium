package javaBasics;

public class StringConcatenation {

	public static void main(String[] args) {
		int a = 100;
		int b = 200;
		
		String x = "Hello";
		String y = "World";
		
		
		//+ is the concatenation operator
		
		System.out.println(a+b); //300
		System.out.println(x+y);//HelloWorld
		System.out.println(a+b+x+y);//300HelloWorld
		System.out.println(x+y+a+b);//HelloWorld100200
		System.out.println(x+y+(a+b));//HelloWorld300
		System.out.println(a+b+x+y+a+x+b+y);//300HelloWorld100Hello200World
	
		System.out.println("The value of a is: "+a);
		System.out.println("the addition of a and b is: "+(a+b));
		//println is used for printing on a new line whereas print is just used to print it in the same line
		System.out.print("hello selenium");
		System.out.print("hello testing");

	}

}
