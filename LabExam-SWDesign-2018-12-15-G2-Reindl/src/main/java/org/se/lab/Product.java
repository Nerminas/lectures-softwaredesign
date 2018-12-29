package org.se.lab;

public class Product extends Entity 
{

	public Product(long id, String description) 
	{
		super(id);
		setDescription(description);
	}
	
	/*
	 * Property: description:String
	 */
	private String description;
	public String getDescription() 
	{
		return description;
	}
	public void setDescription(String description) 
	{
		if (description == null)
			throw new IllegalArgumentException("ERROR: Description is null!");
		
		this.description = description;
	}

}
