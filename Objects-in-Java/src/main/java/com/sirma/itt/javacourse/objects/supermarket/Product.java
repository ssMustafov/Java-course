package com.sirma.itt.javacourse.objects.supermarket;

import java.math.BigDecimal;

/**
 * Represents product.
 * 
 * @author smustafov
 */
public class Product {

	private int productID = 0;
	private String name;
	private String decsription;
	private BigDecimal price;
	private int amount;

	/**
	 * Creates a new product.
	 * 
	 * @param name
	 *            - the name of the product to be set
	 * @param description
	 *            - the description of the product to be set
	 * @param price
	 *            - the product's price
	 * @param amount
	 *            - the product's amount
	 */
	public Product(String name, String description, BigDecimal price, int amount) {
		this.name = name;
		this.decsription = description;
		this.price = price;
		this.productID++;
		this.setAmount(amount);
	}

	/**
	 * @return - the product's ID
	 */
	public int getProductID() {
		return productID;
	}

	/**
	 * @return - the product's name
	 */
	public String getProductName() {
		return name;
	}

	/**
	 * @return - the product's description
	 */
	public String getDescription() {
		return decsription;
	}

	/**
	 * @return - the product's price
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * @return - the product's amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * Sets the amount of the product.
	 * 
	 * @param amount
	 *            - the product's amount to be set
	 */
	public void setAmount(int amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("The product's amount cannot be under zero");
		}

		this.amount = amount;
	}

}
