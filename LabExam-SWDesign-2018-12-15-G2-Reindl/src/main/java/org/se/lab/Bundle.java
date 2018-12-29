package org.se.lab;

public class Bundle extends Entity
{
	private int quantity;
	private Product product;

	public Bundle(long id, int quantity)
	{
		super(id);
		setQuantity(quantity);
	}

	public Bundle(long id, Product product, int quantity )
	{
		super(id);
		setQuantity(quantity);
		setProduct(product);
	}

	public int getQuantity()
	{
		return quantity;
	}

	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}

	public Product getProduct()
	{
		return product;
	}

	public void setProduct(Product product)
	{
		this.product = product;
	}
}
