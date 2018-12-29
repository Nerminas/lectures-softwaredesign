package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public class Warehouse extends Entity 
{

	public Warehouse(long id, String name) 
	{
		super(id);
		setName(name);
	}
	
	// Property: name
	private String name;
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		if (name == null)
			throw new IllegalArgumentException("ERROR: Warehouse name is null!");
		
		this.name = name;
	}
	
	/*
	 * Association: --[*]-> areas:Area
	 */
	private List<Area> areas = new ArrayList<Area>();
	public List<Area> getAreas()
	{
		return areas;
	}
	public void addArea(Area area)
	{
		if (area == null)
			throw new IllegalArgumentException("ERROR: area is null!");
		
		areas.add(area);
	}
	
}
