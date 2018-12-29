package org.se.lab;

import java.util.Objects;

public class Product extends Entity
{
	private String description;
	private long price;


	public Product(long id, String description, long price){
		setId(id);
		setDescription(description);
		setPrice(price);
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		if(description == null){
			throw new IllegalArgumentException();
		}
		this.description = description;
	}

	public long getPrice()
	{
		return price;
	}

	public void setPrice(long price)
	{
		if (price < 0){
			throw new IllegalArgumentException();
		}
		this.price = price;
	}

	@Override
	public String toString()
	{
		return "Product{" + "description='" + getDescription() + '\'' + ", price=" + getPrice() + '}';
	}
}
