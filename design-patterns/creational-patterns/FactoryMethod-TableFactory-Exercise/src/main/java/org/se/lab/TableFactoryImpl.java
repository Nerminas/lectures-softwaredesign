package org.se.lab;

import java.util.List;

class TableFactoryImpl implements TableFactory
{

	public TableFactoryImpl()
	{
	}


	public PersonTable createPersonTable()
	{
		return new PersonTableImpl();
	}
}
