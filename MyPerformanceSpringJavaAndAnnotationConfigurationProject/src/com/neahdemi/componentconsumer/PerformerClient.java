package com.neahdemi.componentconsumer;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.neahdemi.componentproducer.Performer;

public class PerformerClient {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext springContainer=new AnnotationConfigApplicationContext(PerformerConfiguration.class);

		Performer performer1=(Performer)springContainer.getBean("Steph");
		performer1.perform();
		
		Performer performer2=(Performer)springContainer.getBean("Gemma");
		performer2.perform();
		
		Performer performer3=(Performer)springContainer.getBean("Laura");
		performer3.perform();
		
		Performer performer4=(Performer)springContainer.getBean("Vic");
		performer4.perform();
	}

}