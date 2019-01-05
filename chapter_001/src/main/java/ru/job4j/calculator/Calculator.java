package ru.job4j.calculator;

/**
* Package for calculate task.
*
* @author Valentin Kalinin (k-valentin_1989@yandex.ru)
* @version $Id$
* @since 03/01/2019
*/

public class Calculator {
	private double result;

	public void add(double first, double second) {

		this.result = first+second;
	}

	public void subtract(double first, double second){
		this.result = first-second;
	}

	public void div(double first, double second){
		this.result = first/second;
	}

	public void multiple(double first, double second)
	{
		this.result = first*second;
	}

	public double getResult() {

		return this.result;
	}
}
    
