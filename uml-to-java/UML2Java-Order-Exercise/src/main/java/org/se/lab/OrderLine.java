package org.se.lab;

public class OrderLine extends Entity
{
	private int quantity;
	private Product product;

	public OrderLine(long id, int quantity, Product product)
	{
		setId(id);
		setQuantity(quantity);
		setProduct(product);
	}

	public int getQuantity()
	{
		return quantity;
	}

	public void setQuantity(int quantity)
	{
		if (quantity <= 0)
		{
			throw new IllegalArgumentException();
		}
		this.quantity = quantity;
	}

	public Product getProduct()
	{
		return product;
	}

	public void setProduct(Product product)
	{
		if(product == null){
			throw new IllegalArgumentException();
		}
		this.product = product;
	}

	@Override
	public String toString()
	{
		return "OrderLine{" + "quantity=" + getQuantity() + ", product=" + getProduct().getId() + '}';
	}
}
