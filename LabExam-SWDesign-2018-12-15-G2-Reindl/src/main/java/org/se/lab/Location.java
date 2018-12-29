package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public class Location extends Entity
{
	private List<Bundle> bundles = new ArrayList();

	public Location(long id, Bundle bundle)
	{
		super(id);
		setBundles(bundles);
	}

	public Location(long id)
	{
		super(id);
	}

	public List<Bundle> getBundles()
	{
		return bundles;
	}

	public void setBundles(List<Bundle> bundles)
	{
		this.bundles = bundles;
	}

	public void addBundle(Bundle bundle){
		if(bundle != null){
			this.bundles.add(bundle);
		}
	}
}
