package com.sirma.itt.javacourse.objects.supermarket;

import java.math.BigDecimal;

public class Run {

	public static void main(String[] args) {
		Supermarket market = new Supermarket("My market");

		Employee george = new Employee("George", 23, Departments.Accounting);
		Client pesho = new Client("Pesho", 29);
		Product water = new Product("Natural water", "Water for drinking", new BigDecimal("1.99"),
				25);

		market.addClient(pesho);
		market.addEmployee(george);
		market.addProduct(water);
		market.buy(pesho.getClientID(), water.getProductID());

		System.out.println(george.getEmployeeID());

		Employee joro = new Employee("Joro", 30, Departments.Chashier);
		market.addEmployee(joro);
		System.out.println(joro.getEmployeeID());
	}
}
