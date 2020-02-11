package javaBasics;

public class LoopConcepts {

	public static void main(String[] args) {
		
		//1. while loop
		//disadvantage: it will generate infinite loop if you don't give increment/decrement
		int i =1;//initialization
		while(i<=10) {//condition
			System.out.println(i);
			i++;//increment/decrement
		}
		System.out.println("*****************************************");
		//2. for loop
		for(int j=1;j<=10;j++) {
			System.out.println(j);
		}

	}

}
