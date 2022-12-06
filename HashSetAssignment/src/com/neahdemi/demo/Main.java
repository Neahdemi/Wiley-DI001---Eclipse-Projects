package com.neahdemi.demo;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/*
 * Exercise:Write a program that will accept 10 numbers from the user 
 * as input and store it in a collection. The numbers should not be duplicated.
 *  Also get the index position along with the number where it has to be stored.
 */

public class Main {
	
	public static void main(String args[]) {
		//Scanner
		Scanner sc = new Scanner(System.in);
		//Declare set
		Set<Number> numbers = new LinkedHashSet<Number>();
		//print prompt
		System.out.println("Lets create a collection of 10 numbers! ");
		
		//loop over 1o indexes of the set called it
		for (int i =0; i<10; i++) {
			
			//prompt for a number
			System.out.println("Please enter a number: ");
			//store input for number using scanner 
			int num = sc.nextInt();
			//create number object with index i
			Number number = new Number(num, i);
			
			//check for duplicate numbers
			int yes = 0;
			//for all the numbers in the collection
			for(Number n: numbers) {
				//if the new number is already in the collection
				if(n.getNumber() == num) {
					//print message
					System.out.println("That number is already in the set");
					//add one to yes 
					yes += 1;
				}
				
			}
			//if yes is zero - meaning no to the new number is not already used
			if(yes ==0) {
				//add it to the collections
				numbers.add(number);
			}
		}
		//display linked set of numbers and indexes
		for(Number n: numbers) {
			System.out.println(n);
		}
		
		
		
		
	}

}
