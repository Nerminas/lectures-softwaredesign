package org.se.lab;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class WarehouseTest
{
    private Warehouse warehouse;

    @Before
    public void setUp()
    {
        warehouse = new Warehouse(1l, "Lager-001");

        Area food = new Area(1l, "Lebensmittel");
        Area foodFreeze = new Area(2l, "Tiefkühlbereich");
        Area foodCool = new Area(3l, "Kühlbereich");

        warehouse.addArea(food);        
        food.addChildArea(foodFreeze);
        food.addChildArea(foodCool);
        foodFreeze.setParentArea(food);
        foodCool.setParentArea(food);
        
        Location loc1 = new Location(1);
        loc1.addBundle(new Bundle(1, new Product(3, "Pizza"), 30));
        loc1.addBundle(new Bundle(2, new Product(4, "Germknödel"), 30));
        foodFreeze.addLocation(loc1);
        
        Location loc2 = new Location(2);
        loc2.addBundle(new Bundle(3, new Product(1, "Milch"), 10));
        loc2.addBundle(new Bundle(4, new Product(2, "Käse"), 10));
        foodCool.addLocation(loc2);
    }

    
    @Test
    public void testWarehouseAreas()
    {
        assertEquals(1, warehouse.getAreas().size());

        Area fd = warehouse.getAreas().get(0);
        assertEquals("Lebensmittel", fd.getDescription());

        // check if food contains two areas
        assertEquals(2, fd.getChildAreas().size());

        Area frz = fd.getChildAreas().get(0);
        assertEquals("Tiefkühlbereich", frz.getDescription());

        Area cl = fd.getChildAreas().get(1);
        assertEquals("Kühlbereich", cl.getDescription());

        // check if navigation from sub- to parent area is possible
        assertEquals(frz.getParentArea(), fd);
        assertEquals(cl.getParentArea(), fd);
    }

    @Test
    public void testAreaLocations()
    {
        Area frz = warehouse.getAreas().get(0).getChildAreas().get(0);
        Area cl = warehouse.getAreas().get(0).getChildAreas().get(1);

        assertEquals(1, frz.getLocations().get(0).getId());
        assertEquals(2, cl.getLocations().get(0).getId());
    }

    @Test
    public void testLocationAndBundles()
    {
        Location r1 = warehouse.getAreas().get(0).getChildAreas().get(0).getLocations().get(0);
        Location r2 = warehouse.getAreas().get(0).getChildAreas().get(1).getLocations().get(0);

        assertEquals(1, r1.getId());
        assertEquals(2, r2.getId());

        assertEquals(1, r1.getBundles().get(0).getId());
        assertEquals(2, r1.getBundles().get(1).getId());
        assertEquals(3, r2.getBundles().get(0).getId());
        assertEquals(4, r2.getBundles().get(1).getId());
    }

    @Test
    public void testBundlesAndProducts()
    {
        Bundle b1 = warehouse.getAreas().get(0).getChildAreas().get(0).getLocations().get(0).getBundles().get(0);
        Bundle b2 = warehouse.getAreas().get(0).getChildAreas().get(0).getLocations().get(0).getBundles().get(1);
        Bundle b3 = warehouse.getAreas().get(0).getChildAreas().get(1).getLocations().get(0).getBundles().get(0);
        Bundle b4 = warehouse.getAreas().get(0).getChildAreas().get(1).getLocations().get(0).getBundles().get(1);

        assertEquals(1l, b1.getId());
        assertEquals(2l, b2.getId());
        assertEquals(3l, b3.getId());
        assertEquals(4l, b4.getId());

        assertEquals("Pizza", b1.getProduct().getDescription());
        assertEquals(30, b1.getQuantity());

        assertEquals("Germknödel", b2.getProduct().getDescription());
        assertEquals(30, b2.getQuantity());

        assertEquals("Milch", b3.getProduct().getDescription());
        assertEquals(10, b3.getQuantity());

        assertEquals("Käse", b4.getProduct().getDescription());
        assertEquals(10, b4.getQuantity());
    }
}
