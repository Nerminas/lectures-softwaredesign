package org.se.lab;

public class IntegerSequence
{
	private static int value;

	private IntegerSequence(){}

	public static int getNextValue(){
		return value++;
	}

	public static void setInitValue(int initValue){
		value = initValue;
	}
}
