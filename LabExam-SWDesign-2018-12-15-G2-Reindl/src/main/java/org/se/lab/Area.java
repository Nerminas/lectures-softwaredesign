package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public class Area extends Entity
{
	public Area(long id, String description) 
	{
		super(id);
		setDescription(description);
	}


	
	// Property: desc:String
	private String description;
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description=description;
	}
	
	/*
	 * Association: --[*]-> locations:Location
	 */
	private List<Location> locations = new ArrayList<Location>();
	public List<Location> getLocations()
	{
		return this.locations;
	}
	public void addLocation(Location location)
	{
		if (location == null)
			throw new IllegalArgumentException("ERROR: location is null!");
		
		this.locations.add(location);
	}
	

	/*
	 * Association: --[1]-> parentArea:Area
	 */
	private Area parentArea;
	public Area getParentArea() 
	{
		return parentArea;
	}
	public void setParentArea(Area area) 
	{
		this.parentArea = area;
	}
	
	/*
	 * Association: --[*]-> childAreas:Area
	 */
	private List<Area> childAreas = new ArrayList<Area>();
	public List<Area> getChildAreas()
	{
		return this.childAreas;
	}
	public void addChildArea(Area area)
	{
		this.childAreas.add(area);
	}
	
	// todo: addArea child, dazugehöriger parent area wird automatisch gesetzt


	public void setLocations(List<Location> locations)
	{
		this.locations = locations;
	}

	public void setChildAreas(List<Area> childAreas)
	{
		this.childAreas = childAreas;
	}
}
