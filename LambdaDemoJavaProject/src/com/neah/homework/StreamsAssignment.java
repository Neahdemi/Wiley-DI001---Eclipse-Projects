package com.neah.homework;

import java.util.Arrays;
import java.util.List;

//Create a list of integers and count how many are negative in that list
//'.count()' returns 'long' objects so make the object a long:
//to count how many objects in the stream are negative:
//long tNoN = list.stream().filter((t) -> t<0).count()
public class StreamsAssignment {
	
	public static void main(String [] args) {
		
		
		List<Integer> numbers = Arrays.asList(-1,-2,-3,-4,3,5,6,8,5,3,-10);
		
		
		//System.out.println("Total No Of Elements: " + numbers.stream().count());
		

		long total = numbers.stream().filter((n)->n<0).count();	
		
		System.out.println("Negative numbers count: " + total);
		
			
		}
		
	}
	


