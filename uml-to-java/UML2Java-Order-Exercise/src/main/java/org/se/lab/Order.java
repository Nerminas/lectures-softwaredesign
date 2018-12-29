package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public class Order extends Entity
{
	private String name;
	private List<OrderLine> orderLines = new ArrayList<>();

	public Order(long id, String name)
	{
		setId(id);
		setName(name);
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		if (name == null){
			throw new IllegalArgumentException();
		}
		this.name = name;
	}

	public List<OrderLine> getOrderLines()
	{
		return orderLines;
	}

	public void addOrderLine(OrderLine orderLine)
	{
		orderLines.add(orderLine);
	}
}
