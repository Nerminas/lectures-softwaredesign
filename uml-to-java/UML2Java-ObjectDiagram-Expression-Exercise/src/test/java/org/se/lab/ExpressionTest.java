package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ExpressionTest
{
	private Expression expr;
	
	@Before
	public void setup()
	{
		Expression e1 = new OperationAdd();
		e1.addExpression(new Number(3));
		e1.addExpression(new Number(4));

		Expression e2 = new OperationMul();
		e2.addExpression(new Number(2));
		e2.addExpression(e1);

		expr = new OperationAdd();
		expr.addExpression(new Number(1));
		expr.addExpression(e2);
		expr.addExpression(new Number(5));
	}

	
	@Test
	public void testExpression_expr()
	{
		Assert.assertNotNull(expr);
		Assert.assertTrue(expr instanceof OperationAdd);
		Assert.assertEquals(3, expr.getExpressions().size());

		Assert.assertTrue(expr.getExpressions().get(0) instanceof Number);
		Assert.assertTrue(expr.getExpressions().get(1) instanceof OperationMul);
		Assert.assertTrue(expr.getExpressions().get(2) instanceof Number);
	}
	
	@Test
	public void testExpression_e2()
	{
		Expression e2 = expr.getExpressions().get(1);

		Assert.assertNotNull(e2);
		Assert.assertTrue(e2 instanceof OperationMul);
		Assert.assertEquals(2, e2.getExpressions().size());
		
		Assert.assertTrue(e2.getExpressions().get(0) instanceof Number);
		Assert.assertTrue(e2.getExpressions().get(1) instanceof OperationAdd);
	}

	@Test
	public void testExpression_e1()
	{
		Expression e1 = expr.getExpressions().get(1).getExpressions().get(1);

		Assert.assertNotNull(e1);
		Assert.assertTrue(e1 instanceof OperationAdd);
		Assert.assertEquals(2, e1.getExpressions().size());
		
		Assert.assertTrue(e1.getExpressions().get(0) instanceof Number);
		Assert.assertTrue(e1.getExpressions().get(1) instanceof Number);		
	}
}
