package ru.job4j.calculator;

/**
* Package for calculate task.
* Class Calculator решение задачи "3.1. Элементарный калькулятор"
* @author Valentin Kalinin (k-valentin_1989@yandex.ru)
* @version $Id$
* @since 06/01/2019
*/

public class Calculator {

	/**
	 * результат вычислений
	 */
	private double result;

	/**
	 * Сложение двух чисел
	 * @param first первый аргумени
	 * @param second второй аргумент
	 */

	public void add(double first, double second) {

		this.result = first + second;
	}

	/**
	 * Разность двух чисел
	 * @param first первый аргумент
	 * @param second второй аргумент
	 */

	public void subtract(double first, double second) {
		this.result = first - second;
	}

	/**
	 * Деление двух чисел (первое на второе)
	 * @param first первый аргумент
	 * @param second второй аргумент
	 */

	public void div(double first, double second) {
		this.result = first / second;
	}

	/**
	 * Умножение двух чисел
	 * @param first первый аргумент
	 * @param second второй аргумент
	 */

	public void multiple(double first, double second) {
		this.result = first * second;
	}

	/**
	 * Получение результата
	 * @return получение результата математической операции
	 */

	public double getResult() {

		return this.result;
	}
}
    
