package com.neahdemi.demo;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class NumberMain {

	public static void main(String[] args) {
		Set<Number> myCollection=new LinkedHashSet<Number>();

		Scanner scanner=new Scanner(System.in);
		
		for(int index=0;index<10;) {
		System.out.println("Enter Number : ");
		
		Number myNumber=new Number(scanner.nextInt(),index);
		int flag=0;
		for(Number element:myCollection) {
			if(element.getValue()==myNumber.getValue()) {
				flag=1;
			}
		}
		if(flag!=1) {
			myCollection.add(myNumber);
			index++;
		}
	}
		
	for(Number element:myCollection) {
		System.out.println(element);
	}
	}
}